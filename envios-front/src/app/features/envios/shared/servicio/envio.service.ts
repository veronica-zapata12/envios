
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HttpService } from 'src/app/core/service/http.service';
import { environment } from 'src/environments/environment';


import { Envio } from '../modelo/envio';


@Injectable()
export class EnvioService  {

  constructor( protected http:HttpService) {
  
  }
  public guardar(envio: Envio) {
 
    console.log(envio);
    return this.http.doPost(`${environment.endpoint}envios`,envio, this.http.optsName('crear envio'));
  }
  public consultarTodos() {
    return this.http.doGet<Envio[]>(`${environment.endpoint}envios`);
  }   
  public consultarPorId(id:number){
    return this.http.doGetParameters<Envio>(`${environment.endpoint}envios/`+id);
  }  
}