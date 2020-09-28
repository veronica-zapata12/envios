package com.ceiba.enviosback.dominio.excepcion;

public class ExcepcionPesoObligatorio extends RuntimeException {
    public ExcepcionPesoObligatorio(String mensaje) {
        super(mensaje);
    }
}
