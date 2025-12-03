package com.Actividad.Gimnasio;

import com.Actividad.Gimnasio.jugadores.aplication.JugadorUsesCases;
import com.Actividad.Gimnasio.jugadores.domain.Jugador;
import com.Actividad.Gimnasio.jugadores.infrastructure.db.JugadorRepositorySQL;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

@SpringBootTest
public class JugadorUsesCasesTest {

    private JugadorUsesCases jugadorUsesCases;

    public JugadorUsesCasesTest(){
        this.jugadorUsesCases = new JugadorUsesCases(new JugadorRepositorySQL());
    }

    @Test
    void saveAndList(){
        Jugador jugador = new Jugador();
        jugador.setDni("11111111H")
                .setNombre("Pedrito")
                .setApellidos("Sanchez H")
                .setFechaNacimiento("2000-10-31")
                .setResistencia(1)
                .setVelocidad(2)
                .setRecuperacion(3);
        this.jugadorUsesCases.add(jugador);
        List<Jugador> list = this.jugadorUsesCases.list();
        assertEquals(1, list.size());
    }

    @AfterEach
    void reset(){
        jugadorUsesCases.reset();
    }
}
