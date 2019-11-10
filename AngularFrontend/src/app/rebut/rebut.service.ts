import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Fitxer } from '../models/fitxer.model';
import { Rebut } from '../models/rebut.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class RebutService {

  constructor(private http:HttpClient) {}

  private rebutUrl = 'http://localhost:8080/rebut';

  public getRebuts(cercadorMes, cercadorAny) {
    return this.http.get<Rebut[]>(this.rebutUrl + "?cercaMes=" + cercadorMes + "&cercaAnys=" + cercadorAny);
  }
  
  public crearRebut() {
    return this.http.post<Fitxer>(this.rebutUrl, "");
  }
  
  public validarRebut(rebutID) {
    return this.http.put(this.rebutUrl + "/"+ rebutID, "");
  }
}
