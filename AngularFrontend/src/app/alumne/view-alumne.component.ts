import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

import { Alumne } from '../models/alumne.model';
import { AlumneService } from './alumne.service';

@Component({
  templateUrl: './view-alumne.component.html'
})
export class ViewAlumneComponent {

  alumne: Alumne = new Alumne();

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
}
