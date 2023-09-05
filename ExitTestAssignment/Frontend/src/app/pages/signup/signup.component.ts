import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { FormBuilder, FormGroup, Validators } from '@angular/forms'
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  public signupForm!: FormGroup;
  constructor(private _login:LoginService,private formBuilder: FormBuilder, private _route: ActivatedRoute, private _userSerive: UserService, private _snack: MatSnackBar, private _router: Router) { }
  public user = {
    username: '',
    password: '',
    emailId: '',
    phone: '',
   userType:{
     roleId: this._route.snapshot.params.id,
    }
  };
  public roles=[
    {
      roleId: 1,
      roleName:'',
    }
  ]
  ngOnInit(): void {
    this.user.userType.roleId = this._route.snapshot.params.id;
    this.signupForm = this.formBuilder.group({
      username: ['', [Validators.required,Validators.minLength(3)]],
      password: ['',[ Validators.required, Validators.minLength(3)]],
      emailId: ['', [Validators.required,Validators.email]],
      cpassword: ['', [Validators.required]],
      phone: ['', [Validators.minLength(10), Validators.maxLength(10), Validators.pattern('[0-9]+$')]]
    })
    this._userSerive.getRoles().subscribe(
      (data:any)=>{
        this.roles=data;
      },
      (error)=>{
this._snack.open("roles not find","ok");
      }
    )
  }

  register() {
    console.log(this.user);
    // if (this.user.password == '' || this.user.userName == '' || this.user.emailId == '') {
    //   if (this.user.userName == '' || this.user.userName == null) {
    //     this._snack.open("Username is required!!", 'OK', {
    //       duration: 2500,
    //       // verticalPosition:'top'
    //   });
    //   }
    //   else if (this.user.password == '' || this.user.password == null) {
    //     this._snack.open("password is required!!", 'OK', {
    //       duration: 2500,
    //     });
    //   }
    //   else if (this.user.emailId == '') {
    //     this._snack.open("EmailId is required!!", 'OK', {
    //       duration: 3000,
    //     });
    //   }
    // }
    // else {
     if(this.signupForm.valid){
       console.log(this.user.userType.roleId);
       this._userSerive.addUser(this.user).subscribe(
         (data: any) => {
           console.log(data);
           Swal.fire('Successfully done!!', 'User is registered with id' + data.id, 'success');
           this._router.navigate(['login']);
         },
         (error) => {
           console.log(error);
           this._snack.open("Username already exist!!", '', {
             duration: 3000,
           })
         })
     }
     else{
       this._snack.open("Fill the all the required field !!!", 'OK', {
         duration: 3000,
       });
     }
  }
  // }
  get username() {
    return this.signupForm.get('username');
  }
  get phone() {
    return this.signupForm.get('phone');
  }
  get emailId() {
    return this.signupForm.get('emailId');
  }
  get password() {
    return this.signupForm.get('password');
  }
  get cpassword() {
    return this.signupForm.get('cpassword');
  }
}
