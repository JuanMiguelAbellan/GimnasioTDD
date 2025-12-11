package com.Actividad.Gimnasio.jugadores.infrastructure.rest;

import com.Actividad.Gimnasio.jugadores.aplication.JugadorUsesCases;
import com.Actividad.Gimnasio.jugadores.domain.Jugador;
import com.Actividad.Gimnasio.jugadores.infrastructure.db.JugadorRepositoryPG;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JugadorRestController {

    private JugadorUsesCases jugadorUsesCases;

    public JugadorRestController(){
        this.jugadorUsesCases= new JugadorUsesCases(new JugadorRepositoryPG());
    }

    @GetMapping("/api/jugadores")
    public List<Jugador> list(){
        return this.jugadorUsesCases.list();
    }

    @GetMapping("/api/jugadores/{id}")
    public Jugador get(@PathVariable int id){
        return this.jugadorUsesCases.getJugador(id);
    }

    @PostMapping("/api/jugadores")
    public List<Jugador> save(@RequestBody Jugador jugador){
        this.jugadorUsesCases.add(jugador);
        return this.jugadorUsesCases.list();
    }

    @PutMapping("/api/jugadores/{id}")
    public Jugador update(@PathVariable int id,
                          @RequestBody Jugador jugador){
        this.jugadorUsesCases.update(id, jugador);
        return this.jugadorUsesCases.getJugador(id);
    }

    @DeleteMapping("/api/jugadores/{id}")
    public List<Jugador> delete(@PathVariable int id) {
        this.jugadorUsesCases.remove(id);
        return this.jugadorUsesCases.list();
    }
}
