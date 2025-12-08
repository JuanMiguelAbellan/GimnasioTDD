package com.Actividad.Gimnasio.jugadores.domain;

import java.util.List;

public interface JugadorRepository {

    public List<Jugador> list();
    public Jugador getJugador(int id);
    public void add(Jugador jugador);
    public void update(int id, Jugador jugador);
    public void reset();
    public void remove(int id);
}
