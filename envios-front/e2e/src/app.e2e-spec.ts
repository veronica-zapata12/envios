import { AppPage } from './app.po';
import { browser } from 'protractor';

import { EnvioPage } from './page/envio/envio.po';
import { NavbarPage } from './page/navbar/navbar.po';

describe('workspace-project Envíos', () => {
  let page: AppPage;
  let envio: EnvioPage;
  let navbar:NavbarPage;

  beforeEach(() => {
      page = new AppPage();
      navbar=new NavbarPage();
      envio = new EnvioPage();
  });

  it('mensaje de bienvenida', () => {
    page.navigateTo();
    expect(page.getTitleText()).toEqual('Bienvenidos a Envios S.A');
  });
  
  it('Deberia crear producto', () => {
    
    const REMITENTE = 'juan';
    const RECEPTOR = 'Emilio';
    const RECEPTOR_DIRECCION='CALLE 25 ';
    const PESO=50;
    const ENVIO_EXPRESS=true;
    navbar.clickBotonCrearEnvio();
    envio.ingresarRemitente(REMITENTE);
    envio.ingresarReceptor(RECEPTOR);
    envio.ingresarReceptorDireccion(RECEPTOR_DIRECCION);
    envio.ingresarPeso(PESO);
    envio.ingresarEnvioExpress(ENVIO_EXPRESS);
    envio.pausa();
    envio.botonContinuar();
    envio.pausa();
    envio.botonTexto();
    envio.pausa();
});

it('Deberia listar los envios y debe buscar un envio', () => {
  const IDPARABUSCAR=2;
  page.navigateTo();
  navbar.clickBotonListarEnvio();
  envio.pausa();
  envio.ingresarIdParaBuscar(IDPARABUSCAR);
  envio.botonBuscar();
  envio.pausa();
});
});
