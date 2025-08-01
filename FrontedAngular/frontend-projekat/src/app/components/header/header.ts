import { Component, EventEmitter, inject, Input, Output, output, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ServiceBook } from '../../services/service-book';
import { Observable } from 'rxjs';
import { Book } from '../book/book';
import { Home } from '../home/home';
import { IBook } from '../../models/IBook.Model';

@Component({
  selector: 'app-header',
  standalone:true,
  imports: [],
  templateUrl: './header.html',
  styleUrl: './header.scss'

})

export class Header {
  serviceObj=inject(ServiceBook);
  @Output() clicked=new EventEmitter<IBook[]>();
  ulogaKorisnika=localStorage.getItem("role");
  search(searchBook:string){
    this.serviceObj.search(searchBook)//ovo iz any u string
    .subscribe({
      next:o=>this.clicked.emit(o),
      error:e=>console.log("Greska prilikom search-a!")
    })
  }

  searchEnter(event:KeyboardEvent,searchBook:string){//not done
  
    if(event.key==="Enter"){
        this.search(searchBook);
    }
  }
}

