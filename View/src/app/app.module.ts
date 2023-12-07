import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { ManutencaoListaPageComponent } from './pages/manutencao-lista-page/manutencao-lista-page.component';

import { MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatListModule} from '@angular/material/list';
import { HttpClientModule } from '@angular/common/http';
import { AcessoPageComponent } from './pages/acesso-page/acesso-page.component';
import { CadastroPageComponent } from './pages/cadastro-page/cadastro-page.component';
import { CadastrosListaComponent } from './pages/cadastros-lista/cadastros-lista.component';
import { CompararListaComponent } from './pages/comparar-lista/comparar-lista.component';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MatDialogModule} from '@angular/material/dialog';


@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    ManutencaoListaPageComponent,
    AcessoPageComponent,
    CadastroPageComponent,
    CadastrosListaComponent,
    CompararListaComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatTableModule,
    MatIconModule,
    MatButtonModule,
    BrowserAnimationsModule,
    MatListModule,
    HttpClientModule,
    MatProgressSpinnerModule,
    MatDialogModule    
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }