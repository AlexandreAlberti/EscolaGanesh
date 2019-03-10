import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Alumnes } from '../models/alumnes.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class AlumnesService {

  constructor(private http:HttpClient) {}

  private alumnesUrl = 'http://localhost:8080/alumnes';
  //private alumnesUrl = '/api';

  public getAlumness() {
    return this.http.get<Alumnes[]>(this.alumnesUrl);
  }

  public deleteAlumnes(alumnes) {
    return this.http.delete(this.alumnesUrl + "/"+ alumnes.id);
  }

  public createAlumnes(alumnes) {
    return this.http.post<Alumnes>(this.alumnesUrl, alumnes);
  }

}
