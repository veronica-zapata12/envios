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
    private boolean envioExpress;


    public Envio(Long idEnvio, String remitente, String receptor, String receptorDireccion, double peso, boolean envioExpress) {
        fechaIngreso = new Date();
        this.idEnvio = idEnvio;
        this.remitente = remitente;
        this.receptor = receptor;
        this.receptorDireccion = receptorDireccion;
        this.peso = peso;
        this.envioExpress = envioExpress;
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

    public boolean isEnvioExpress() {
        return envioExpress;
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
        int diaAdicional = 1;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        if (envioExpress) {
            calendar.add(Calendar.DAY_OF_YEAR, diaAdicional);
        } else {
            calendar.add(Calendar.DAY_OF_YEAR, diasParaEntrega);
        }
        int diaDomingo = calendar.get(Calendar.DAY_OF_WEEK);
        if (diaDomingo == Calendar.SUNDAY) {
            calendar.add(Calendar.DAY_OF_YEAR, diaAdicional);

        }

        return calendar.getTime();
    }

}
