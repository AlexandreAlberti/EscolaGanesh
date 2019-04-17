import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Rebut } from '../models/rebut.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class RebutService {

  constructor(private http:HttpClient) {}

  private rebutUrl = 'http://localhost:8080/alumne/';
  private rebutUrl2 = '/rebut/';

  public deleteRebut(alumneID, rebutID) {
    return this.http.delete(this.rebutUrl + alumneID + this.rebutUrl2 + rebutID);
  }

  public createRebut(alumneID, rebut) {
    return this.http.post<Rebut>(this.rebutUrl + alumneID + this.rebutUrl2, rebut);
  }
  

}
