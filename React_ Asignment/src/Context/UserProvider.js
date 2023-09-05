import React,{useState} from 'react'
import userContext from './userContext'

function UserProvider({children}) {


  const [users,setUsers]=useState(
//     [
//         {
//             name:'Anshu',
//     email:'anshu@gmail.com',
//     password:'anshu'
// },
  {
            name:'admin',
    email:'admin@gmail.com',
    password:'admin'
}
    // ]
  );



  return (
   <userContext.Provider value={users} >
  {children}
   </userContext.Provider>
  )
}

export default UserProvider