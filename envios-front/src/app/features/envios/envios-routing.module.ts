import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InicioComponent } from '../inicio/inicio.component';
import { CrearEnvioComponent } from './componentes/crear-envio/crear-envio.component';



const routes: Routes = [ 
      {
        path: 'crear',
        component: CrearEnvioComponent
      }   
   
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EnviosRoutingModule { }
