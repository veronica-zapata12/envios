package com.ceiba.enviosback.dominio.puerto.dao;

import com.ceiba.enviosback.dominio.modelo.dto.EnviosDto;

public interface DaoEnvio {
    EnviosDto bucarPorId(Long id);
}
