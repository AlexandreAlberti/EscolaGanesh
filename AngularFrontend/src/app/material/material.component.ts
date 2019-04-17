import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Material } from '../models/material.model';
import { TipusMaterial } from '../models/tipusmaterial.model';
import { MaterialService } from './material.service';

@Component({
  selector: 'app-material',
  templateUrl: './material.component.html',
  styles: []
})
export class MaterialComponent implements OnInit {

  materials: Material[];
  tipus: TipusMaterial[];
  dialogShown: boolean = true;
  selectedMaterial: Material = new Material();
  cercador : string = "";
   
  constructor(private router: Router, private materialService: MaterialService) {

  }

  ngOnInit() {
    this.dialogShown = true;
    this.cercaMaterials();
    this.materialService.getTipus()
      .subscribe( data => {
        this.tipus = data;
      });
    
  };

  cercaMaterials(){
    this.materialService.getMaterials(this.cercador)
      .subscribe( data => {
        this.materials = data;
      });
  }

  deleteMaterial(id: string): void {
    this.materialService.deleteMaterial(id)
      .subscribe( data => {
        this.materials = this.materials.filter(u => u.id !== id);
	    this.dialogShown = true;
      });  
  };
  goCreateMaterial(): void {
    this.router.navigateByUrl('/material/add');
  };
  goEditMaterial(material: Material): void {
    this.router.navigateByUrl('/material/edit/' + material.id);
  };

  openDialog(material: Material) {
  	this.selectedMaterial = material;
	this.dialogShown = false;    		
  }
  closeDialog(){
	this.dialogShown = true;
  }
  
}


