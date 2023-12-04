import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Listas } from 'src/app/model/listas';

@Injectable({
  providedIn: 'root'
})
export class MsStoreService {

  constructor(private httpClient: HttpClient) { }


  findAllListas(): Listas[]{
    return[
      {listaId: 1, listaName: 'Paulo', data: '2023-12-04', products: []}
    ]
  }


}
