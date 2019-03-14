import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Alumne } from '../models/alumne.model';
import { AlumneService } from './alumne.service';

@Component({
  selector: 'app-alumne',
  templateUrl: './alumne.component.html',
  styles: []
})
export class AlumneComponent implements OnInit {

  alumnes: Alumne[];

  constructor(private router: Router, private alumneService: AlumneService) {

  }

  ngOnInit() {
    this.alumneService.getAlumnes()
      .subscribe( data => {
        this.alumnes = data;
      });
  };

  deleteAlumne(alumne: Alumne): void {
    this.alumneService.deleteAlumne(alumne)
      .subscribe( data => {
        this.alumnes = this.alumnes.filter(u => u.id !== alumne.id);
      })
  };
  goCreateAlumne(): void {
    this.router.navigateByUrl('/alumne/add');
  };
  goEditAlumne(alumne: Alumne): void {
    this.router.navigateByUrl('/alumne/edit/' + alumne.id);
  };
  goViewAlumne(alumne: Alumne): void {
    this.router.navigateByUrl('/alumne/view/' + alumne.id);
  };

}


