import { Component, inject } from '@angular/core';
import { ServiceUser } from '../../../services/service-user';
import { Inject } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [],
  templateUrl: './login.html',
  styleUrl: './login.scss',
  providers:[ServiceUser]
})

export class Login {

  router=inject(Router)
  servis=inject(ServiceUser);
  
  login(username:string,password:string, event:Event){
    event.preventDefault();
    this.servis.loginService(username,password)
    .subscribe({
    next: o => {
      console.log("Odgovor od backenda:", o);
      localStorage.setItem("username",username);//ovde cuvamo username korisnika u localStorage
      localStorage.setItem("role",o.uloga);//ovde cuvamo ulogu
      localStorage.setItem("idKorisnik",o.idKorisnik.toString());
      this.servis.setToken(o.token);
      
      this.router.navigate(["/home"])
    },
    error: err => console.log("Error during login:"+err)
  });
   
  }
  goToRegister(event:Event){
    event.preventDefault();
    this.router.navigate(["/register"]);
  }
}

