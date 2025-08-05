export interface IBook{
  idKnjiga:number;
  naslov:string;
  opis:string;
  originalniJezik:string;
  pisacIme:string;
  idPisac:number;
  zanrovi:Array<string>;
}