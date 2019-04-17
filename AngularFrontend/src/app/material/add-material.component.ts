import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { Material } from '../models/material.model';
import { TipusMaterial } from '../models/tipusmaterial.model';
import { MaterialService } from './material.service';

@Component({
  templateUrl: './add-material.component.html'
})
export class AddMaterialComponent {

  material: Material = new Material();
  tipus: TipusMaterial[];
  
  formAction: string = "Afegir nou";
  constructor(private router: Router, private materialService: MaterialService) {

  }
  
  ngOnInit() {
    this.materialService.getTipus()
      .subscribe( data => {
        this.tipus = data;
        this.material.tipus = this.tipus[0].id;
      });
  };
  

  back(): void {
    this.router.navigateByUrl('/material');
  };

  saveMaterial(): void {
    this.materialService.createMaterial(this.material)
        .subscribe( data => {
          this.router.navigateByUrl('/material');
        });

  };
}
