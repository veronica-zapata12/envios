import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Envio } from '../../shared/modelo/envio';
import { EnvioService } from '../../shared/servicio/envio.service';

@Component({
  selector: 'app-listar-envios',
  templateUrl: './listar-envios.component.html',
  styleUrls: ['./listar-envios.component.sass']
})
export class ListarEnviosComponent implements OnInit {
  public listaEnvio: Envio[];
  public buscarid: Envio;
  idForm: FormGroup;
  paginaActual = 1;
  constructor(protected envioService: EnvioService) { }


  ngOnInit(): void {
    this.listaTodos();
    this.limpiar();
  }
  listaTodos() {
    this.envioService.consultarTodos().subscribe(data => {
      this.listaEnvio = data;

    });
  }

  listarPorId(id: number) {

    this.envioService.consultarPorId(id).subscribe(data => {
      this.buscarid = data
    });
    setTimeout(() => { this.limpiar() }, 7000);
  }
  private limpiar() {
    this.idForm = new FormGroup({
      idEnvio: new FormControl('', [Validators.required]),
    });
    this.buscarid = null;
  }
}
