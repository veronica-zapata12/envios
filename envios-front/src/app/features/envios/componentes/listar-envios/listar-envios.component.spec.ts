import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { of } from 'rxjs';
import { HttpService } from 'src/app/core/service/http.service';
import { Envio } from '../../shared/modelo/envio';
import { EnvioService } from '../../shared/servicio/envio.service';
import { NgxPaginationModule } from 'ngx-pagination';
import { ListarEnviosComponent } from './listar-envios.component';

describe('ListarEnviosComponent', () => {
  let component: ListarEnviosComponent;
  let fixture: ComponentFixture<ListarEnviosComponent>;
  let envioService:EnvioService;
  const listaEnvios: Envio[] = [{envioExpress: true,fechaEntrega: "2020-09-25",fechaIngreso: "2020-09-24",idEnvio: 1,peso: 10.1, receptor: "andres", receptorDireccion: "calle 90 #56-38",remitente: "pedro", valor: 32500},{envioExpress: false,fechaEntrega: "2020-10-05",fechaIngreso: "2020-10-01",idEnvio: 2,peso: 60.5, receptor: "jaime", receptorDireccion: "calle 90 #56-38",remitente: "antonio", valor: 50000}];
 // const buscarid: Envio = {envioExpress: true,fechaEntrega: "2020-09-25",fechaIngreso: "2020-09-24",idEnvio: 1,peso: 10.1, receptor: "andres", receptorDireccion: "calle 90 #56-38",remitente: "pedro", valor: 32500};

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListarEnviosComponent ],
      imports: [
        CommonModule,
        HttpClientModule,
        RouterTestingModule,
        ReactiveFormsModule,
        FormsModule,NgxPaginationModule
      ],
      providers: [EnvioService, HttpService],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarEnviosComponent);
    component = fixture.componentInstance;
    envioService = TestBed.inject(EnvioService);
    
    spyOn(envioService, 'consultarTodos').and.returnValue(
      of(listaEnvios)
    );
    
    fixture.detectChanges();
  });

  it('debería listar todos', () => {
    expect(component).toBeTruthy();
    expect(2).toBe(listaEnvios.length);
});
});

