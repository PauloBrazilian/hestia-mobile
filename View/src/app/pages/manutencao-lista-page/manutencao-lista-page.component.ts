import { Component, OnInit } from '@angular/core';
import { Listas } from '../../model/listas';
import { MsStoreService } from '../../service/msStore/ms-store.service';
import { Observable, catchError, of } from 'rxjs';
import { MatDialog } from '@angular/material/dialog';


@Component({
  selector: 'app-manutencao-lista-page',
  templateUrl: './manutencao-lista-page.component.html',
  styleUrls: ['./manutencao-lista-page.component.css']
})
export class ManutencaoListaPageComponent implements OnInit {

  listas$: Observable<Listas[]>;
  displayedColumns: string[] = ['listaName', 'data', 'actions'];
  
  constructor(
    private msStore: MsStoreService,
    public dialog: MatDialog
    ) {         
    this.listas$ = this.msStore.findAllListas();    
  }


  ngOnInit(): void {    
  }

}
