package com.Actividad.Gimnasio.ejercicios.domain;

import com.Actividad.Gimnasio.ejercicios.domain.entitites.Dureza;
import com.Actividad.Gimnasio.ejercicios.domain.entitites.Material;
import com.Actividad.Gimnasio.ejercicios.domain.entitites.Multimedia;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio {
    private Integer id_SQL;
    private String idMongo;
    private String titulo;
    private String descripcion;
    private List<String> etiquetas = new ArrayList<>();
    private Double duracion;
    private Dureza dureza;
    private List<Material> materiales = new ArrayList<>();
    private List<Multimedia> multimedia = new ArrayList<>();

    public Ejercicio(String titulo, String descripcion, List<String> etiquetas, double duracion, Dureza dureza, List<Material> materiales, List<Multimedia> multimedia) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.etiquetas = etiquetas;
        this.duracion = duracion;
        this.dureza = dureza;
        this.materiales = materiales;
        this.multimedia = multimedia;
    }

    public Ejercicio(){}

    public Integer getIdSQL() {
        return id_SQL;
    }

    public String getIdMongo() {
        return idMongo;
    }

    public Ejercicio idMongo(String idMongo) {
        this.idMongo = idMongo;
        return this;
    }

    public Ejercicio idSql(Integer id) {
        this.id_SQL = id;
        return this;
    }

    public String getTitulo() {
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

    public Double getDuracion() {
        return duracion;
    }

    public Ejercicio duracion(Double duracion) {
        this.duracion = duracion;
        return this;
    }

    public Dureza getDureza() {
        return dureza;
    }

    public Ejercicio dureza(Dureza dureza) {
        this.dureza = dureza;
        return this;
    }

    public List<Material> getMateriales() {
        return materiales;
    }

    public Ejercicio materiales(List<Material> materiales) {
        this.materiales = materiales;
        return this;
    }

    public List<Multimedia> getMultimedia() {
        return multimedia;
    }

    public Ejercicio multimedia(List<Multimedia> multimedia) {
        this.multimedia = multimedia;
        return this;
    }
}
