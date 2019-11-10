import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Fitxer } from '../models/fitxer.model';
import { Material } from '../models/material.model';
import { TipusMaterial } from '../models/tipusmaterial.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class MaterialService {

  constructor(private http:HttpClient) {}

  private materialUrl = 'http://localhost:8080/material';
  private materialTipusUrl = 'http://localhost:8080/material/tipus';
  private materialLlistaCompraUrl = 'http://localhost:8080/material/compra';

  public getMaterials(cercador) {
    return this.http.get<Material[]>(this.materialUrl + "?cerca=" + cercador);
  }
  
  public getTipus() {
    return this.http.get<TipusMaterial[]>(this.materialTipusUrl);
  }

  public getLlistaCompra() {
    return this.http.get<Fitxer>(this.materialLlistaCompraUrl);
  }

  public deleteMaterial(materialID) {
    return this.http.delete(this.materialUrl + "/"+ materialID);
  }

  public createMaterial(material) {
    return this.http.post<Material>(this.materialUrl, material);
  }
  public editMaterial(material) {
    return this.http.put<Material>(this.materialUrl+"/"+ material.id, material);
  }
  public getMaterial(materialID) {
    return this.http.get<Material>(this.materialUrl+"/"+ materialID);
  }

}
