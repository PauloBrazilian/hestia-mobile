import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {HomePageComponent} from "./pages/home-page/home-page.component";
import { ManutencaoListaPageComponent } from './pages/manutencao-lista-page/manutencao-lista-page.component'; 
import {ExplorarPageComponent} from "./pages/explorar-page/explorar-page.component";
import {CompararListaComponent} from "./pages/comparar-lista/comparar-lista.component";
import {CadastrarListaComponent} from "./pages/cadastrar-lista/cadastrar-lista.component";
import {EditarListaComponent} from "./pages/editar-lista/editar-lista.component";


const routes: Routes = [
  { path: '', redirectTo: '/index', pathMatch: 'full'},
  {path: 'index', component: HomePageComponent},
  {path: 'lista', component: ManutencaoListaPageComponent},
  {path: 'explorar', component: ExplorarPageComponent},
  {path: 'lista/comparar', component: CompararListaComponent},
  {path: 'lista/cadastrar', component: CadastrarListaComponent},
  {path: 'lista/editar', component: EditarListaComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
