import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup,FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-st-login',
  templateUrl: './st-login.component.html',
  styleUrls: ['./st-login.component.css']
})
export class StLoginComponent implements OnInit {
  public loginForm!: FormGroup;
  constructor(private formBuilder: FormBuilder, private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      name: ['',Validators.required],
      password: ['',Validators.required]
    })
  }
  
  login() {
    if (this.loginForm.value.name != "" && this.loginForm.value.password != "") {

    this.http.get<any>("http://localhost:3000/students")
      .subscribe(res => {
        const user = res.find((a: any) => {
          return a.name === this.loginForm.value.name && a.password === this.loginForm.value.password
        });

        if (user) {
          alert("Login Success");
          this.loginForm.reset();
          this.router.navigate(['findresult'])
        }
        else {
          this.loginForm.reset();
          alert("Invalid Username/Password")
        }
        
      }, err => {
        alert("something went wrong!!")
      })
    }
  }
}


