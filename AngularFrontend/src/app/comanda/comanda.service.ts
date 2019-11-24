import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Fitxer } from '../models/fitxer.model';
import { Comanda } from '../models/comanda.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class ComandaService {

  constructor(private http:HttpClient) {}

  private comandaUrl = 'http://localhost:8080/comanda';
  private comandaPagatUrl = 'http://localhost:8080/comanda/pagat';
  private comandaNoPagatUrl = 'http://localhost:8080/comanda/nopagat';
  private comandaEntregatUrl = 'http://localhost:8080/comanda/entregat';
  private comandaNoEntregatUrl = 'http://localhost:8080/comanda/noentregat';

  public getComandas() {
    return this.http.get<Comanda[]>(this.comandaUrl);
  }
  
  public deleteComanda(comandaID) {
    return this.http.delete(this.comandaUrl + "/"+ comandaID);
  }

  public createComanda(comanda) {
    return this.http.post<Comanda>(this.comandaUrl, comanda);
  }
  public pagaComanda(comanda) {
    return this.http.put<Comanda>(this.comandaPagatUrl+"/"+ comanda.id, "");
  }
  public despagaComanda(comanda) {
    return this.http.put<Comanda>(this.comandaNoPagatUrl+"/"+ comanda.id, "");
  }
  public entregaComanda(comanda) {
    return this.http.put<Comanda>(this.comandaEntregatUrl+"/"+ comanda.id, "");
  }
  public desentregaComanda(comanda) {
    return this.http.put<Comanda>(this.comandaNoEntregatUrl+"/"+ comanda.id, "");
  }

}
