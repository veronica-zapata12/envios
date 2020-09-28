package com.ceiba.enviosback.infraestructura.repositoriojpa;
import com.ceiba.enviosback.infraestructura.adaptador.repositorio.entidades.EnvioEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;


@Repository
public interface RepositorioEnvioJpa extends JpaRepository<EnvioEntidad, Serializable> {

   /* @Query("select e from EnvioEntidad e where p.id =: id")
    EnvioEntidad buscarPorId(@PathVariable("id") Long id);*/
}
