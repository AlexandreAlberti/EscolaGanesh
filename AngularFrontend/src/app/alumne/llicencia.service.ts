import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Llicencia } from '../models/llicencia.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class LlicenciaService {

  constructor(private http:HttpClient) {}

  private llicenciaUrl = 'http://localhost:8080/alumne/';
  private llicenciaUrl2 = '/llicencia/';

  public deleteLlicencia(alumneID, llicenciaID) {
    return this.http.delete(this.llicenciaUrl + alumneID + this.llicenciaUrl2 + llicenciaID);
  }

  public createLlicencia(alumneID, llicencia) {
    return this.http.post<Llicencia>(this.llicenciaUrl + alumneID + this.llicenciaUrl2, llicencia);
  }
  

}
