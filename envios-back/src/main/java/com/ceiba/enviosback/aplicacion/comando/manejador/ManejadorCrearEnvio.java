package com.ceiba.enviosback.aplicacion.comando.manejador;

import com.ceiba.enviosback.aplicacion.comando.ComandoEnvio;
import com.ceiba.enviosback.aplicacion.comando.fabrica.FabricaEnvio;
import com.ceiba.enviosback.dominio.modelo.Envio;
import com.ceiba.enviosback.dominio.servicio.ServicioCrearEnvio;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearEnvio {
    private final ServicioCrearEnvio servicioCrearEnvio;
    private final FabricaEnvio fabricaEnvio;

    public ManejadorCrearEnvio(ServicioCrearEnvio servicioCrearEnvio, FabricaEnvio fabricaEnvio) {
        this.servicioCrearEnvio = servicioCrearEnvio;
        this.fabricaEnvio = fabricaEnvio;
    }
    public  void  ejecutar(ComandoEnvio comandoEnvio){
        Envio envio= this.fabricaEnvio.crear(comandoEnvio);
        this.servicioCrearEnvio.ejecutar(envio);
    }
}
