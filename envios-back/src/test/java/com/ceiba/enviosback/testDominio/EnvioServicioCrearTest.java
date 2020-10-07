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
    void crearEnvioSinExpress() {

        Envio envio = new EnvioDataBuilder().build();
        Mockito.when(daoPrecio.consultarPrecio(envio.getPeso())).thenReturn(50000);
        servicioCrearEnvio.ejecutar(envio);
        Assertions.assertEquals(envio.getRemitente(), "camilo");
        Assertions.assertEquals(envio.getReceptor(), "andres");
        Assertions.assertEquals(envio.getReceptorDireccion(), "calle 38 # 23-56");
        Assertions.assertEquals(envio.getPeso(), 45.6);
        Assertions.assertEquals(envio.isEnvioExpress(), false);
        Assertions.assertEquals(envio.getValor(), 50000);

    }

    @Test
    void crearEnvioConExpress() {
        Envio envio = new EnvioDataBuilder().conEnvioExpress(true).build();
        Mockito.when(daoPrecio.consultarPrecio(envio.getPeso())).thenReturn(50000);
        servicioCrearEnvio.ejecutar(envio);
        Assertions.assertEquals(envio.getRemitente(), "camilo");
        Assertions.assertEquals(envio.getReceptor(), "andres");
        Assertions.assertEquals(envio.getReceptorDireccion(), "calle 38 # 23-56");
        Assertions.assertEquals(envio.getPeso(), 45.6);
        Assertions.assertEquals(envio.isEnvioExpress(), true);
        Assertions.assertEquals(envio.getValor(), 65000);


    }

    @Test
    public void crearEnviosinReceptor() {


        Assertions.assertThrows(ExcepcionCampoObligatorio.class, () ->
                new EnvioDataBuilder().sinReceptor(null).build(), "el receptor es obligatorio"
        );
    }

    @Test

    public void crearEnviosinPeso() {
        Assertions.assertThrows(ExcepcionPesoObligatorio.class, () ->
                new EnvioDataBuilder().sinPeso(0.0).build(), "el peso es obligatorio");

    }

}
