package com.Actividad.Gimnasio.entrenamientos.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ejercicio {
    private int id;
    private String titulo;
    private String descripcion;
    private List<String> etiquetas = new ArrayList<>();
    private double duracion;
    private HashMap<String, Integer> dureza = new HashMap<>();
    public HashMap<String, String> materiales = new HashMap<>();
    public HashMap<String, String> multimedia = new HashMap<>();

    public Ejercicio(){}

    public int getId() {
        return id;
    }

    public Ejercicio id(int id) {
        this.id = id;
        return this;
    }

    public String titulo() {
        return titulo;
    }

    public Ejercicio titulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Ejercicio descripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public List<String> getEtiquetas() {
        return etiquetas;
    }

    public Ejercicio etiquetas(List<String> etiquetas) {
        this.etiquetas = etiquetas;
        return this;
    }

    public double getDuracion() {
        return duracion;
    }

    public Ejercicio duracion(double duracion) {
        this.duracion = duracion;
        return this;
    }

    public HashMap<String, Integer> getDureza() {
        return dureza;
    }

    public Ejercicio dureza(HashMap<String, Integer> dureza) {
        this.dureza = dureza;
        return this;
    }

    public HashMap<String, String> getMateriales() {
        return materiales;
    }

    public Ejercicio materiales(HashMap<String, String> materiales) {
        this.materiales = materiales;
        return this;
    }

    public HashMap<String, String> getMultimedia() {
        return multimedia;
    }

    public Ejercicio multimedia(HashMap<String, String> multimedia) {
        this.multimedia = multimedia;
        return this;
    }
}
