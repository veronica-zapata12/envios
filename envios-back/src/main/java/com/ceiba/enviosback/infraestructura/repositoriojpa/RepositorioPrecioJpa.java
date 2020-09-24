package com.ceiba.enviosback.infraestructura.repositoriojpa;


import com.ceiba.enviosback.infraestructura.adaptador.repositorio.entidades.PrecioEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;

public interface RepositorioPrecioJpa extends JpaRepository<PrecioEntidad, Serializable> {
    @Query("Select p.precio from PrecioEntidad p where :peso between pesoMinimo and pesoMaximo")
    int consultarPrecio(double peso);
}
