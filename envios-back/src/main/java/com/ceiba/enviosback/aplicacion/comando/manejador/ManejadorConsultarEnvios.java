package com.ceiba.enviosback.aplicacion.comando.manejador;

import com.ceiba.enviosback.dominio.modelo.dto.EnviosDto;
import com.ceiba.enviosback.dominio.puerto.dao.DaoEnvio;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ManejadorConsultarEnvios {
    private final DaoEnvio daoEnvio;

    public ManejadorConsultarEnvios(DaoEnvio daoEnvio) {
        this.daoEnvio = daoEnvio;
    }
    public List<EnviosDto> ejecutar(){
        return this.daoEnvio.mostrarTodos();
    }
}
