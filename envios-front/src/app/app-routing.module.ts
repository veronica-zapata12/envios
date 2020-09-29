import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InicioComponent } from './features/inicio/inicio.component';



const routes: Routes = [
  { path: 'inicio', component:InicioComponent  },
  { path: 'envio', loadChildren: () => import('./features/envios/envios.module').then(mod => mod.EnviosModule) },
  { path: '**', redirectTo: 'inicio'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
