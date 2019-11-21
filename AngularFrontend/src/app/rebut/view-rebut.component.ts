import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

import { Rebut } from '../models/rebut.model';
import { RebutService } from './rebut.service';

@Component({
  templateUrl: './view-rebut.component.html'
})
export class ViewRebutComponent {

  rebut: Rebut = new Rebut();
  dialogShown: boolean = true;
  dialogShownRetornar: boolean = true;
  selectedAlumne: string = "";
  selectedAlumneId: string = "";
  
  constructor(private route: ActivatedRoute, private router: Router, private rebutService: RebutService) {

  }

  back(): void {
    this.router.navigateByUrl('/rebut');
  };

  ngOnInit() {
    this.dialogShown = true;
    this.rebutService.getRebut(this.route.snapshot.params.id)
      .subscribe( data => {
        this.rebut = data;
      });
  };
  
  retornarRebut(id: string): void {
    this.rebutService.retornarRebut(id)
      .subscribe( data => {
	    this.dialogShown = true;
	    this.rebutService.getRebut(this.route.snapshot.params.id)
	      .subscribe( data => {
	        this.rebut = data;
	      });
      });  
  };

  referRebut(id: string): void {
    this.rebutService.referRebut(id)
      .subscribe( data => {
	    this.dialogShownRetornar = true;
	    this.rebutService.getRebut(this.route.snapshot.params.id)
	      .subscribe( data => {
	        this.rebut = data;
	      });
      });  
  };
    
  openDialog(idLinea: string, nomAlumne: string) {
	this.dialogShown = false;
	this.selectedAlumne = nomAlumne;		
	this.selectedAlumneId = idLinea;		
  }
  closeDialog(){
	this.dialogShown = true;
	this.selectedAlumne = "";		
	this.selectedAlumneId = "";		
  }  
  
  openDialogRetornar(idLinea: string, nomAlumne: string) {
	this.dialogShownRetornar = false;
	this.selectedAlumne = nomAlumne;		
	this.selectedAlumneId = idLinea;		
  }
  closeDialogRetornar(){
	this.dialogShownRetornar = true;
	this.selectedAlumne = "";		
	this.selectedAlumneId = "";		
  }  
}
