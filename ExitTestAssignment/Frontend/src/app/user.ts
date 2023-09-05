export class User {
    id: number | undefined;
    emailId: string | undefined;
    username: string | undefined;
    password: string | undefined;
    enable: String | undefined;
    phone: String | undefined;
   role:[{
       id: string;
       name: string;
   }] | undefined;
    constructor(id: number,
        emailId: string,
        username: string,
        password: string, enable: String ,
        phone: String ,
        role: [{
            id: string;
            name: string;
        }] ){
            this.id=id;
            this.emailId=emailId;
            this.username=username;
            this.password=password;
            this.enable=enable;
            this.phone=phone;
            this.role=role;
        }
    }