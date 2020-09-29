package com.ceiba.enviosback.dominio.servicio;

import com.ceiba.enviosback.dominio.modelo.Envio;
import com.ceiba.enviosback.dominio.puerto.dao.DaoPrecio;
import com.ceiba.enviosback.dominio.puerto.repositorio.RepositorioEnvio;

public class ServicioCrearEnvio {
    private final RepositorioEnvio repositorioEnvio;
    private final DaoPrecio daoPrecio;
    private boolean envioExpress;

    public ServicioCrearEnvio(RepositorioEnvio repositorioEnvio, DaoPrecio daoPrecio) {
        this.repositorioEnvio = repositorioEnvio;
        this.daoPrecio = daoPrecio;
    }

    public void ejecutar(Envio envio) {
        envioExpress = envio.isEnvioExpress();
        envio.setValor(precioEnvio(envio.getPeso()));

        this.repositorioEnvio.crear(envio);
    }

    private int precioEnvio(double peso) {

        // variables para el costo adicional del envio 30% sobre el valor
        int porcentajeTotal = 100;
        int porcentajeDeAumento = 30;

        int valor = daoPrecio.consultarPrecio(peso);

        if (envioExpress) {
            int costoAdicional = (valor * porcentajeDeAumento) / porcentajeTotal;
            valor = valor + costoAdicional;

        }
        return valor;

    }
}
