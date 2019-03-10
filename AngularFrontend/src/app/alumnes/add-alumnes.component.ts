import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { Alumnes } from '../models/alumnes.model';
import { AlumnesService } from './alumnes.service';

@Component({
  templateUrl: './add-alumnes.component.html'
})
export class AddAlumnesComponent {

  alumnes: Alumnes = new Alumnes();

  constructor(private router: Router, private alumnesService: AlumnesService) {

  }

  createAlumnes(): void {
    this.alumnesService.createAlumnes(this.alumnes)
        .subscribe( data => {
          alert("Alumnes created successfully.");
        });

  };

}
