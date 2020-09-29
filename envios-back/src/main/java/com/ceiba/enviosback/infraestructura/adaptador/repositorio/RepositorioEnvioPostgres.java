package com.ceiba.enviosback.infraestructura.adaptador.repositorio;

import com.ceiba.enviosback.dominio.modelo.Envio;
import com.ceiba.enviosback.dominio.puerto.repositorio.RepositorioEnvio;
import com.ceiba.enviosback.infraestructura.adaptador.repositorio.entidades.EnvioEntidad;
import com.ceiba.enviosback.infraestructura.repositoriojpa.RepositorioEnvioJpa;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioEnvioPostgres implements RepositorioEnvio {
    private ModelMapper modelMapper = new ModelMapper();
    private final RepositorioEnvioJpa repositorioEnvioJpa;

    public RepositorioEnvioPostgres(RepositorioEnvioJpa repositorioEnvioJpa) {
        this.repositorioEnvioJpa = repositorioEnvioJpa;
    }

    @Override
    public void crear(Envio envio) {
        EnvioEntidad envioEntidad = modelMapper.map(envio, EnvioEntidad.class);
        this.repositorioEnvioJpa.save(envioEntidad);

    }
}
