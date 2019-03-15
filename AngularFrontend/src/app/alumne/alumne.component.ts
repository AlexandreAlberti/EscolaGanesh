import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Alumne } from '../models/alumne.model';
import { AlumneService } from './alumne.service';

@Component({
  selector: 'app-alumne',
  templateUrl: './alumne.component.html',
  styles: []
})
export class AlumneComponent implements OnInit {

  alumnes: Alumne[];
  dialogShown: boolean = true;
  selectedAlumne: Alumne = Alumne;

  constructor(private router: Router, private alumneService: AlumneService) {

  }

  ngOnInit() {
    this.dialogShown = true;
    this.alumneService.getAlumnes()
      .subscribe( data => {
        this.alumnes = data;
      });
  };

  deleteAlumne(id: string): void {
    this.alumneService.deleteAlumne(id)
      .subscribe( data => {
        this.alumnes = this.alumnes.filter(u => u.id !== id);
	    this.dialogShown = true;
      });  
  };
  goCreateAlumne(): void {
    this.router.navigateByUrl('/alumne/add');
  };
  goEditAlumne(alumne: Alumne): void {
    this.router.navigateByUrl('/alumne/edit/' + alumne.id);
  };
  goViewAlumne(alumne: Alumne): void {
    this.router.navigateByUrl('/alumne/view/' + alumne.id);
  };

  openDialog(alumne: Alumne) {
  	this.selectedAlumne = alumne;
	this.dialogShown = false;    		
  }
  closeDialog(){
	this.dialogShown = true;
  }
  
}


