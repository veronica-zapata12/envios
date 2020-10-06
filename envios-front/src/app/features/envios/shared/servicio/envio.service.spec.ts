import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { EnvioService } from './envio.service';
import { environment } from 'src/environments/environment';
import { HttpService } from 'src/app/core/service/http.service';
import { HttpResponse } from '@angular/common/http';

describe('EnvioService', () => {
  let service: EnvioService;
  let httpMock: HttpTestingController;
  const apiEndpointEnviosConsulta = `${environment.endpoint}envios`;
  const apiEndpointEnvios = `${environment.endpoint}envios`;
  const apiEndpointEnviosConsultaId = `${environment.endpoint}envios/`;

  beforeEach(() => {
    const injector = TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [EnvioService, HttpService]
    });
    httpMock = injector.inject(HttpTestingController);
    service = TestBed.inject(EnvioService);
  });

  it('should be created', () => {
    const productService: EnvioService = TestBed.inject(EnvioService);
    expect(productService).toBeTruthy();
  });

  it('deberia listar Envios', () => {
    const dummyEnvios =[{envioExpress: true,fechaEntrega: "2020-09-25",fechaIngreso: "2020-09-24",idEnvio: 1,peso: 10.1, receptor: "andres", receptorDireccion: "calle 90 #56-38",remitente: "pedro", valor: 32500},
    {envioExpress: false,fechaEntrega: "2020-10-05",fechaIngreso: "2020-10-01",idEnvio: 2,peso: 60.5, receptor: "jaime", receptorDireccion: "calle 90 #56-38",remitente: "antonio", valor: 50000}];
    service.consultarTodos().subscribe(envios => {
      expect(envios.length).toBe(2);
      expect(envios).toEqual(dummyEnvios);
    });
    const req = httpMock.expectOne(apiEndpointEnviosConsulta);
    expect(req.request.method).toBe('GET');
    req.flush(dummyEnvios);
  });
  it('deberia listar un envio', () => {
    const dummyEnvios ={envioExpress: true,fechaEntrega: "2020-09-25",fechaIngreso: "2020-09-24",idEnvio: 1,peso: 10.1, receptor: "andres", receptorDireccion: "calle 90 #56-38",remitente: "pedro", valor: 32500};
    service.consultarPorId(1).subscribe(envios => {
      expect(envios).toEqual(dummyEnvios);
    });
    const req = httpMock.expectOne(apiEndpointEnviosConsultaId+1);
    expect(req.request.method).toBe('GET');
    req.flush(dummyEnvios);
  });
  it('deberia crear un Envio', () => {
    const dummyEnvios = {envioExpress: true,fechaEntrega: "2020-09-25",fechaIngreso: "2020-09-24",idEnvio: 1,peso: 10.1, receptor: "andres", receptorDireccion: "calle 90 #56-38",remitente: "pedro", valor: 32500};
    service.guardar(dummyEnvios).subscribe((respuesta) => {
      expect(respuesta).toEqual(true);
    });
    const req = httpMock.expectOne(apiEndpointEnvios);
    expect(req.request.method).toBe('POST');
    req.event(new HttpResponse({body: true}));
  });
});
