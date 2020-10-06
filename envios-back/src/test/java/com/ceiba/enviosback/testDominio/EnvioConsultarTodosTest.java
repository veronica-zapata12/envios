package com.ceiba.enviosback.testDominio;

import com.ceiba.enviosback.dominio.modelo.dto.EnviosDto;
import com.ceiba.enviosback.dominio.puerto.dao.DaoEnvio;
import com.ceiba.enviosback.dominio.servicio.ServicioConsultarEnvios;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EnvioConsultarTodosTest {
    private DaoEnvio daoEnvio;
    private ServicioConsultarEnvios servicioConsultarEnvios;

    @BeforeEach
    public void init() {
        daoEnvio = Mockito.mock(DaoEnvio.class);
        servicioConsultarEnvios = new ServicioConsultarEnvios(daoEnvio);
    }

    @Test
    void obtenerEnvioPorId() {
        List<EnviosDto>enviosDtoLista=new ArrayList<>();
        EnviosDto enviosDto = new EnviosDto(1L, new Date(), new Date(), "juan", "pedro", "calle 23#32-4", 25.5, 25000, false);
        enviosDtoLista.add(enviosDto);
        EnviosDto enviosDto2 = new EnviosDto(1L, new Date(), new Date(), "pedro", "andres", "calle 45#25-4", 35.5, 25000, false);
        enviosDtoLista.add(enviosDto2);

        Mockito.when(daoEnvio.mostrarTodos()).thenReturn(enviosDtoLista);
        List<EnviosDto> enviosDto1 = servicioConsultarEnvios.mostrarTodos();
        Assertions.assertNotNull(enviosDto1);
    }
}
