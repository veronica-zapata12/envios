package com.ceiba.enviosback.aplicacion.comando;


import java.util.Date;


public class ComandoEnvio {
    private Long idEnvio;
    private Date fechaIngreso;
    private Date fechaEntrega;
    private String remitente;
    private String receptor;
    private String receptorDireccion;
    private double peso;
    private int valor;
    private boolean envioExpress;

    public ComandoEnvio(Long idEnvio, String remitente, String receptor, String receptorDireccion, double peso, boolean envioExpress) {
        this.idEnvio = idEnvio;
        fechaIngreso = new Date();
        this.remitente = remitente;
        this.receptor = receptor;
        this.receptorDireccion = receptorDireccion;
        this.peso = peso;
        this.envioExpress=envioExpress;
    }

    public Long getIdEnvio() {
        return idEnvio;
    }

    /*public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }*/

    public boolean isEnvioExpress() {
        return envioExpress;
    }

    public String getRemitente() {
        return remitente;
    }

    public String getReceptor() {
        return receptor;
    }

    public String getReceptorDireccion() {
        return receptorDireccion;
    }

    public double getPeso() {
        return peso;
    }
/*
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }*/
}
