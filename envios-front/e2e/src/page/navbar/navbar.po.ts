import { by, element } from 'protractor';

export class NavbarPage {
    private linkCrearEnvio = element(by.id('crearEnvio'));
    private linkListarEnvios = element(by.id('listaEnvio'));
    

    async clickBotonCrearEnvio() {
        await this.linkCrearEnvio.click();
    }

    async clickBotonListarEnvio() {
        await this.linkListarEnvios.click();
    }

}
