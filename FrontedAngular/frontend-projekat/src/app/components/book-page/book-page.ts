import { Component, inject, OnInit } from '@angular/core';
import { Header } from "../header/header";
import { Router } from '@angular/router';
import { IBook } from '../../models/IBook.Model';
import { ServiceUser } from '../../services/service-user';
import { Rating } from '../../models/Rating.model';
import { ServiceBook } from '../../services/service-book';
import { Collection } from '../../models/Collection';

@Component({
  standalone: true,
  selector: 'app-book-page',
  imports: [Header],
  templateUrl: './book-page.html',
  styleUrl: './book-page.scss'
})

export class BookPage implements OnInit{
  router=inject(Router);
  book: IBook|undefined;
  serviceKorisnikObj=inject(ServiceUser);
  serviceBookObj=inject(ServiceBook);
  
  
  ngOnInit() {
    const bookString = localStorage.getItem('book');
    if (bookString) {
      this.book = JSON.parse(bookString);
    } else {
      this.router.navigate(['/home']);
    }
  }
  rate(ocena: number) {
  
      let username: string | null = localStorage.getItem("username");
      if (username) {
        this.serviceKorisnikObj.findIdUser(username).subscribe({
          next: (userId: number) => {
            const rating: Rating = {
              ocena: ocena,
              korisnikId: userId,
              knjigaId: this.book!=undefined?this.book.idKnjiga:-1
            };
            console.log("Ovo je id korisnika u rate u book.ts " + rating.korisnikId);
            this.serviceBookObj.rate(rating);
  
          },
          error: (e: any) => {
            console.error("Greška prilikom pronalaženja korisnika", e);
          }
  
        })
      }
    }
    lastClicked: HTMLElement | undefined;
      clickRating(event: Event, button: HTMLElement) {
    let numberClicked: string | null = button.textContent;
    event.preventDefault();
    if (!this.lastClicked) {
      this.lastClicked = button;
    }
    else {
      this.lastClicked.classList.remove("clicked-button");
    }

    button.classList.add("clicked-button");
    this.lastClicked = button;

  }
  addBookToCollection(omiljanaOrProcitana:number){
    let idKorisnik=Number(localStorage.getItem("idKorisnik"));
    let idKnjiga=this.book?.idKnjiga;
    if(idKnjiga!=undefined){
    const collection:Collection={
      idKnjiga:idKnjiga,
      idKorisnik:idKorisnik
    }
    this.serviceBookObj.addBookToOmiljene(collection,omiljanaOrProcitana);
  }
  }
  
    isActive = false;
    

toggleHeart() {
  this.isActive = !this.isActive;
}

}
