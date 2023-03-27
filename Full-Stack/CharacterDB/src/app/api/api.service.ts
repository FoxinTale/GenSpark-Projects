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

  // private baseUrl = "http://chardbdemo-env.eba-mz32czhr.us-east-2.elasticbeanstalk.com/api/"
  private baseUrl = "http://localhost:5000/api/";
  

  postCharacter(data:any) {
    return this.http.post<any> (this.baseUrl + "create-character", data, this.httpOptions).pipe(map((result:any)=> {
      return result;
    }))
  }

  updateCharacter(data: any) {
    return this.http.put<any> (this.baseUrl + "view-characters/" + data.characterID, data, this.httpOptions).pipe(map((result:any)=>
    {
      return result;
    }))
  }

  getCharacter() {
    return this.http.get<any>(this.baseUrl + "view-characters", this.httpOptions).pipe(map((result:any)=> {
      return result;
    }))
  }

  getCharacterByID(charID: number){
    return this.http.get<any>(this.baseUrl + "view-characters/" + charID, this.httpOptions).pipe(map((result:any)=> {
      return result;
    }))
  }
  
  deleteCharacter(characterID : number) {
    /*
      This currently works, but not as intended. It does in fact delete the character, but nothing is returned. We think this is due to the
      mapping being given a charID, and since that ID is then deleted, it does not know how to handle this so it gives an amusing HTTP 200 
      error in the dev console. Nothing happens, and no code is executed after this, so it cannot display any confirmation.

      The page has to be manually refreshed, routing deleted from the browser URL, and the "View characters" page to be re-visited.
    */
    return this.http.delete<any>(this.baseUrl + "view-characters/" + characterID, this.httpOptions).pipe(map((result:any)=> {
      return result;
    }))
  }


  
  postUser(data:any) {
    return this.http.post<any> (this.baseUrl + "create-journal", data, this.httpOptions).pipe(map((result:any)=> {
      return result;
    }))
  }

  getUser() {
    return this.http.get<any>(this.baseUrl + "open-journal", this.httpOptions).pipe(map((result:any)=> {
      return result;
    }))
  }

  deleteUser(userID : number) {
    return this.http.delete<any>(this.baseUrl + "users/" + userID, this.httpOptions).pipe(map((result:any)=> {
      return result;
    }))
  }

}
