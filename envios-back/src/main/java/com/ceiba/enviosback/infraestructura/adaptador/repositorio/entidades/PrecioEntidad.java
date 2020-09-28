package com.ceiba.enviosback.infraestructura.adaptador.repositorio.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "precio")
@Getter
@Setter


public class PrecioEntidad {
    @Id
    private Long id;
    @Column
    private  double pesoMinimo;
    @Column
    private  double pesoMaximo;
    @Column
    private  int precio;

    public PrecioEntidad(Long id, double pesoMinimo, double pesoMaximo, int precio) {
        this.id = id;
        this.pesoMinimo = pesoMinimo;
        this.pesoMaximo = pesoMaximo;
        this.precio = precio;
    }

    public PrecioEntidad() {

    }
}
