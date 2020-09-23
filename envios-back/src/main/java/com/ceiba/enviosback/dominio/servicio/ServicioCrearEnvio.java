package com.ceiba.enviosback.dominio.servicio;

import com.ceiba.enviosback.dominio.modelo.Envio;
import com.ceiba.enviosback.dominio.puerto.repositorio.RepositorioEnvio;

public class ServicioCrearEnvio {
    private RepositorioEnvio repositorioEnvio;

    public ServicioCrearEnvio(RepositorioEnvio repositorioEnvio) {
        this.repositorioEnvio = repositorioEnvio;
    }

    public void ejecutar(Envio envio) {
        this.repositorioEnvio.crear(envio);
    }
}
