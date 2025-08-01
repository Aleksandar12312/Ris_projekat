import { Component } from '@angular/core';
import { Header } from "../header/header";
import { IBook } from '../../models/IBook.Model';
import { Book } from "../book/book";

@Component({
  selector: 'app-home',
  standalone:true,
  imports: [Header, Book],
  templateUrl: './home.html',
  styleUrl: './home.scss'
})
export class Home {
  books: IBook[] = [];
  showSearchedBooks(books:IBook[]){
    this.books=books;
  }
}
