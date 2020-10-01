import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InicioComponent } from '../inicio/inicio.component';
import { CrearEnvioComponent } from './componentes/crear-envio/crear-envio.component';
import { ListarEnviosComponent } from './componentes/listar-envios/listar-envios.component';



const routes: Routes = [ 
      {
        path: 'crear',
        component: CrearEnvioComponent
      },
      {
        path: 'listar',
        component: ListarEnviosComponent
      },

   
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EnviosRoutingModule { }
