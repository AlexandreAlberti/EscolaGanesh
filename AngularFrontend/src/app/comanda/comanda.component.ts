import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Comanda } from '../models/comanda.model';
import { ComandaService } from './comanda.service';

@Component({
  selector: 'app-comanda',
  templateUrl: './comanda.component.html',
  styles: []
})
export class ComandaComponent implements OnInit {

  comandas: Comanda[];
  dialogShown: boolean = true;
  dialogShown2: boolean = true;
  selectedComanda: Comanda = new Comanda();
  pagatTrueOentregatFalse: boolean = false;
  pagatTrueOentregatFalseValue: boolean = false;

  constructor(private router: Router, private comandaService: ComandaService) {

  }

  ngOnInit() {
    this.dialogShown = true;
    this.cercaComandas();
  };

  cercaComandas(){
    this.comandaService.getComandas()
      .subscribe( data => {
        this.comandas = data;
      });
  }

  deleteComanda(id: string): void {
    this.comandaService.deleteComanda(id)
      .subscribe( data => {
        this.comandas = this.comandas.filter(u => u.id !== id);
	    this.dialogShown = true;
      });  
  };

  goCreateComanda(): void {
    this.router.navigateByUrl('/comanda/add');
  };

  goEditComanda(comanda: Comanda): void {
    if (this.pagatTrueOentregatFalse && !this.pagatTrueOentregatFalseValue) {
      this.comandaService.pagaComanda(comanda).subscribe( data => {
        this.cercaComandas();
        this.dialogShown2 = true;
      });
    } else if (this.pagatTrueOentregatFalse && this.pagatTrueOentregatFalseValue) {
      this.comandaService.despagaComanda(comanda).subscribe( data => {
        this.cercaComandas();
        this.dialogShown2 = true;
      });
    } else if (!this.pagatTrueOentregatFalse && !this.pagatTrueOentregatFalseValue) {
      this.comandaService.entregaComanda(comanda).subscribe( data => {
        this.cercaComandas();
        this.dialogShown2 = true;
      });
    } else if (!this.pagatTrueOentregatFalse && this.pagatTrueOentregatFalseValue) {
      this.comandaService.desentregaComanda(comanda).subscribe( data => {
        this.cercaComandas();
        this.dialogShown2 = true;
      });
    }
  };

  openDialog(comanda: Comanda) {
  	this.selectedComanda = comanda;
	  this.dialogShown = false;    		
  }
  closeDialog(){
	  this.dialogShown = true;
  }
  openDialog2(comanda: Comanda, pagatTrueOentregatFalse: boolean, pagatTrueOentregatFalseValue: boolean) {
    this.selectedComanda = comanda;
    this.dialogShown2 = false;
    this.pagatTrueOentregatFalse = pagatTrueOentregatFalse;
    this.pagatTrueOentregatFalseValue = pagatTrueOentregatFalseValue;
  }
  closeDialog2(){
    this.dialogShown2 = true;
  }  

}


