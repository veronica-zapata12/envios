package com.ceiba.enviosback.aplicacion.comando.manejador;

import com.ceiba.enviosback.dominio.modelo.dto.EnviosDto;
import com.ceiba.enviosback.dominio.puerto.dao.DaoEnvio;
import org.springframework.stereotype.Component;


@Component
public class ManejadorConsultaEnviosPorId {
    private final DaoEnvio daoEnvio;

    public ManejadorConsultaEnviosPorId(DaoEnvio daoEnvio) {
        this.daoEnvio = daoEnvio;
    }

    public EnviosDto bucarEnvioId(Long id){
        return this.daoEnvio.bucarPorId(id);
    }

}
