package com.Actividad.Gimnasio.entrenamientos.domain;

import com.Actividad.Gimnasio.jugadores.domain.Jugador;

import java.util.List;

public interface EntrenamientoRepository {

    public List<Entrenamiento> list();
    public Entrenamiento getEntrenamiento(int id);
    public void add(Entrenamiento entrenamiento);
    public void update(int id, Entrenamiento entrenamiento);
    public void reset();
    public void remove(int id);
}
