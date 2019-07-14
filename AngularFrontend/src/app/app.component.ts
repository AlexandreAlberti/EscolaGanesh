import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'Alumne App';
  
  constructor(private router: Router) {
  }

  
  ngOnInit() {
    this.router.navigateByUrl('/alumne');
  };
  
  goAlumnes() {
    this.router.navigateByUrl('/alumne');
  };
  
  goMaterial() {
    this.router.navigateByUrl('/material');
  };

  goRebut() {
    this.router.navigateByUrl('/rebut');
  };
  
}
