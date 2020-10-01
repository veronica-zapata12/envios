import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { EnviosModule } from './features/envios/envios.module';
import { InicioComponent } from './features/inicio/inicio.component';
import { SharedModule } from './shared/shared.module';
import { CoreModule } from './core/core.module';
import { HttpService } from './core/service/http.service';

@NgModule({
  declarations: [
    AppComponent,
    InicioComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule, 
    EnviosModule,
    SharedModule, 
    CoreModule
  ],
  providers: [HttpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
