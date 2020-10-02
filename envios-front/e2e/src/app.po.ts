import { browser, by, element } from 'protractor';

export class AppPage {
  navigateTo(): Promise<unknown> {
    return browser.get(browser.baseUrl) as Promise<unknown>;
  }

  getTitleText(): Promise<string> {
    return element(by.css('app-root h1')).getText() as Promise<string>;
  }
  navigateTo1(): Promise<unknown> {
    return browser.get('http://localhost:4200/envio/crear') as Promise<unknown>;
  }

  getTitleText1(): Promise<string> {
    return element(by.css('app-root h1')).getText() as Promise<string>;
  }
}
