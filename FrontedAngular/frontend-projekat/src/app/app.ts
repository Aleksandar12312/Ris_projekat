import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {Header} from './components/header/header';
import { Login } from "./components/auth/login/login";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  template: `
    <router-outlet />
  `,
  styles: [],
})
export class App {
  protected title = 'frontend-projekat';
}
