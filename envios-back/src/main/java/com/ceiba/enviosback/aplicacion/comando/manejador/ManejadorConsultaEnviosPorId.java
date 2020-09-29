package com.ceiba.enviosback.aplicacion.comando.manejador;

import com.ceiba.enviosback.dominio.modelo.dto.EnviosDto;
import com.ceiba.enviosback.dominio.puerto.dao.DaoEnvio;
import com.ceiba.enviosback.dominio.servicio.ServicioConsultarEnvios;
import org.springframework.stereotype.Component;


@Component
public class ManejadorConsultaEnviosPorId {
    private final ServicioConsultarEnvios servicioConsultarEnvios;
    ;

    public ManejadorConsultaEnviosPorId(ServicioConsultarEnvios servicioConsultarEnvios) {
        this.servicioConsultarEnvios = servicioConsultarEnvios;

    }

    public EnviosDto bucarEnvioId(Long id) {
        return this.servicioConsultarEnvios.buscarPorId(id);
    }

}
