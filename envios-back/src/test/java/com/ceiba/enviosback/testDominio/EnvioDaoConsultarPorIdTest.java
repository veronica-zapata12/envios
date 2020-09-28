package com.ceiba.enviosback.testDominio;

import com.ceiba.enviosback.dominio.modelo.Envio;
import com.ceiba.enviosback.dominio.modelo.dto.EnviosDto;
import com.ceiba.enviosback.dominio.puerto.dao.DaoEnvio;
import com.ceiba.enviosback.dominio.servicio.ServicioConsultarEnvios;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Date;

import static org.mockito.Mockito.mock;

public class EnvioDaoConsultarPorIdTest {
    private DaoEnvio daoEnvio;
    private ServicioConsultarEnvios servicioConsultarEnvios;
    @BeforeEach
    public void init(){
        daoEnvio= Mockito.mock(DaoEnvio.class);
        servicioConsultarEnvios=new ServicioConsultarEnvios(daoEnvio);
    }
    @Test
    void obtenerEnvioPorId(){
        EnviosDto enviosDto =new EnviosDto(1L,new Date(),new Date(),"juan","pedro","calle 23#32-4",25.5,25000,false);
        Mockito.when(daoEnvio.bucarPorId(1L)).thenReturn(enviosDto);
        EnviosDto enviosDto1=servicioConsultarEnvios.buscarPorId(1L);
        Assertions.assertFalse(enviosDto1 ==null);
    }

}