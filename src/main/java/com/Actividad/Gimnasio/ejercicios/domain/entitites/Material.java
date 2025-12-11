package com.Actividad.Gimnasio.ejercicios.domain.entitites;

public class Material {
    private String tipo;
    private Integer cantidad;

    public Material() {
    }

    public Material setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public Material setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }
}
