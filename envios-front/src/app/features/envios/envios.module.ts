import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EnviosRoutingModule } from './envios-routing.module';
import { CrearEnvioComponent } from './componentes/crear-envio/crear-envio.component';
import { HttpClientModule } from '@angular/common/http';

import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { EnvioService } from './shared/servicio/envio.service';
import { SharedModule } from 'src/app/shared/shared.module';
import { ListarEnviosComponent } from './componentes/listar-envios/listar-envios.component';



@NgModule({
  declarations: [CrearEnvioComponent, ListarEnviosComponent],
  imports: [
    CommonModule,
    EnviosRoutingModule,
    ReactiveFormsModule, 
    FormsModule,
    SharedModule
   
  ],
  providers:[EnvioService]
})
export class EnviosModule { }
