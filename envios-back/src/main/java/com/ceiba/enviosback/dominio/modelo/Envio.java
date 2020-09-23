package com.ceiba.enviosback.dominio.modelo;

import java.util.Calendar;
import java.util.Date;

public class Envio {
    private Long idEnvio;
    private Date fechaIngreso;
    private Date fechaEntrega;
    private String remitente;
    private String receptor;
    private String receptorDireccion;
    private double peso;
    private int valor;


    public Envio(Long idEnvio, String remitente, String receptor, String receptorDireccion, double peso) {
        fechaIngreso = new Date();
        this.idEnvio = idEnvio;
        this.remitente = remitente;
        this.receptor = receptor;
        this.receptorDireccion = receptorDireccion;
        this.peso = peso;
        fechaEntrega = this.calcularFechaEntrega(fechaIngreso);

    }

    public Long getIdEnvio() {
        return idEnvio;
    }


    public Date getFechaIngreso() {
        return fechaIngreso;
    }


    public Date getFechaEntrega() {
        return fechaEntrega;
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

    public int getValor() {
        // estos pesos son en kilogramos
        double pesoLiviano = 10.0;
        double pesoMedio = 20.0;
        double pesoPesado = 40.0;

        if (peso < pesoLiviano) {
            valor = 15000;
        } else if (peso > pesoLiviano && peso < pesoMedio) {
            valor = 25000;
        } else if (peso > pesoMedio && peso < pesoPesado) {
            valor = 35000;
        } else {
            valor = 50000;
        }
        return setValor(valor);


    }

    public int setValor(int valor) {
        this.valor = valor;
        return valor;
    }

    public Date calcularFechaEntrega(Date fecha) {
        int diasParaEntrega = 3;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, diasParaEntrega);

        return calendar.getTime();
    }

}
