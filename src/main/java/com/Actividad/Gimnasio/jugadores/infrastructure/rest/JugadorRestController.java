package com.Actividad.Gimnasio.jugadores.infrastructure.rest;

import com.Actividad.Gimnasio.jugadores.aplication.JugadorUsesCases;
import com.Actividad.Gimnasio.jugadores.domain.Jugador;
import com.Actividad.Gimnasio.jugadores.infrastructure.db.JugadorRepositorySQL;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JugadorRestController {

    private JugadorUsesCases jugadorUsesCases;

    public JugadorRestController(){
        this.jugadorUsesCases= new JugadorUsesCases(new JugadorRepositorySQL());
    }

    @GetMapping("/api/jugadores")
    public List<Jugador> list(){
        return this.jugadorUsesCases.list();
    }

    @PostMapping("/api/jugadores")
    public List<Jugador> save(Jugador jugador){
        this.jugadorUsesCases.add(jugador);
        return this.jugadorUsesCases.list();
    }
}
