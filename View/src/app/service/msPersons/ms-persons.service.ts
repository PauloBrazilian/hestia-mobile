import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { tap } from 'rxjs';
import { Person } from 'src/app/entidade/person';

@Injectable({
  providedIn: 'root'
})
export class MsPersonsService {

  private readonly API = '/assets/person.json';

  constructor(private httpClient: HttpClient) { }

  list(){
    return this.httpClient.get<Person[]>(this.API)
    .pipe(
      tap(persons => console.log(persons))
    );
  }

}
