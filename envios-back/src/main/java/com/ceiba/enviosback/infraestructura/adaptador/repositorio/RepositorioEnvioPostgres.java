package com.ceiba.enviosback.infraestructura.adaptador.repositorio;

import com.ceiba.enviosback.dominio.modelo.Envio;
import com.ceiba.enviosback.dominio.puerto.repositorio.RepositorioEnvio;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioEnvioPostgres implements RepositorioEnvio {

    @Override
    public void crear(Envio envio) {

    }
}
