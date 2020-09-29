package com.ceiba.enviosback.infraestructura.controlador;

import com.ceiba.enviosback.aplicacion.comando.ComandoEnvio;
import com.ceiba.enviosback.aplicacion.comando.manejador.ManejadorConsultaEnviosPorId;
import com.ceiba.enviosback.aplicacion.comando.manejador.ManejadorConsultarEnvios;
import com.ceiba.enviosback.aplicacion.comando.manejador.ManejadorCrearEnvio;
import com.ceiba.enviosback.dominio.modelo.dto.EnviosDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/envios")
public class ControladorEnvio {
    private final ManejadorCrearEnvio manejadorCrearEnvio;
    private final ManejadorConsultaEnviosPorId manejadorConsultaEnviosPorId;
    private final ManejadorConsultarEnvios manejadorConsultarEnvios;

    public ControladorEnvio(ManejadorCrearEnvio manejadorCrearEnvio, ManejadorConsultaEnviosPorId manejadorConsultaEnviosPorId, ManejadorConsultarEnvios manejadorConsultarEnvios) {
        this.manejadorCrearEnvio = manejadorCrearEnvio;
        this.manejadorConsultaEnviosPorId = manejadorConsultaEnviosPorId;
        this.manejadorConsultarEnvios = manejadorConsultarEnvios;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void crear(@RequestBody ComandoEnvio comandoEnvio) {
        this.manejadorCrearEnvio.ejecutar(comandoEnvio);
    }

    @GetMapping(value = "/{id}")
    public EnviosDto consultarEnviosPorId(@PathVariable long id) {
        return this.manejadorConsultaEnviosPorId.bucarEnvioId(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<EnviosDto> consultarEnvios() {
        return this.manejadorConsultarEnvios.ejecutar();
    }


}
