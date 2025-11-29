package com.uniaraxa.gel.core.services;

import com.uniaraxa.gel.core.dtos.CreateUserDto;
import com.uniaraxa.gel.core.dtos.UpdateUserDto;
import com.uniaraxa.gel.core.entities.User;
import com.uniaraxa.gel.core.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UUID createUser(CreateUserDto createUserDto){
        var entity = new User(
                createUserDto.userName(),
                createUserDto.userCpf(),
                createUserDto.userEmail(),
                createUserDto.userPhone(),
                createUserDto.userBirthdate(),
                createUserDto.userRole(),
                createUserDto.userPassword()
        );

        var userSaved = userRepository.save(entity);
        return userSaved.getUserId();
    }

    public Optional<User> getUserById(String userId){
        return userRepository.findById(UUID.fromString(userId));
    }

    public List<User> listUsers(){
        return userRepository.findAll();
    }

    public void updateUserById(String userId, UpdateUserDto updateUserDto){
        var id = UUID.fromString(userId);

        var userEntity = userRepository.findById(id);

        if (userEntity.isPresent()){
            var user = userEntity.get();

            if (updateUserDto.userName() != null){
                user.setUserName(updateUserDto.userName());
            }

            if (updateUserDto.userCpf() != 0){
                user.setUserCpf(updateUserDto.userCpf());
            }

            if (updateUserDto.userEmail() != null){
                user.setUserEmail(updateUserDto.userEmail());
            }

            if (updateUserDto.userPhone() != null){
                user.setUserPhone(updateUserDto.userPhone());
            }

            if (updateUserDto.userBirthdate() != null){
                user.setUserBirthdate(updateUserDto.userBirthdate());
            }

            if (updateUserDto.userRole() != null){
                user.setUserRole(updateUserDto.userRole());
            }

            if (updateUserDto.userPassword() != null){
                user.setUserPassword(updateUserDto.userPassword());
            }
            userRepository.save(user);
        }
    }

    public void deleteById(String userId){
        var id = UUID.fromString(userId);

        var userExists = userRepository.existsById(id);

        if (userExists){
            userRepository.deleteById(id);
        }
    }


}
