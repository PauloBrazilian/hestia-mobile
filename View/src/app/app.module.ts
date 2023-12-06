import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { ManutencaoListaPageComponent } from './manutencao-lista-page/manutencao-lista-page.component';

import { MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatListModule} from '@angular/material/list';
import { HttpClientModule } from '@angular/common/http';
import { AcessoPageComponent } from './acesso-page/acesso-page.component';
import { CadastroPageComponent } from './cadastro-page/cadastro-page.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    ManutencaoListaPageComponent,
    AcessoPageComponent,
    CadastroPageComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatTableModule,
    MatIconModule,
    MatButtonModule,
    BrowserAnimationsModule,
    MatListModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }