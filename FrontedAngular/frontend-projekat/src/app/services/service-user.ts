import { inject, Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Inject } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginResponse } from '../models/LoginResponse';


interface User{
  korisnickoIme:string;
  lozinka:string;
}
interface UserRegister{
  korisnickoIme:string;
  lozinka:string;
  email:string;
}
@Injectable({
  providedIn: 'root'
})
export class ServiceUser {
  private http=inject(HttpClient);//dependency injection
  constructor() { }
  loginService(korisnickoIme:string,lozinka:string):Observable<LoginResponse>{
    
    let url="http://localhost:8080/Projekat/korisnikController/login";
     const user: User = {
      korisnickoIme: korisnickoIme,
      lozinka: lozinka
    };
    
  return this.http.post<LoginResponse>(`${url}`, user, {
  headers: {
    'Content-Type': 'application/json',
  }
});
}

registerService(korisnickoIme:string,lozinka:string,email:string):Observable<string>{
  let url="http://localhost:8080/Projekat/korisnikController/register";
     const user: UserRegister = {
      korisnickoIme: korisnickoIme,
      lozinka: lozinka,
      email:email
    };
    return this.http.post(`${url}`,user,{
      headers:{
        'Content-type':'application/json'
      },
      responseType:'text'
    });

}
findIdUser(username:string):Observable<any>{
  
  let url="http://localhost:8080/Projekat/korisnikController/usernameId"
  const params = new HttpParams().set('query', username);//moze i ovako pa samo ubaciti params
  return this.http.get(url,{
    params:{"query":username}
  });
}
private readonly TOKEN_KEY="jwt_token";
setToken(token: string): void {
    localStorage.setItem(this.TOKEN_KEY, token);
  }

  // Dohvatanje tokena
  getToken(): string | null {
    return localStorage.getItem(this.TOKEN_KEY);
  }

  // Brisanje tokena (pri logout)
  removeToken(): void {
    localStorage.removeItem(this.TOKEN_KEY);
  }

  // Provera da li je korisnik autentifikovan
  isAuthenticated(): boolean {
    return !!this.getToken();
  }
}
