import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EnviosRoutingModule } from './envios-routing.module';
import { CrearEnvioComponent } from './componentes/crear-envio/crear-envio.component';



@NgModule({
  declarations: [CrearEnvioComponent],
  imports: [
    CommonModule,
    EnviosRoutingModule
  ]
})
export class EnviosModule { }
