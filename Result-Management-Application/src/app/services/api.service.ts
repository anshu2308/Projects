import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http:HttpClient) { }
  
  postResult(data:any){
    return this.http.post<any>("http://localhost:3000/ResultList/",data);
  }

  getResult(){
    return this.http.get<any>("http://localhost:3000/ResultList/");
  }

  putResult(data:any,id:number){
    return this.http.put<any>("http://localhost:3000/ResultList/"+id,data);
  }

  deleteResult(id:number)
  {
    return this.http.delete<any>("http://localhost:3000/ResultList/"+id);
  }
}
