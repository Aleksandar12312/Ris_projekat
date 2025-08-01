import { HttpClient, HttpParams } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Rating } from '../models/Rating.model';
import { IBook } from '../models/IBook.Model';
import { Collection } from '../models/Collection';

@Injectable({
  providedIn: 'root'
})
export class ServiceBook {
  private  http=inject(HttpClient);


  constructor() { }
  search(searchBook:string):Observable<any>{//ovo je izmenjeno iz any u string
    
    let url="http://localhost:8080/Projekat/knjigaController/searchKnjiga";
    const params = new HttpParams().set('query', searchBook);
 //   console.log(this.http.get(`${url}`,{params})
 //   .subscribe({
 //     next:o=>console.log("Uspesno!"+o),
 //     error:e=>console.log("Error "+e)
//    }));
    return this.http.get(`${url}`,{params});
    
  }
   rate(ocenaDTO:Rating){
    console.log("ocenaDto "+ocenaDTO.ocena);
    let url="http://localhost:8080/Projekat/knjigaController/oceni";
    this.http.post(url,ocenaDTO,{
      headers:{
        'Content-Type':'application/json'
      }
    }).subscribe({
      next:o=>{},//mora subscribe ili se zahtev uopste i ne salje
      error:e=>{}
    });
   
  }
  addBookToOmiljene(collection:Collection,omiljenaOrProcitana:number){//moram resiti kada se dva puta klikne na dugme izlazi mi error
  
      let url="http://localhost:8080/Projekat/knjigaController/saveProcitana";
    
    if(omiljenaOrProcitana==1){
      url="http://localhost:8080/Projekat/knjigaController/saveOmiljena";
    }
      this.http.post(url,collection,{
      headers:{
        'Content-Type':'application/json'
      }
    }).subscribe(
      {
      next:o=>{console.log("Uspesno smo ubacili u kolekciju")},//mora subscribe ili se zahtev uopste i ne salje
      error:e=>{}
  });


  }

}
 
