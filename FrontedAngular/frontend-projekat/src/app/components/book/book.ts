import { Component, inject, Input } from '@angular/core';
import { IBook } from '../../models/IBook.Model';
import { ServiceBook } from '../../services/service-book';
import { Rating } from '../../models/Rating.model';
import { ServiceUser } from '../../services/service-user';
import { Router } from '@angular/router';
@Component({
  selector: 'app-book',
  imports: [],
  templateUrl: './book.html',
  styleUrl: './book.scss'
})

export class Book {
  router = inject(Router);
  lastClicked: HTMLElement | undefined;

  @Input()
  book!: IBook;// ovo prima podatke iz roditelja(home)

  serviceBookObj = inject(ServiceBook);
  serviceKorisnikObj = inject(ServiceUser);

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
  rate(ocena: number) {

    let username: string | null = localStorage.getItem("username");
    if (username) {
      this.serviceKorisnikObj.findIdUser(username).subscribe({
        next: (userId: number) => {
          const rating: Rating = {
            ocena: ocena,
            korisnikId: userId,
            knjigaId: this.book.idKnjiga
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
  goToBookPage(event: Event, book: IBook) {
    localStorage.setItem('book', JSON.stringify(book));
    this.router.navigate(["/book"]);
  }

  isActive = false;

toggleHeart() {
  this.isActive = !this.isActive;
}



}
