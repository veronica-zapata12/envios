package com.ceiba.enviosback.dominio.modelo;

import com.ceiba.enviosback.dominio.validador.ValidadorDeArgumento;
import lombok.Getter;


import java.util.Calendar;
import java.util.Date;
@Getter

public class Envio {
    private static final String EL_REMITENTE_ES_OBLIGATORIO = "el remitente es obligatorio";
    private static final String EL_RECEPTOR_ES_OBLIGATORIO = "el receptor es obligatorio";
    private static final String LA_DIRECCION_RECEPTOR_ES_OBLIGATORIO = "la direccion del receptor es obligatorio";
    private static final String EL_PESO_ES_OBLIGATORIO = "el peso es obligatorio";

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
        ValidadorDeArgumento.validarObligatorio(remitente, EL_REMITENTE_ES_OBLIGATORIO);
        ValidadorDeArgumento.validarObligatorio(receptor, EL_RECEPTOR_ES_OBLIGATORIO);
        ValidadorDeArgumento.validarObligatorio(receptorDireccion, LA_DIRECCION_RECEPTOR_ES_OBLIGATORIO);
        ValidadorDeArgumento.validarPesoObligatorio(peso, EL_PESO_ES_OBLIGATORIO);
        fechaIngreso = new Date();
        this.idEnvio = idEnvio;
        this.remitente = remitente;
        this.receptor = receptor;
        this.receptorDireccion = receptorDireccion;
        this.peso = peso;
        this.envioExpress = envioExpress;
        fechaEntrega = this.calcularFechaEntrega(fechaIngreso);


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
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    private Date calcularFechaEntrega(Date fecha) {
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
