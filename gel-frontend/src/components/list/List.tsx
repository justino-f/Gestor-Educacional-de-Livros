interface ListProps {
  userId: number | undefined,
  userName: string,
  userCpf: number,
  userEmail: string,
  userPhone: string,
  userBirthdate: string,
  userRole: string

}

export function List({userId, userName, userCpf, userEmail, userPhone, userBirthdate, userRole }: ListProps){
  return(
    <div className="list">
      <h2>{userName}</h2>
      <p>{userCpf}</p>
      <p>{userId}</p>
      <p>{userEmail}</p>
      <p>{userPhone}</p>
      <p>{userBirthdate}</p>
      <p>{userRole}</p>
    </div>
  )
}