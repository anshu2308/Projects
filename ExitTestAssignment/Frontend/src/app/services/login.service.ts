import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  public loginStatusSubject=new Subject<boolean>();
  constructor(private _http: HttpClient) {}

  //generate token
  public generateToken(loginData:any){
   return this._http.post<any>(`${baseUrl}/generate-token`,loginData);
  }

  //save token in local Storage
  public loginUser(token:any){
    localStorage.setItem("token",token);
    return true;
  }

  //check user is logged in or not
  public isLoggedIn()
  {
    let tokenStr=localStorage.getItem("token")
    if(tokenStr==undefined || tokenStr==''||tokenStr==null){
      return false;
    }
      else{
        return true;
      }
    }
    //current logged in user 
   public getCurrentUser(){
    return this._http.get(`${baseUrl}/current-user`);
   }
  //logout
  public logout() {
    localStorage.removeItem("token");
    localStorage.removeItem('user');
    return true;
  }

  //get Token from local Storage
  public getToken(){
    return localStorage.getItem('token');
  }

  //set UserDetails
  public setUser(user:any){
    localStorage.setItem('username',user.username);
    localStorage.setItem('user',JSON.stringify(user));
  }

  //get Userdetails
  public getUser(){
    let userStr=localStorage.getItem("user");
    if(userStr!=null){
      return JSON.parse(userStr);
    }
    else{
      this.logout();
      return null;
    }
    }

    //get user role
    public getUserRole(){
      let user=this.getUser();
      return user.authorities[0].authority;

    }

  }
  

 

