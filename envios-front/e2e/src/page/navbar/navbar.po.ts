import { by, element } from 'protractor';
export class NavbarPage {
    linkInicio = element(by.xpath('/html/body/app-root/app-navbar/nav/a[1]'));
    linkCrearEnvio = element(by.xpath('/html/body/app-root/app-navbar/nav/a[2]'));
    linkListarEnvio = element(by.xpath('/html/body/app-root/app-navbar/nav/a[3]'));

    async clickBotonCrearEnvio() {
        await this.linkCrearEnvio.click();
    }
    async clickBotonListarEnvio() {
        await this.linkListarEnvio.click();
    }
}
