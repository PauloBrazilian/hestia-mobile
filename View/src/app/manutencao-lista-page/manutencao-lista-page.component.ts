import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Listas } from '../model/listas';


@Component({
  selector: 'app-manutencao-lista-page',
  templateUrl: './manutencao-lista-page.component.html',
  styleUrls: ['./manutencao-lista-page.component.css']
})
export class ManutencaoListaPageComponent implements OnInit {

  listas: Listas[] = [
    {listaId: 1, listaName: 'Name', data: '2023-12-04', products: []}
  ];

  displayedColumns: string[] = ['nome', 'data', 'products', 'actions'];

  constructor() { }

  ngOnInit(): void {
  }
}
