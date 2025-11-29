package com.uniaraxa.gel.core.dtos;

import com.uniaraxa.gel.core.entities.Roles;

public record CreateUserDto(String userName, long userCpf, String userEmail,
                            String userPhone, String userBirthdate, Roles userRole,
                            String userPassword) {
}
