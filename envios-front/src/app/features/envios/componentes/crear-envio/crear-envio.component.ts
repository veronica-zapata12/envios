import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Envio } from 'src/app/features/envios/shared/modelo/envio';
import { EnvioService } from '../../shared/servicio/envio.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-crear-envio',
  templateUrl: './crear-envio.component.html',
  styleUrls: ['./crear-envio.component.sass']
})
export class CrearEnvioComponent implements OnInit {
  envioForm: FormGroup;
  public listaEnvio: Envio[];
  public idReferencial: number;
  constructor(protected envioService: EnvioService) { }

  ngOnInit(): void {
    this.construirFormularioProducto();
    this.consultarTodosEnvios();
  }

  crear() {
    if (this.envioForm.valid) {
      this.envioService.guardar(this.envioForm.value).subscribe(() => {

        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'El envío ha sido creado con éxito',
          text: 'Su Id de referencia es: ' + (this.idReferencial + 1),
          showConfirmButton: true,

        });
        this.consultarTodosEnvios();
      });

      this.construirFormularioProducto();
    }
  }
  consultarTodosEnvios() {
    this.envioService.consultarTodos().subscribe(data => {
      this.listaEnvio = data
      this.idReferencial = this.listaEnvio.length

    });

  }

  private construirFormularioProducto() {
    this.envioForm = new FormGroup({
      remitente: new FormControl('', [Validators.required]),
      receptor: new FormControl('', [Validators.required]),
      receptorDireccion: new FormControl('', [Validators.required]),
      peso: new FormControl('', [Validators.required]),
      envioExpress: new FormControl(false, [Validators.required])
    });
  }






  get f() {
    return this.envioForm.controls;
  }

}
