import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

import { Alumne } from '../models/alumne.model';
import { Llicencia } from '../models/llicencia.model';
import { Mensualitat } from '../models/mensualitat.model';
import { AlumneService } from './alumne.service';
import { LlicenciaService } from './llicencia.service';
import { MensualitatService } from './mensualitat.service';

@Component({
  templateUrl: './view-alumne.component.html'
})
export class ViewAlumneComponent {

  alumne: Alumne = new Alumne();
  novaLlicencia: number;
  nouMensualitat: number;
  nouMensualitatMes: number;
  dialogShown: boolean = true;
  dialogMensualitatShown: boolean = true;
  selectedLlicencia: number = 0;
  selectedLlicenciaAny: number = 0;
  selectedMensualitat: number = 0;
  selectedMensualitatAny: number = 0;
  selectedMensualitatMes: number = 0;


  constructor(private route: ActivatedRoute, private router: Router, private alumneService: AlumneService, private llicenciaService: LlicenciaService, private mensualitatService: MensualitatService) {

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
    
  creaMensualitat(): void {
    let mensualitat = new Mensualitat();
    mensualitat.idAlumne = this.alumne.id;
    mensualitat.any = this.nouMensualitat;
    mensualitat.mes = this.nouMensualitatMes;
    this.mensualitatService.createMensualitat(this.alumne.id, mensualitat)
        .subscribe( data => {
		    this.alumneService.getAlumne(this.alumne.id)
		      .subscribe( data => {
		        this.alumne = data;
		           this.selectedMensualitat = 0;
 				   this.selectedMensualitatAny = 0;
 				   this.selectedMensualitatMes = 0;
		      });
        });

  };
  deleteMensualitat(id: string): void {
    this.mensualitatService.deleteMensualitat(this.alumne.id, id)
      .subscribe( data => {
        this.alumne.mensualitats = this.alumne.mensualitats.filter(u => u.id !== id);
	    this.dialogMensualitatShown = true;
      });  
  };
  
  pagarMensualitat(id: string): void {
    this.mensualitatService.pagarMensualitat(this.alumne.id, id)
      .subscribe( data => {
	    this.alumneService.getAlumne(this.route.snapshot.params.id)
	      .subscribe( data => {
	        this.alumne = data;
	      });
      });  
  };
  
  tornarMensualitat(id: string): void {
    this.mensualitatService.tornarMensualitat(this.alumne.id, id)
      .subscribe( data => {
	    this.alumneService.getAlumne(this.route.snapshot.params.id)
	      .subscribe( data => {
	        this.alumne = data;
	      });
      });  
  };
  
  openDialogMensualitat(llic: number, llicAny: number, llicMes: number) {
  	this.selectedMensualitatAny = llicAny;
  	this.selectedMensualitatMes = llicMes;
  	this.selectedMensualitat = llic;
	this.dialogMensualitatShown = false;    		
  }
  closeDialogMensualitat(){
	this.dialogMensualitatShown = true;
  }
  
}
