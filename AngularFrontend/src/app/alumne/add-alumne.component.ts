import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { Alumne } from '../models/alumne.model';
import { AlumneService } from './alumne.service';

@Component({
  templateUrl: './add-alumne.component.html'
})
export class AddAlumneComponent {

  alumne: Alumne = new Alumne();
  formAction: string = "Afegir nou";
  constructor(private router: Router, private alumneService: AlumneService) {

  }

  back(): void {
    this.router.navigateByUrl('/alumne');
  };

  saveAlumne(): void {
    this.alumneService.createAlumne(this.alumne)
        .subscribe( data => {
          this.router.navigateByUrl('/alumne');
        });

  };

}
