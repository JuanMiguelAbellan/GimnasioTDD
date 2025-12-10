package com.Actividad.Gimnasio.ejercicios.domain.entitites;

public class Multimedia {
    private String tipo;
    private String url;

    public Multimedia(String tipo, String url) {
        this.tipo = tipo;
        this.url = url;
    }

    public String getTipo() {
        return tipo;
    }

    public String getUrl() {
        return url;
    }
}
