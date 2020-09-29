package com.ceiba.enviosback.aplicacion.comando.manejador;

import com.ceiba.enviosback.dominio.modelo.dto.EnviosDto;
import com.ceiba.enviosback.dominio.puerto.dao.DaoEnvio;
import com.ceiba.enviosback.dominio.servicio.ServicioConsultarEnvios;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ManejadorConsultarEnvios {
    private final ServicioConsultarEnvios servicioConsultarEnvios;

    public ManejadorConsultarEnvios( ServicioConsultarEnvios servicioConsultarEnvios) {
        this.servicioConsultarEnvios = servicioConsultarEnvios;
    }
    public List<EnviosDto> ejecutar(){
        return this.servicioConsultarEnvios.mostrarTodos();
    }
}
