import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InicioComponent } from './features/inicio/inicio.component';


const routes: Routes = [
  { path: 'inicio', component:InicioComponent  },
  { path: '**', redirectTo: 'inicio' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
