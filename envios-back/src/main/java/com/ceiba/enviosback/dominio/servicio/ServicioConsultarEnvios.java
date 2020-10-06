package com.ceiba.enviosback.dominio.servicio;

import com.ceiba.enviosback.dominio.modelo.dto.EnviosDto;
import com.ceiba.enviosback.dominio.puerto.dao.DaoEnvio;

import java.util.List;

public class ServicioConsultarEnvios {
    private final DaoEnvio daoEnvio;

    public ServicioConsultarEnvios(DaoEnvio daoEnvio) {
        this.daoEnvio = daoEnvio;
    }

    public EnviosDto buscarPorId(Long id) {
        return this.daoEnvio.bucarPorId(id);
    }

    public List<EnviosDto> mostrarTodos() {
        return this.daoEnvio.mostrarTodos();
    }
}