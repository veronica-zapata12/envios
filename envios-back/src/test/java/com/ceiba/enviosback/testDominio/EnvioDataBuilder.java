package com.ceiba.enviosback.testDominio;

import com.ceiba.enviosback.dominio.modelo.Envio;

import java.util.Date;

public class EnvioDataBuilder {
    private static final Long ID = 1L;
    private static final String REMITENTE = "camilo";
    private static final String RECEPTOR = "andres";
    private static final String RECEPTORDIRECCION = "calle 38 # 23-56";
    private static final Double PESO = 45.6;
    private static final Boolean ENVIOEXPRESS = false;
    private Long idEnvio;
    private String remitente;
    private String receptor;
    private String receptorDireccion;
    private double peso;
    private boolean envioExpress;

    public EnvioDataBuilder() {
        this.idEnvio=ID;
        this.remitente=REMITENTE;
        this.receptor=RECEPTOR;
        this.receptorDireccion=RECEPTORDIRECCION;
        this.peso=PESO;
        this.envioExpress=ENVIOEXPRESS;
    }
    public EnvioDataBuilder conEnvioExpress(boolean envioExpress){
        this.envioExpress = envioExpress;
        return this;
    }
    public Envio build(){
        return new Envio(this.idEnvio,this.remitente,this.receptor,this.receptorDireccion,this.peso, this.envioExpress);
    }
}
