package com.ceiba.enviosback.testDominio;

import com.ceiba.enviosback.dominio.excepcion.ExcepcionCampoObligatorio;
import com.ceiba.enviosback.dominio.excepcion.ExcepcionPesoObligatorio;
import com.ceiba.enviosback.dominio.modelo.Envio;
import com.ceiba.enviosback.dominio.puerto.dao.DaoPrecio;
import com.ceiba.enviosback.dominio.puerto.repositorio.RepositorioEnvio;
import com.ceiba.enviosback.dominio.servicio.ServicioCrearEnvio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class EnvioServicioCrearTest {
    private static final int VALOR_ESPERADO_CON_ENVIO_EXPRESS = 65000;
    private static final int VALOR_ESPERADO_SIN_ENVIO_EXPRESS = 50000;
    private RepositorioEnvio repositorioEnvio;
    private DaoPrecio daoPrecio;
    private ServicioCrearEnvio servicioCrearEnvio;

    @BeforeEach
    public void crear() {
        daoPrecio = Mockito.mock(DaoPrecio.class);

        repositorioEnvio = Mockito.mock(RepositorioEnvio.class);

        servicioCrearEnvio = new ServicioCrearEnvio(repositorioEnvio, daoPrecio);
    }

    @Test
    public void crearEnvioSinExpress() {

        Envio envio = new EnvioDataBuilder().build();
        Mockito.when(daoPrecio.consultarPrecio(envio.getPeso())).thenReturn(50000);
        servicioCrearEnvio.ejecutar(envio);
        Assertions.assertEquals("camilo",envio.getRemitente() );
        Assertions.assertEquals("andres",envio.getReceptor() );
        Assertions.assertEquals("calle 38 # 23-56", envio.getReceptorDireccion());
        Assertions.assertEquals( 45.6,envio.getPeso());
        Assertions.assertEquals(false,envio.isEnvioExpress());
        Assertions.assertEquals(VALOR_ESPERADO_SIN_ENVIO_EXPRESS, envio.getValor());;

    }

    @Test
    public void crearEnvioConExpress() {
        Envio envio = new EnvioDataBuilder().conEnvioExpress(true).build();
        Mockito.when(daoPrecio.consultarPrecio(envio.getPeso())).thenReturn(50000);
        servicioCrearEnvio.ejecutar(envio);
        Assertions.assertEquals("camilo",envio.getRemitente() );
        Assertions.assertEquals("andres",envio.getReceptor() );
        Assertions.assertEquals("calle 38 # 23-56", envio.getReceptorDireccion());
        Assertions.assertEquals( 45.6,envio.getPeso());
        Assertions.assertEquals(true,envio.isEnvioExpress());
        Assertions.assertEquals(VALOR_ESPERADO_CON_ENVIO_EXPRESS, envio.getValor());


    }

    @Test
    public void crearEnviosinReceptor() {
        Assertions.assertThrows(ExcepcionCampoObligatorio.class, () ->
                new EnvioDataBuilder().sinReceptor(null).build(), "el receptor es obligatorio"
        );
    }
    @Test
    public void crearEnviosinRemitente() {
        Assertions.assertThrows(ExcepcionCampoObligatorio.class, () ->
                new EnvioDataBuilder().sinRemitente(null).build(), "el remitente es obligatorio"
        );
    }

    @Test

    public void crearEnviosinPeso() {
        Assertions.assertThrows(ExcepcionPesoObligatorio.class, () ->
                new EnvioDataBuilder().sinPeso(0.0).build(), "el peso es obligatorio");

    }

}
