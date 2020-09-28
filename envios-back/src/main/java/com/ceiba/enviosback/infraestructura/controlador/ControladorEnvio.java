package com.ceiba.enviosback.infraestructura.controlador;

import com.ceiba.enviosback.aplicacion.comando.ComandoEnvio;
import com.ceiba.enviosback.aplicacion.comando.manejador.ManejadorCrearEnvio;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/envios")
public class ControladorEnvio {
    private final ManejadorCrearEnvio manejadorCrearEnvio;

    public ControladorEnvio(ManejadorCrearEnvio manejadorCrearEnvio) {
        this.manejadorCrearEnvio = manejadorCrearEnvio;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void crear(@RequestBody ComandoEnvio comandoEnvio) {
        this.manejadorCrearEnvio.ejecutar(comandoEnvio);
    }

}
