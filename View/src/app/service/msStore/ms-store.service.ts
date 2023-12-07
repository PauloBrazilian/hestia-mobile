import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { delay, first, tap } from 'rxjs';
import { Listas } from 'src/app/model/listas';

@Injectable({
  providedIn: 'root'
})
export class MsStoreService {

  constructor(private httpClient: HttpClient) { }

  private readonly API = 'api/'

  findAllListas(){
    return this.httpClient.get<Listas[]>(this.API)
      .pipe(
        first(),
        delay(5000),
        tap(Listas => console.log(Listas))
      );
  }
    
}
