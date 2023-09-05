import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginData = {
    username: '',
    password: ''
  }
  msg = '';
  constructor(private _snack: MatSnackBar, private _userService: UserService, private _route: Router, private _login: LoginService) { }

  ngOnInit(): void {
  }
  login() {
    console.log(this.loginData.username)
    if (this.loginData.password.trim() == '' || this.loginData.password == null || this.loginData.username.trim() == '' || this.loginData.username == null) {
      this._snack.open("Username/Password is required!!!", 'OK', { duration: 3000 });
    }
    // if(this.loginData.userName.trim()==''|| this.loginData.userName==null)
    // {
    //   this._snack.open("Username is required!!!",'OK',{duration:3000});
    // }
    else {
      this._login.generateToken(this.loginData).subscribe(
        (data: any) => {
          console.log("success");
          console.log(data);

          //postSuccessfull login
          this._login.loginUser(data.token);
          this._login.getCurrentUser().subscribe(
            (user: any) => {
              this._login.setUser(user);
              console.log(user);
              if (this._login.getUserRole() == 'Customer') {
                // window.location.href = '/customer';
                this._route.navigate(['customer/products']);
                this._login.loginStatusSubject.next(true);
              }
              else if (this._login.getUserRole() == 'Vendor') {
                // window.location.href = '/vendor';
                 this._route.navigate(['vendor/products']);
                this._login.loginStatusSubject.next(true);
              }
              else {
                this._login.logout();
              }
            });
        },
        (error) => {
          console.log("Error!!!");
          console.log(error);
          this.msg = "Bad Credentials,Please enter valid emailId and password ";
          this._login.logout();
        }
      );
      // this._userService.loginUserFromRemote(this.loginData).subscribe(
      //   data => {
      //     this._route.navigate(['/loggedin']);
      //     console.log("reponse received");
      //     this.msg = "";
      //   },
      //   error => {
      //     console.log("exception occured");
      //     this.msg = "Bad Credentials,Please enter valid emailId and password ";
      //   }
      // );
    }
  }
}
