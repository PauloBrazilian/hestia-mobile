import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {HomePageComponent} from "./home-page/home-page.component";
import {ManutencaoListaPageComponent} from "./manutencao-lista-page/manutencao-lista-page.component";
import {ExplorarPageComponent} from "./explorar-page/explorar-page.component";
import {CompararListaComponent} from "./comparar-lista/comparar-lista.component";
import {CadastrarListaComponent} from "./cadastrar-lista/cadastrar-lista.component";



const routes: Routes = [
  { path: '', redirectTo: '/index', pathMatch: 'full'},
  {path: 'index', component: HomePageComponent},
  {path: 'lista', component: ManutencaoListaPageComponent},
  {path: 'explorar', component: ExplorarPageComponent},
  {path: 'lista/comparar', component: CompararListaComponent},
  {path: 'lista/cadastrar', component: CadastrarListaComponent},
  {path: 'lista/editar', component: CadastrarListaComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
