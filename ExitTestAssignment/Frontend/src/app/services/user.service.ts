import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }

  //add User
  public addUser(user:any){
    return this.http.post<any>(`${baseUrl}/user/`,user);
  }

  //login
  public loginUserFromRemote(user: any) {
    return this.http.post<any>(`${baseUrl}/user/login`, user)
  }

  public getRoles(){
    return this.http.get<any>(`${baseUrl}/user/roles`)
  }
}
