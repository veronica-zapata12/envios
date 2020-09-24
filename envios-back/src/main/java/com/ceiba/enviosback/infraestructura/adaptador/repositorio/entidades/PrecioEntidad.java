package com.ceiba.enviosback.infraestructura.adaptador.repositorio.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "precio")
@Getter
@AllArgsConstructor

public class PrecioEntidad {
    @Id
    private Long id;
    @Column
    private  double pesoMinimo;
    @Column
    private  double pesoMaximo;
    @Column
    private  int precio;
}
