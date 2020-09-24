package com.ceiba.enviosback.dominio.modelo;

import lombok.Getter;

import java.util.Calendar;
import java.util.Date;
@Getter
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
    
    public double getPeso() {
        return peso;
    }

    public boolean isEnvioExpress() {
        return envioExpress;
    }



    public void setValor(int valor) {
        this.valor = valor;
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
