import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  //addProduct 
  public addProduct(formData:FormData): Observable<any>{
    return this.http.post<any>(`${baseUrl}/product/`, formData);
  }

  public editProduct(Product:any){
    return this.http.put<any>(`${baseUrl}/product/`, Product);
 
  }

  public getAllproducts(){
    return this.http.get<any>(`${baseUrl}/product/`)
  }

  public getProductById(id:any){
    return this.http.get<any>(`${baseUrl}/product/${id}`)
  }

  public deleteProduct(id:any){
    console.log(id);
  return this.http.delete<any>(`${baseUrl}/product/${id}`)
}
  
}
