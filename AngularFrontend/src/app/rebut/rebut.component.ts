import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { saveAs } from 'file-saver';

import { Fitxer } from '../models/fitxer.model';
import { Rebut } from '../models/rebut.model';
import { RebutService } from './rebut.service';

@Component({
  selector: 'app-rebut',
  templateUrl: './rebut.component.html',
  styles: []
})
export class RebutComponent implements OnInit {

  rebuts: Rebut[];
  dialogShown: boolean = true;
  selectedRebut: Rebut = new Rebut();
  cercadorMes : string = "";
  cercadorAny : string = "";
  mesActual : string = ""; 
  anyActual : string = ""; 
   
  constructor(private router: Router, private rebutService: RebutService) {
  }

  ngOnInit() {
    this.dialogShown = true;
    this.cercaRebuts();
    var currentDate = new Date();
  	this.mesActual = "" +(currentDate.getMonth()+1)
  	this.anyActual = "" + currentDate.getFullYear();
  };

  cercaRebuts(){
    this.rebutService.getRebuts(this.cercadorMes, this.cercadorAny)
      .subscribe( data => {
        this.rebuts = data;
      });
  }

  creaRebut(){
    this.rebutService.crearRebut()
      .subscribe( data => {
        var blob = new Blob([data.text], { type: 'text/plain' });
        saveAs(blob, "rebuts_"+this.mesActual+"_"+this.anyActual+".xml");
        this.cercaRebuts();
      });
  }

  validarRebut(id: string): void {
    this.rebutService.validarRebut(id)
      .subscribe( data => {
        this.cercaRebuts();
	    this.dialogShown = true;
      });  
  };

  openDialog(rebut: Rebut) {
  	this.selectedRebut = rebut;
	this.dialogShown = false;    		
  }
  closeDialog(){
	this.dialogShown = true;
  }
  
}


