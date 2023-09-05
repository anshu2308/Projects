import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class SoldService {

  constructor(private _http:HttpClient) { }

  public getSoldProduct(){
    return this._http.get<any>(`${baseUrl}/sold/`);
  }
  public addSoldProduct(productDetails:any){
    return this._http.post<any>(`${baseUrl}/sold/`,productDetails);
  }
  public getSoldBySeller(id:any){
    return this._http.get(`${baseUrl}/sold/seller/${id}`);

  }
}
