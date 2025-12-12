package com.Actividad.Gimnasio.entrenamientos.domain;

import com.Actividad.Gimnasio.ejercicios.domain.Ejercicio;
import com.Actividad.Gimnasio.jugadores.domain.Jugador;

import java.util.ArrayList;
import java.util.List;

public class Entrenamiento {
    private Integer id_SQL;
    private String id_Mongo;
    private String fecha;
    private List<Ejercicio> ejercicios = new ArrayList<>();
    private List<Jugador> asistentes = new ArrayList<>();

    public Entrenamiento() {
    }

    public Integer getId_SQL() {
        return id_SQL;
    }

    public Entrenamiento id_SQL(Integer id_SQL) {
        this.id_SQL = id_SQL;
        return this;
    }

    public String getId_Mongo() {
        return id_Mongo;
    }

    public Entrenamiento id_Mongo(String id_Mongo) {
        this.id_Mongo = id_Mongo;
        return this;
    }

    public String getFecha() {
        return fecha;
    }

    public Entrenamiento fecha(String fecha) {
        this.fecha = fecha;
        return this;
    }

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public Entrenamiento ejercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
        return this;
    }

    public List<Jugador> getAsistentes() {
        return asistentes;
    }

    public Entrenamiento asistentes(List<Jugador> asistentes) {
        this.asistentes = asistentes;
        return this;
    }
}
