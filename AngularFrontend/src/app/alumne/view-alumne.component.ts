import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

import { Alumne } from '../models/alumne.model';
import { Llicencia } from '../models/llicencia.model';
import { Rebut } from '../models/rebut.model';
import { AlumneService } from './alumne.service';
import { LlicenciaService } from './llicencia.service';
import { RebutService } from './rebut.service';

@Component({
  templateUrl: './view-alumne.component.html'
})
export class ViewAlumneComponent {

  alumne: Alumne = new Alumne();
  novaLlicencia: number;
  nouRebut: number;
  nouRebutMes: number;
  dialogShown: boolean = true;
  dialogRebutShown: boolean = true;
  selectedLlicencia: number = 0;
  selectedLlicenciaAny: number = 0;
  selectedRebut: number = 0;
  selectedRebutAny: number = 0;
  selectedRebutMes: number = 0;


  constructor(private route: ActivatedRoute, private router: Router, private alumneService: AlumneService, private llicenciaService: LlicenciaService, private rebutService: RebutService) {

  }

  back(): void {
    this.router.navigateByUrl('/alumne');
  };

  ngOnInit() {
    this.dialogShown = true;
    this.alumneService.getAlumne(this.route.snapshot.params.id)
      .subscribe( data => {
        this.alumne = data;
      });
  };
  
  creaLlicencia(): void {
    let llicencia = new Llicencia();
    llicencia.idAlumne = this.alumne.id;
    llicencia.any = this.novaLlicencia;
    this.llicenciaService.createLlicencia(this.alumne.id, llicencia)
        .subscribe( data => {
		    this.alumneService.getAlumne(this.alumne.id)
		      .subscribe( data => {
		        this.alumne = data;
		        this.selectedLlicencia = 0;
 				this.selectedLlicenciaAny = 0;
		      });
        });

  };
  deleteLlicencia(id: string): void {
    this.llicenciaService.deleteLlicencia(this.alumne.id, id)
      .subscribe( data => {
        this.alumne.llicencies = this.alumne.llicencies.filter(u => u.id !== id);
	    this.dialogShown = true;
      });  
  };
  
  openDialog(llic: number, llicAny: number) {
  	this.selectedLlicenciaAny = llicAny;
  	this.selectedLlicencia = llic;
	this.dialogShown = false;    		
  }
  closeDialog(){
	this.dialogShown = true;
  }
    
  creaRebut(): void {
    let rebut = new Rebut();
    rebut.idAlumne = this.alumne.id;
    rebut.any = this.nouRebut;
    rebut.mes = this.nouRebutMes;
    this.rebutService.createRebut(this.alumne.id, rebut)
        .subscribe( data => {
		    this.alumneService.getAlumne(this.alumne.id)
		      .subscribe( data => {
		        this.alumne = data;
		           this.selectedRebut = 0;
 				   this.selectedRebutAny = 0;
 				   this.selectedRebutMes = 0;
		      });
        });

  };
  deleteRebut(id: string): void {
    this.rebutService.deleteRebut(this.alumne.id, id)
      .subscribe( data => {
        this.alumne.rebuts = this.alumne.rebuts.filter(u => u.id !== id);
	    this.dialogRebutShown = true;
      });  
  };
  
  openDialogRebut(llic: number, llicAny: number, llicMes: number) {
  	this.selectedRebutAny = llicAny;
  	this.selectedRebutMes = llicMes;
  	this.selectedRebut = llic;
	this.dialogRebutShown = false;    		
  }
  closeDialogRebut(){
	this.dialogRebutShown = true;
  }
  
}
