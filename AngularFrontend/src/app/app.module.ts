import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { AlumnesComponent } from './alumnes/alumnes.component';
import { AppRoutingModule } from './app.routing.module';
import {AlumnesService} from './alumnes/alumnes.service';
import {HttpClientModule} from "@angular/common/http";
import {AddAlumnesComponent} from './alumnes/add-alumnes.component';

@NgModule({
  declarations: [
    AppComponent,
    AlumnesComponent,
    AddAlumnesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [AlumnesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
