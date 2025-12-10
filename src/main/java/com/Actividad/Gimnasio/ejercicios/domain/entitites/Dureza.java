package com.Actividad.Gimnasio.ejercicios.domain.entitites;

public class Dureza {
    private int  resistencia;
    private int velocidad;
    private int recuperación;

    public Dureza(int resistencia, int velocidad, int recuperación) {
        this.resistencia = resistencia;
        this.velocidad = velocidad;
        this.recuperación = recuperación;
    }

    public int getResistencia() {
        return resistencia;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getRecuperación() {
        return recuperación;
    }
}
