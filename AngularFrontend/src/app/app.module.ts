import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { AlumneComponent } from './alumne/alumne.component';
import { AppRoutingModule } from './app.routing.module';
import { AlumneService } from './alumne/alumne.service';
import { LlicenciaService } from './alumne/llicencia.service';
import { HttpClientModule } from "@angular/common/http";
import { AddAlumneComponent } from './alumne/add-alumne.component';
import { EditAlumneComponent } from './alumne/edit-alumne.component';
import { ViewAlumneComponent } from './alumne/view-alumne.component';

@NgModule({
  declarations: [
    AppComponent,
    AlumneComponent,
    AddAlumneComponent,
    EditAlumneComponent,
    ViewAlumneComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ 
  	AlumneService,
  	LlicenciaService
  ],
  bootstrap: [AppComponent],
  entryComponents: [ ]
})
export class AppModule { }
