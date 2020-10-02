import { AppPage } from './app.po';
import { browser } from 'protractor';

import { EnvioPage } from './page/envio/envio.po';

describe('workspace-project App', () => {
  let page: AppPage;
  let envio: EnvioPage;

  beforeEach(() => {
      page = new AppPage();
  
      envio = new EnvioPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getTitleText()).toEqual('Bienvenidos a Envios S.A');
  });
  it('Deberia crear producto', () => {
    
    const REMITENTE = 'juan';
    const RECEPTOR = 'Emilio';
    const RECEPTOR_DIRECCION='CALLE 25 ';
    const PESO=50;
    const ENVIO_EXPRESS=true;
    page.navigateTo1();
    envio.ingresarRemitente(REMITENTE);
    envio.ingresarReceptor(RECEPTOR);
    envio.ingresarReceptorDireccion(RECEPTOR_DIRECCION);
    envio.ingresarPeso(PESO);
    envio.ingresarEnvioExpress(ENVIO_EXPRESS);
    browser.sleep( 2000);
    envio.botonContinuar();
    browser.sleep( 2000);
    envio.botonTexto();
    browser.sleep( 2000);
    expect(page.getTitleText()).toEqual('Bienvenidos a Envios S.A');
});
});
