import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {HomePageComponent} from "./home-page/home-page.component";
import {ManutencaoListaPageComponent} from "./manutencao-lista-page/manutencao-lista-page.component";

const routes: Routes = [
  { path: '', redirectTo: '/index', pathMatch: 'full'},
  {path: 'index', component: HomePageComponent},
  {path: 'lista', component: ManutencaoListaPageComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
