import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app.routing.module';
import { HttpClientModule } from "@angular/common/http";

import { AlumneService } from './alumne/alumne.service';
import { AlumneComponent } from './alumne/alumne.component';
import { AddAlumneComponent } from './alumne/add-alumne.component';
import { EditAlumneComponent } from './alumne/edit-alumne.component';
import { ViewAlumneComponent } from './alumne/view-alumne.component';
import { LlicenciaService } from './alumne/llicencia.service';
import { MensualitatService } from './alumne/mensualitat.service';
import { RebutService } from './rebut/rebut.service';

import { MaterialService } from './material/material.service';
import { MaterialComponent } from './material/material.component';
import { AddMaterialComponent } from './material/add-material.component';
import { EditMaterialComponent } from './material/edit-material.component';

import { RebutComponent } from './rebut/rebut.component';
import { ViewRebutComponent } from './rebut/view-rebut.component';

@NgModule({
  declarations: [
    AppComponent,
    AlumneComponent,
    AddAlumneComponent,
    EditAlumneComponent,
    ViewAlumneComponent,
    MaterialComponent,
    AddMaterialComponent,
    EditMaterialComponent,
    RebutComponent,
    ViewRebutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ 
  	AlumneService,
  	LlicenciaService,
  	MensualitatService,
  	MaterialService,
  	RebutService
  ],
  bootstrap: [AppComponent],
  entryComponents: [ ]
})
export class AppModule { }
