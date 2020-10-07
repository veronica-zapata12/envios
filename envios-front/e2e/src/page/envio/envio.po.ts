import { browser, by, element } from 'protractor';

export class EnvioPage {
   
    private inputRemitente = element(by.id('remitente'));
    private inputReceptor = element(by.id('receptor'));
    private inputReceptorDireccion = element(by.id('receptorDireccion'));
    private inputPeso = element(by.id('peso'));
    private inputEnvioExpress = element(by.id('envioExpress'));
    private inputId = element(by.id('idEnvio'));

    async ingresarRemitente(remitente) {
        await this.inputRemitente.sendKeys(remitente);
    }

    async ingresarReceptor(receptor) {
        await this.inputReceptor.sendKeys(receptor);
    }
    async ingresarReceptorDireccion(receptorDireccion) {
        await this.inputReceptorDireccion.sendKeys(receptorDireccion);
    }
    async ingresarPeso(peso) {
        await this.inputPeso.sendKeys(peso);
    }
    async ingresarEnvioExpress(envioExpress) {
        await this.inputEnvioExpress.sendKeys(envioExpress);
    }
    
    async botonContinuar() {
        await element(by.id('continuar')).click();
    }
    async botonTexto() {
        await element(by.buttonText('OK')).click();;
    }
    async ingresarIdParaBuscar(id) {
        await this.inputId.sendKeys(id);
    }
    async botonBuscar() {
        await element(by.id('buscar')).click();
    }

     pausa(){
        browser.sleep(2000);
    }


}
