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
        jugador.dni("11111111H")
                .nombre("Pedrito")
                .apellidos("Sanchez H")
                .fechaNacimiento("2000-10-31")
                .resistencia(1)
                .velocidad(2)
                .recuperacion(3);
        this.jugadorUsesCases.add(jugador);
        List<Jugador> list = this.jugadorUsesCases.list();
        assertEquals(1, list.size());
    }

    @AfterEach
    void reset(){
        jugadorUsesCases.reset();
    }
}
