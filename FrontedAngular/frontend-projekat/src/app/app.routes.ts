import { Routes } from '@angular/router';
import { Home } from './components/home/home';

export const routes: Routes = [
    {
        path:"home", 
        loadComponent:()=>{
         return import("./components/home/home").then(m=>m.Home);
    }
    },
    {
        path:"login",
        loadComponent:()=>{
            return import("./components/auth/login/login").then(m=>m.Login);
        }
    },
    { path: "", redirectTo: "/login", pathMatch: "full" },
    {
        path:"register",
        loadComponent:()=>{
            return import("./components/auth/register/register").then(m=>m.Register);
        }
    },
    {
        path:"book",
        loadComponent() {
            return import("./components/book-page/book-page").then(m=>m.BookPage);
        }
    }

];
