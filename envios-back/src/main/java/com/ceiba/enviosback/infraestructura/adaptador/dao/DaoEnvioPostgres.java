package com.ceiba.enviosback.infraestructura.adaptador.dao;

import com.ceiba.enviosback.dominio.modelo.dto.EnviosDto;
import com.ceiba.enviosback.dominio.puerto.dao.DaoEnvio;
import com.ceiba.enviosback.infraestructura.adaptador.repositorio.entidades.EnvioEntidad;
import com.ceiba.enviosback.infraestructura.repositoriojpa.RepositorioEnvioJpa;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

@Repository
public class DaoEnvioPostgres implements DaoEnvio {
    private ModelMapper modelMapper = new ModelMapper();
    private final RepositorioEnvioJpa repositorioEnvioJpa;

    public DaoEnvioPostgres(RepositorioEnvioJpa repositorioEnvioJpa) {
        this.repositorioEnvioJpa = repositorioEnvioJpa;
    }

    @Override
    public EnviosDto bucarPorId(Long id) {
        EnvioEntidad envioEntidad= repositorioEnvioJpa.buscarPorId(id);


        return modelMapper.map(envioEntidad,EnviosDto.class);
    }
}
