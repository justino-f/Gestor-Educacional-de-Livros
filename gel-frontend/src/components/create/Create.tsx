import { useState } from 'react';
import { useUserData } from '../../hooks/useUserDataMutate'
import { type UserData } from '../../interface/UserData'

interface InputProps {
  label : string,
  value: string | number,
  updateValue(value: unknown) : void
}

const Input = ({ label, value, updateValue} : InputProps) => {
  return (
    <>
      <label>{label}</label>
      <input value={value} onChange={event => updateValue(event.target.value)}></input>
    </>
  )
}

export function Create(){
  const [userName, setUserName] = useState("");
  const [userCpf, setUserCpf] = useState(0);
  const [userEmail, setUserEmail] = useState("");
  const [userPhone, setUserPhone] = useState("");
  const [userRole, setUserRole] = useState("");
  const [userBirthdate, setUserBirthDate] = useState("");
  const [userPassword, setUserPassword] = useState("");
  const { mutate } = useUserData();

  const submit = () => {
    const userData: UserData = {
      userName,
      userCpf,
      userEmail,
      userPhone,
      userRole,
      userBirthdate,
      userPassword
    }

    mutate(userData);
  }

  return(
    <div className="overlay">
      <div className="body">
        <h2>Cadastre um novo usuário</h2>
        <form className="input-container">
          <Input label="Nome Completo" value={userName} updateValue={setUserName}></Input>
          <Input label="CPF" value={userCpf} updateValue={setUserCpf}></Input>
          <Input label="E-mail" value={userEmail} updateValue={setUserEmail}></Input>
          <Input label="Telefone" value={userPhone} updateValue={setUserPhone}></Input>
          <Input label="Função" value={userRole} updateValue={setUserRole}></Input>
          <Input label="Data de Nascimento" value={userBirthdate} updateValue={setUserBirthDate}></Input>
          <Input label="Senha" value={userPassword} updateValue={setUserPassword}></Input>
        </form>
        <button onClick={submit} className="btn-secondary">Cadastrar</button>
      </div>
    </div>
  )

}