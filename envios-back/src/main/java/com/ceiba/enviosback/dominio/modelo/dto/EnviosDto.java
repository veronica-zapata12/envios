package com.ceiba.enviosback.dominio.modelo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

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

    public Long getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(Long idEnvio) {
        this.idEnvio = idEnvio;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public String getReceptorDireccion() {
        return receptorDireccion;
    }

    public void setReceptorDireccion(String receptorDireccion) {
        this.receptorDireccion = receptorDireccion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isEnvioExpress() {
        return envioExpress;
    }

    public void setEnvioExpress(boolean envioExpress) {
        this.envioExpress = envioExpress;
    }
}
