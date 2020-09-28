package com.ceiba.enviosback.infraestructura.configuracion;

import com.ceiba.enviosback.dominio.puerto.dao.DaoEnvio;
import com.ceiba.enviosback.dominio.puerto.dao.DaoPrecio;
import com.ceiba.enviosback.dominio.puerto.repositorio.RepositorioEnvio;
import com.ceiba.enviosback.dominio.servicio.ServicioConsultarEnvios;
import com.ceiba.enviosback.dominio.servicio.ServicioCrearEnvio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {
    @Bean
    public ServicioCrearEnvio servicioCrearEnvio(RepositorioEnvio repositorioEnvio, DaoPrecio daoPrecio) {
        return new ServicioCrearEnvio(repositorioEnvio, daoPrecio);
    }
    @Bean
    public ServicioConsultarEnvios servicioConsultarEnvios(DaoEnvio daoEnvio){
        return new ServicioConsultarEnvios(daoEnvio);
    }
}
