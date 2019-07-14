import { NgModule } from '@angular/core';
import { RouterModule, Routes, ActivatedRoute } from '@angular/router';

import { AlumneComponent } from './alumne/alumne.component';
import {AddAlumneComponent} from './alumne/add-alumne.component';
import {EditAlumneComponent} from './alumne/edit-alumne.component';
import {ViewAlumneComponent} from './alumne/view-alumne.component';

import { MaterialComponent } from './material/material.component';
import {AddMaterialComponent} from './material/add-material.component';
import {EditMaterialComponent} from './material/edit-material.component';

import { RebutComponent } from './rebut/rebut.component';

const routes: Routes = [
  { path: 'alumne', component: AlumneComponent },
  { path: 'alumne/add', component: AddAlumneComponent },
  { path: 'alumne/edit/:id', component: EditAlumneComponent },
  { path: 'alumne/view/:id', component: ViewAlumneComponent },
  { path: 'material', component: MaterialComponent },
  { path: 'material/add', component: AddMaterialComponent },
  { path: 'material/edit/:id', component: EditMaterialComponent },
  { path: 'rebut', component: RebutComponent }
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
