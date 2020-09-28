package com.ceiba.enviosback.dominio.puerto.dao;

import com.ceiba.enviosback.dominio.modelo.dto.EnviosDto;
import com.ceiba.enviosback.infraestructura.adaptador.repositorio.entidades.EnvioEntidad;

public interface DaoEnvio {
    EnviosDto bucarPorId(Long id);
}
