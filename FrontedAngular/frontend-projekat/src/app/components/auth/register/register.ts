import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { RouterOutlet } from '@angular/router';
import { ServiceUser } from '../../../services/service-user';

@Component({
  selector: 'app-register',
  imports: [],
  templateUrl: './register.html',
  styleUrl: './register.scss',
  providers:[ServiceUser]
})


export class Register {
  router=inject(Router);
  servis=inject(ServiceUser); 

  register(korisnickoIme:string,lozinka:string,email:string,event:Event){
    event.preventDefault();

    this.servis.registerService(korisnickoIme,lozinka,email).subscribe(
      {
        next:o=>{
          console.log("Uspesno registrovan korisnik i uspesno poslat token");
          this.servis.setToken(o);
          this.router.navigate(["/home"])
        },
        error:e=>{
          console.log("Registracija nije uspela "+e);
        }
      }
    )
  }
   goToLogin(event:Event){
    event.preventDefault();
    this.router.navigate(["/register"]);
  }
  
}
