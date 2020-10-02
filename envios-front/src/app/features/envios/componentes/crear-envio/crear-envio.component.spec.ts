import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { of } from 'rxjs';
import { HttpService } from 'src/app/core/service/http.service';
import { Envio } from '../../shared/modelo/envio';
import { EnvioService } from '../../shared/servicio/envio.service';

import { CrearEnvioComponent } from './crear-envio.component';

describe('CrearEnvioComponent', () => {
  let component: CrearEnvioComponent;
  let fixture: ComponentFixture<CrearEnvioComponent>;
  let envioService:EnvioService;
  const listaProductos: Envio[] = [{idEnvio:32,remitente:'pedro', receptor:'juan',receptorDireccion:'calle 35#33-22',peso:50,envioExpress:false}];

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CrearEnvioComponent ],
      imports: [
        CommonModule,
        HttpClientModule,
        RouterTestingModule,
        ReactiveFormsModule,
        FormsModule
      ],
      providers: [EnvioService, HttpService],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearEnvioComponent);
    component = fixture.componentInstance;
    envioService = TestBed.inject(EnvioService);
    spyOn(envioService, 'guardar').and.returnValue(
      of(true)
    );
    spyOn(envioService, 'consultarTodos').and.returnValue(
      of(listaProductos)
    );
    fixture.detectChanges();
  });

 
  it('Creando envio', () => {
    expect(component.envioForm.valid).toBeFalsy();
    component.envioForm.controls.remitente.setValue('juan');
    component.envioForm.controls.receptor.setValue('pedro');
    component.envioForm.controls.receptorDireccion.setValue('calle 90 # 26-35');
    component.envioForm.controls.peso.setValue(50);
    component.envioForm.controls.envioExpress.setValue(false);
    expect(component.envioForm.valid).toBeTruthy();

    expect({remitente:'juan', receptor:'pedro',receptorDireccion:'calle 90 # 26-35',peso:50,envioExpress:false}).toEqual(component.envioForm.value);
  
    component.crear();
  });
});
