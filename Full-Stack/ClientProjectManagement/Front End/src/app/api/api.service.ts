import { Injectable } from '@angular/core';
import { HttpClient , HttpHeaders} from '@angular/common/http';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET, POST, OPTIONS, PUT, PATCH, DELETE'
    })
  }
  constructor(private http : HttpClient) { }

  private baseURL = "http://localhost:5000/";

  postClient(data:any){
    return this.http.post<any> (this.baseURL + "new-client", data, this.httpOptions).pipe(map((result:any)=> {
      return result;
    }))
  }

  updateClient(data: any) {
    return this.http.put<any> (this.baseURL + "client" + data.characterID, data, this.httpOptions).pipe(map((result:any)=>
    {
      return result;
    }))
  }

  getClient() {
    return this.http.get<any>(this.baseURL + "", this.httpOptions).pipe(map((result:any)=> {
      return result;
    }))
  }

  getClientByID(clientID: number){
    return this.http.get<any>(this.baseURL + "" + clientID, this.httpOptions).pipe(map((result:any)=> {
      return result;
    }))
  }




  
}
