package com.Actividad.Gimnasio.ejercicios.domain.entitites;

public class Material {
    private String tipo;
    private int cantidad;

    public Material(String tipo, int cantidad) {
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }
}
