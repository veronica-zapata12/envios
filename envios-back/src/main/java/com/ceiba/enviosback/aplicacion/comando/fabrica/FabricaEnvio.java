package com.ceiba.enviosback.aplicacion.comando.fabrica;

import com.ceiba.enviosback.aplicacion.comando.ComandoEnvio;
import com.ceiba.enviosback.dominio.modelo.Envio;
import org.springframework.stereotype.Component;

@Component
public class FabricaEnvio {
    public Envio crear(ComandoEnvio comandoEnvio){
        return new Envio(comandoEnvio.getIdEnvio(),comandoEnvio.getRemitente(),comandoEnvio.getReceptor(),comandoEnvio.getReceptorDireccion(),comandoEnvio.getPeso());
    }
}
