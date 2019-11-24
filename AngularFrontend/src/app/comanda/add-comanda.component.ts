import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { Comanda } from '../models/comanda.model';
import { Alumne } from '../models/alumne.model';
import { Material } from '../models/material.model';
import { ComandaService } from './comanda.service';
import { AlumneService } from '../alumne/alumne.service';
import { MaterialService } from '../material/material.service';

@Component({
  templateUrl: './add-comanda.component.html'
})
export class AddComandaComponent {

  comanda: Comanda = new Comanda();
  alumnes: Alumne[];
  materials: Material[];
  
  constructor(private router: Router, private comandaService: ComandaService, private alumneService: AlumneService, private materialService: MaterialService) {

  }
  
  ngOnInit() {
      this.alumneService.getAlumnes("")
      .subscribe( data => {
        this.alumnes = data;
        this.comanda.idAlumne = this.alumnes[0].id;
      });

    this.materialService.getMaterials("")
      .subscribe( data => {
        this.materials = data;
        this.comanda.idMaterial = this.materials[0].id;
      });
  };
  

  back(): void {
    this.router.navigateByUrl('/comanda');
  };

  saveComanda(): void {
    this.comandaService.createComanda(this.comanda)
        .subscribe( data => {
          this.router.navigateByUrl('/comanda');
        });

  };
}
