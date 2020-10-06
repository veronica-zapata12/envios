package com.ceiba.enviosback.dominio.modelo.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EnviosDto {
    private Long idEnvio;
    private Date fechaIngreso;
    private Date fechaEntrega;
    private String remitente;
    private String receptor;
    private String receptorDireccion;
    private double peso;
    private int valor;
    private boolean envioExpress;

    public EnviosDto() {
    }

    public EnviosDto(Long idEnvio, Date fechaIngreso, Date fechaEntrega, String remitente, String receptor, String receptorDireccion, double peso, int valor, boolean envioExpress) {
        this.idEnvio = idEnvio;
        this.fechaIngreso = fechaIngreso;
        this.fechaEntrega = fechaEntrega;
        this.remitente = remitente;
        this.receptor = receptor;
        this.receptorDireccion = receptorDireccion;
        this.peso = peso;
        this.valor = valor;
        this.envioExpress = envioExpress;
    }

}