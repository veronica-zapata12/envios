package com.ceiba.enviosback.infraestructura.adaptador.dao;

import com.ceiba.enviosback.dominio.modelo.Envio;
import com.ceiba.enviosback.dominio.puerto.dao.DaoPrecio;
import com.ceiba.enviosback.infraestructura.adaptador.repositorio.entidades.EnvioEntidad;
import com.ceiba.enviosback.infraestructura.repositoriojpa.RepositorioPrecioJpa;
import org.springframework.stereotype.Repository;

@Repository
public class DaoPrecioPostgres implements DaoPrecio {
    private final RepositorioPrecioJpa repositorioPrecioJpa;

    public DaoPrecioPostgres(RepositorioPrecioJpa repositorioPrecioJpa) {
        this.repositorioPrecioJpa = repositorioPrecioJpa;
    }


    @Override
    public int consultarPrecio(double peso) {
        return repositorioPrecioJpa.consultarPrecio(peso);
    }
}
