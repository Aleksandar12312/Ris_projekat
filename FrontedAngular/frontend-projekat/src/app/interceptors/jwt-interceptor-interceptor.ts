import { HttpInterceptorFn } from '@angular/common/http';
import { ServiceUser } from '../services/service-user';
import { inject } from '@angular/core';

export const jwtInterceptorInterceptor: HttpInterceptorFn = (req, next) => {

    if (req.url.includes('/login') || req.url.includes('/register')) {
    return next(req); // Prosleđuje "čist" zahtev bez tokena
  }
 const token = localStorage.getItem('jwt_token'); // ili sessionStorage ako koristiš to
  
  if (token) {
    // Klonira zahtev i dodaje Authorization header
   
    req = req.clone({
      setHeaders: {
        Authorization: `Bearer ${token}`
      }
    });
  }
  else{
    console.log("Uopste ni nema tokena unutar inceptora");
  }

  return next(req); // Nastavlja dalje kroz chain
};
