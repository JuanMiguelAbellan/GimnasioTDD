package com.Actividad.Gimnasio.jugadores.aplication;

import com.Actividad.Gimnasio.jugadores.domain.Jugador;
import com.Actividad.Gimnasio.jugadores.domain.JugadorRepository;

import java.util.List;

public class JugadorUsesCases {

    public JugadorRepository jugadorRepository;

    public JugadorUsesCases(JugadorRepository jugadorRepository){
        this.jugadorRepository=jugadorRepository;
    }

    public List<Jugador> list(){
        return this.jugadorRepository.list();
    }
    public Jugador getJugador(int id){
        return this.jugadorRepository.getJugador(id);
    }
    public void add(Jugador jugador){
        this.jugadorRepository.add(jugador);
    }
    public void update(int id, Jugador jugador){
        this.jugadorRepository.update(id, jugador);
    }
    public void reset(){
        this.jugadorRepository.reset();
    };
    public void remove(int id){
        this.jugadorRepository.remove(id);
    }
}
