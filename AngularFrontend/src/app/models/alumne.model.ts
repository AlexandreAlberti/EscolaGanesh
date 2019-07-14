import { Llicencia } from '../models/llicencia.model';
import { Mensualitat } from '../models/mensualitat.model';

export class Alumne {

  id: string;
  firstName: string;
  lastName: string;
  email: string;
  cid: string;
  dni: string;
  direccio: string;
  poblacio: string;
  telefon: string;
  dadesBancaries: string;
  jjk: boolean;
  totsival: boolean;
  tkd: boolean;
  jjkInfantil: boolean;
  jjkIniciacio: boolean;
  ioga: boolean;
  cuota: number;
  observacions: string;
  llicencies: Llicencia[];
  llicenciaPagada: boolean;
  mensualitats: Mensualitat[];
  mensualitatPagat: boolean;
  balanc: number;
}
