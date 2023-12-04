import { Component, OnInit } from '@angular/core';
import { Listas } from '../model/listas';
import { MsStoreService } from '../service/msStore/ms-store.service';


@Component({
  selector: 'app-manutencao-lista-page',
  templateUrl: './manutencao-lista-page.component.html',
  styleUrls: ['./manutencao-lista-page.component.css']
})
export class ManutencaoListaPageComponent implements OnInit {

  listas: Listas[] = [
    {listaId: 1, listaName: 'Paulo', data: '2023-12-04', products: []}
  ];
  displayedColumns: string[] = ['listaName', 'data', 'actions'];
  
  constructor(private msStore: MsStoreService) {         
  }

  ngOnInit(): void {
    this.listas = this.msStore.findAllListas();
  }
}
