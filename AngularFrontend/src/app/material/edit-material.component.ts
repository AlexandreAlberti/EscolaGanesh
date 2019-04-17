import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

import { Material } from '../models/material.model';
import { TipusMaterial } from '../models/tipusmaterial.model';
import { MaterialService } from './material.service';

@Component({
  templateUrl: './add-material.component.html'
})
export class EditMaterialComponent {

  material: Material = new Material();
  tipus: TipusMaterial[];
  formAction: string = "Editar";
  constructor(private route: ActivatedRoute, private router: Router, private materialService: MaterialService) {

  }

  back(): void {
    this.router.navigateByUrl('/material');
  };

  ngOnInit() {
    this.materialService.getMaterial(this.route.snapshot.params.id)
      .subscribe( data => {
        this.material = data;
      });
    this.materialService.getTipus()
      .subscribe( data => {
        this.tipus = data;
      });
  };

  saveMaterial(): void {
    this.materialService.editMaterial(this.material)
        .subscribe( data => {
          this.router.navigateByUrl('/material');
        });

  };

  compareFn = this._compareFn.bind(this);	
  _compareFn(a, b) {
    return a.id === b.id;
  }

}
