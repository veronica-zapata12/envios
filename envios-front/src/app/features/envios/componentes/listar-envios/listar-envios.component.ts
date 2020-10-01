import { AfterViewInit, Component, OnInit } from '@angular/core';
import { Envio } from '../../shared/modelo/envio';
import { EnvioService } from '../../shared/servicio/envio.service';

@Component({
  selector: 'app-listar-envios',
  templateUrl: './listar-envios.component.html',
  styleUrls: ['./listar-envios.component.sass']
})
export class ListarEnviosComponent implements OnInit {
  public listaEnvio: Envio[];
  public buscarid:Envio
  constructor(protected envioService: EnvioService) { }
  

  ngOnInit(): void {
   this.listaTodos();
  }
listaTodos(){
  this.envioService.consultarTodos().subscribe(data => {
    this.listaEnvio = data
    console.log(this.listaEnvio);
  });
}
listarPorId(id:number){
  console.log("entra");
  console.log(id);
  
  this.envioService.consultarPorId(id).subscribe(data => {
    this.buscarid = data
    console.log(this.buscarid);    
  });
}
}
