import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Alumne } from '../models/alumne.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class AlumneService {

  constructor(private http:HttpClient) {}

  private alumneUrl = 'http://localhost:8080/alumne';

  public getAlumnes() {
    return this.http.get<Alumne[]>(this.alumneUrl);
  }

  public deleteAlumne(alumne) {
    return this.http.delete(this.alumneUrl + "/"+ alumne.id);
  }

  public createAlumne(alumne) {
    return this.http.post<Alumne>(this.alumneUrl, alumne);
  }
  public editAlumne(alumne) {
    return this.http.put<Alumne>(this.alumneUrl+"/"+ alumne.id, alumne);
  }
  public getAlumne(alumneID) {
    return this.http.get<Alumne>(this.alumneUrl+"/"+ alumneID);
  }

}
