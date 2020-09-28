package com.ceiba.enviosback.testInfraestructura;
import com.ceiba.enviosback.EnviosBackApplication;
import com.ceiba.enviosback.aplicacion.comando.ComandoEnvio;
import com.ceiba.enviosback.dominio.puerto.dao.DaoPrecio;
import com.ceiba.enviosback.dominio.puerto.repositorio.RepositorioEnvio;
import com.ceiba.enviosback.infraestructura.adaptador.dao.DaoPrecioPostgres;
import com.ceiba.enviosback.infraestructura.adaptador.repositorio.entidades.PrecioEntidad;
import com.ceiba.enviosback.infraestructura.repositoriojpa.RepositorioEnvioJpa;
import com.ceiba.enviosback.infraestructura.repositoriojpa.RepositorioPrecioJpa;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = EnviosBackApplication.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControladorEnvioTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private RepositorioPrecioJpa repositorioPrecioJpa;
    @Autowired
    private RepositorioEnvioJpa repositorioEnvioJpa;

    @BeforeEach
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }


    @Test
    public void guardarEnvioTestd() throws Exception {
        PrecioEntidad precioEntidad =new PrecioEntidad(1l,40.1,80.0,50000);
        repositorioPrecioJpa.save(precioEntidad);
        ComandoEnvio comandoEnvio = new ComandoEnvioDatabuilder().build();
        DaoPrecioPostgres daoPrecioPostgres = new DaoPrecioPostgres(repositorioPrecioJpa) ;
        daoPrecioPostgres.consultarPrecio(comandoEnvio.getPeso());
        mockMvc.perform(post("/envios").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoEnvio)))
                .andExpect(status().isOk());
    }

}
