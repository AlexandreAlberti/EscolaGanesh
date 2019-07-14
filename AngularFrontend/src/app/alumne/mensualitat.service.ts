import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Mensualitat } from '../models/mensualitat.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class MensualitatService {

  constructor(private http:HttpClient) {}

  private mensualitatUrl = 'http://localhost:8080/alumne/';
  private mensualitatUrl2 = '/mensualitat/';

  public deleteMensualitat(alumneID, mensualitatID) {
    return this.http.delete(this.mensualitatUrl + alumneID + this.mensualitatUrl2 + mensualitatID);
  }

  public createMensualitat(alumneID, mensualitat) {
    return this.http.post<Mensualitat>(this.mensualitatUrl + alumneID + this.mensualitatUrl2, mensualitat);
  }
  
  public pagarMensualitat(alumneID, mensualitatID) {
    return this.http.put(this.mensualitatUrl + alumneID + this.mensualitatUrl2 + mensualitatID + '/pagat', "");
  }
  
  public tornarMensualitat(alumneID, mensualitatID) {
    return this.http.put(this.mensualitatUrl + alumneID + this.mensualitatUrl2 + mensualitatID + '/retornar', "");
  }

}
