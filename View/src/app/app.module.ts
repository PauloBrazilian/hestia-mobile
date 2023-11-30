import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { ManutencaoListaPageComponent } from './manutencao-lista-page/manutencao-lista-page.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    ManutencaoListaPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
