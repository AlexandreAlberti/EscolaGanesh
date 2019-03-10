import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AlumnesComponent } from './alumnes/alumnes.component';
import {AddAlumnesComponent} from './alumnes/add-alumnes.component';

const routes: Routes = [
  { path: 'alumnes', component: AlumnesComponent },
  { path: 'add', component: AddAlumnesComponent }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
