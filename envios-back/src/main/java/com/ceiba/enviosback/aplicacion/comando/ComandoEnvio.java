package com.ceiba.enviosback.aplicacion.comando;


public class ComandoEnvio {
    private Long idEnvio;
    private String remitente;
    private String receptor;
    private String receptorDireccion;
    private double peso;
    private boolean envioExpress;

    public ComandoEnvio(Long idEnvio, String remitente, String receptor, String receptorDireccion, double peso, boolean envioExpress) {
        this.idEnvio = idEnvio;
        this.remitente = remitente;
        this.receptor = receptor;
        this.receptorDireccion = receptorDireccion;
        this.peso = peso;
        this.envioExpress=envioExpress;
    }

    public Long getIdEnvio() {
        return idEnvio;
    }


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

}
