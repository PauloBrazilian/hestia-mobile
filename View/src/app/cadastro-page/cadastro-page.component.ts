import { Component, OnInit } from '@angular/core';
import { Person } from '../entidade/person';
import { MsPersonsService } from '../service/msPersons/ms-persons.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-cadastro-page',
  templateUrl: './cadastro-page.component.html',
  styleUrls: ['./cadastro-page.component.css']
})
export class CadastroPageComponent implements OnInit {
  persons: Observable<Person[]>; 
  


  constructor(private msPerson: MsPersonsService){

    this.persons = this.msPerson.list();

    //this.msPerson.list().subscribe(persons => this.persons = persons);
  }

  ngOnInit(): void {
    
  }

}
