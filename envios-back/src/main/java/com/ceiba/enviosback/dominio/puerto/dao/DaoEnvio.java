package com.ceiba.enviosback.dominio.puerto.dao;

import com.ceiba.enviosback.dominio.modelo.dto.EnviosDto;

import java.util.List;

public interface DaoEnvio {
    EnviosDto bucarPorId(Long id);
    List<EnviosDto>mostrarTodos();
}
