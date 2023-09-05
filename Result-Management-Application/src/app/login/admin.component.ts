import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import{FormBuilder,FormGroup, Validators} from '@angular/forms'
import { Router } from '@angular/router';
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  public loginForm!:FormGroup;
  constructor(private formBuilder:FormBuilder,private http:HttpClient,private router:Router) { }

  ngOnInit(): void {
    this.loginForm=this.formBuilder.group({
      name: ['', Validators.required],
      password: ['', Validators.required]
    })
  }
  login(){
    if (this.loginForm.value.name != "" && this.loginForm.value.password != "") {
    this.http.get<any>("http://localhost:3000/Teachers")
      .subscribe(res=>{
        
      const user=res.find((a:any)=>{
      return a.name===this.loginForm.value.name && a.password===this.loginForm.value.password
      });
      
      if(user){
        alert("Login Success");
        this.loginForm.reset();
        this.router.navigate(['teacher'])
      }
      else{
        alert("Invalid User/Password")
      }
  },err=>{
    alert("something went wrong!!")
  })
  }
}
}
