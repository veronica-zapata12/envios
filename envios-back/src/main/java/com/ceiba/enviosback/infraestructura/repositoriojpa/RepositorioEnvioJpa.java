package com.ceiba.enviosback.infraestructura.repositoriojpa;
import com.ceiba.enviosback.dominio.modelo.dto.EnviosDto;
import com.ceiba.enviosback.infraestructura.adaptador.repositorio.entidades.EnvioEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;


@Repository
public interface RepositorioEnvioJpa extends JpaRepository<EnvioEntidad, Serializable> {

    @Query(value = "select * from envios where envios.id = :id ", nativeQuery = true)
    EnvioEntidad buscarPorId(@Param("id") Long id);
}
