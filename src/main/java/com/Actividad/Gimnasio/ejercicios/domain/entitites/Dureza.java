package com.Actividad.Gimnasio.ejercicios.domain.entitites;

public class Dureza {
    private Integer  resistencia;
    private Integer velocidad;
    private Integer recuperacion;

    public Dureza setResistencia(Integer resistencia) {
        this.resistencia = resistencia;
        return this;
    }

    public Dureza setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
        return this;
    }

    public Dureza setRecuperacion(Integer recuperación) {
        this.recuperacion = recuperación;
        return this;
    }

    public Dureza() {
    }

    public Integer getResistencia() {
        return resistencia;
    }

    public Integer getVelocidad() {
        return velocidad;
    }

    public Integer getRecuperacion() {
        return recuperacion;
    }
}
