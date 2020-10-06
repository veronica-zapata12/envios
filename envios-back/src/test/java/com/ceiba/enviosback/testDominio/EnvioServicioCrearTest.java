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

        try {
            servicioCrearEnvio.ejecutar(envio);
            Assertions.assertEquals(envio.getRemitente(), "camilo");
            Assertions.assertEquals(envio.getReceptor(), "andres");
            Assertions.assertEquals(envio.getReceptorDireccion(), "calle 38 # 23-56");
            Assertions.assertEquals(envio.getPeso(), 45.6);
            Assertions.assertEquals(envio.isEnvioExpress(), false);

        } catch (Exception e) {
            Assertions.fail("error en la creacion del envio");

        }
    }

    @Test
    void crearEnvioConExpress() {
        Envio envio = new EnvioDataBuilder().conEnvioExpress(true).build();
        try {
            servicioCrearEnvio.ejecutar(envio);
            Assertions.assertEquals(envio.getRemitente(), "camilo");
            Assertions.assertEquals(envio.getReceptor(), "andres");
            Assertions.assertEquals(envio.getReceptorDireccion(), "calle 38 # 23-56");
            Assertions.assertEquals(envio.getPeso(), 45.6);
            Assertions.assertEquals(envio.isEnvioExpress(), true);


        } catch (Exception e) {
            Assertions.fail("error en la creacion del envio");

        }

    }

    @Test
    public void crearEnviosinReceptor() {


        try {
            Envio envio = new EnvioDataBuilder().sinReceptor(null).build();
            servicioCrearEnvio.ejecutar(envio);
            Assertions.fail("se esperaba una excepcion de tipo ExcepcionCampoObligatorio ");

        } catch (ExcepcionCampoObligatorio e) {

            Assertions.assertEquals("el receptor es obligatorio", e.getMessage());

        }

    }

    @Test

    public void crearEnviosinPeso() {
        try {
            Envio envio = new EnvioDataBuilder().sinPeso(0.0).build();
            servicioCrearEnvio.ejecutar(envio);
            Assertions.fail("se esperaba una excepcion de tipo ExcepcionPesoObligatorio ");

        } catch (ExcepcionPesoObligatorio e) {

            Assertions.assertEquals("el peso es obligatorio", e.getMessage());

        }
    }

}
