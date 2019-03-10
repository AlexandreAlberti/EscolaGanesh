import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Alumnes } from '../models/alumnes.model';
import { AlumnesService } from './alumnes.service';

@Component({
  selector: 'app-alumnes',
  templateUrl: './alumnes.component.html',
  styles: []
})
export class AlumnesComponent implements OnInit {

  alumness: Alumnes[];

  constructor(private router: Router, private alumnesService: AlumnesService) {

  }

  ngOnInit() {
    this.alumnesService.getAlumness()
      .subscribe( data => {
        this.alumness = data;
      });
  };

  deleteAlumnes(alumnes: Alumnes): void {
    this.alumnesService.deleteAlumnes(alumnes)
      .subscribe( data => {
        this.alumness = this.alumness.filter(u => u !== alumnes);
      })
  };

}


