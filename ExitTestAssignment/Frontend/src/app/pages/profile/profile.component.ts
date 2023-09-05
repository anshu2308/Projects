import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user=null;
  role:any;
  constructor(public _login:LoginService) { }

  ngOnInit(): void {
    this.user =this._login.getUser();
    console.log(this._login.getUserRole());
    this.role = this._login.getUserRole();
  }

}
