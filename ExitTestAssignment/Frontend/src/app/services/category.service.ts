import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private _http:HttpClient) { }

  public getcategories(){
    return this._http.get<any>(`${baseUrl}/category/`);
  }
  public addCategory(category:any){
    return this._http.post<any>(`${baseUrl}/category/`,category);
  }
}
