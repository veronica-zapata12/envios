package com.ceiba.enviosback.dominio.validador;

import com.ceiba.enviosback.dominio.excepcion.ExcepcionCampoObligatorio;
import com.ceiba.enviosback.dominio.excepcion.ExcepcionPesoObligatorio;

public final class ValidadorDeArgumento {
    private ValidadorDeArgumento() {
    }

    public static void validarObligatorio(String valor, String mensaje) {
        if (valor == null) {
            {
                throw new ExcepcionCampoObligatorio(mensaje);
            }
        }
    }

    public static void validarPesoObligatorio(Double valor, String mensaje) {
        if (valor <= 0) {
            {
                throw new ExcepcionPesoObligatorio(mensaje);
            }
        }
    }
}
