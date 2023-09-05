import userContext from "../Context/userContext";
import { useContext } from "react";

// function UserSignup=(user)=>{
//         const [registeredUser, setRegisteredUser] = useContext(userContext);
//         setRegisteredUser({...registeredUser,user})
//         console.log(registeredUser);
//     return console.log("signup successfully")
// }

 const UserLogin=(loginDetail)=>{
    console.log(loginDetail);
    const users=useContext(userContext)
    if(users.user.email===loginDetail.email){
    return console.log("login successfull!!!!")
    }
    else{
        return console.log("failed")
    }
}

export default UserLogin;
