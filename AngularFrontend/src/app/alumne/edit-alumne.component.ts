import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

import { Alumne } from '../models/alumne.model';
import { AlumneService } from './alumne.service';

@Component({
  templateUrl: './add-alumne.component.html'
})
export class EditAlumneComponent {

  alumne: Alumne = new Alumne();
  formAction: string = "Editar";
  constructor(private route: ActivatedRoute, private router: Router, private alumneService: AlumneService) {

  }

  back(): void {
    this.router.navigateByUrl('/alumne');
  };

  ngOnInit() {
    this.alumneService.getAlumne(this.route.snapshot.params.id)
      .subscribe( data => {
        this.alumne = data;
      });
  };

  saveAlumne(): void {
    this.alumneService.editAlumne(this.alumne)
        .subscribe( data => {
          this.router.navigateByUrl('/alumne');
        });

  };

}
