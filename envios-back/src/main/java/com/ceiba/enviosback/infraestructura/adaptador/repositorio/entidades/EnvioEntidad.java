package com.ceiba.enviosback.infraestructura.adaptador.repositorio.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "envios")
@Getter
@Setter

public class EnvioEntidad {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Column
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Column
    private String remitente;
    @Column
    private String receptor;
    @Column
    private String receptorDireccion;
    @Column
    private double peso;
    @Column
    private  int valor;
}
