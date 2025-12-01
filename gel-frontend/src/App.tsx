import './App.css'
import { Create } from './components/create/Create';
import { List } from './components/list/List'
import { useUserData } from './hooks/useUserData';
import { useState } from 'react';

function App() {
  const { data } = useUserData();
  const [isModalOpen, setIsModalOpen] = useState(false);
  const handleOpenModal = () => {
    setIsModalOpen(prev => !prev)
  }


  return (
    <>
      <div className="container">
        <h1>Usuários</h1>
        <div className="list">
          {data?.map(userData =>
          <List
            key={userData.userId}
            userId={userData.userId}
            userName={userData.userName}
            userCpf={userData.userCpf}
            userEmail={userData.userEmail}
            userPhone={userData.userPhone}
            userBirthdate={userData.userBirthdate}
            userRole={userData.userRole}
          />
        )}
        </div>
        {isModalOpen && <Create/>}
        <button onClick={handleOpenModal}>Novo</button>
      </div>
    </>
  )
}

export default App
