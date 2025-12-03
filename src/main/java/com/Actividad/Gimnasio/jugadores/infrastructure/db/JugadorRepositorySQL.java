package com.Actividad.Gimnasio.jugadores.infrastructure.db;

import com.Actividad.Gimnasio.context.MySQLDBConnector;
import com.Actividad.Gimnasio.jugadores.domain.Jugador;
import com.Actividad.Gimnasio.jugadores.domain.JugadorRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JugadorRepositorySQL implements JugadorRepository {
    @Override
    public List<Jugador> list() {
        String query = "select * from jugador";
        List<Jugador> jugadores = new ArrayList<>();

        try {
            PreparedStatement statement = MySQLDBConnector.getInstance().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Jugador jugador = new Jugador();
                jugador.setDni(rs.getString("dni"))
                        .setNombre(rs.getString("nombre"))
                        .setApellidos(rs.getString("apelldios"))
                        .setFechaNacimiento(rs.getString("fecha_nacimiento"))
                        .setResistencia(rs.getInt("resistencia"))
                        .setVelocidad(rs.getInt("velocidad"))
                        .setRecuperacion(rs.getInt("recuperacion"));
                jugadores.add(jugador);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return jugadores;
    }

    @Override
    public Jugador getJugador(int id) {
        return null;
    }

    @Override
    public void add(Jugador jugador) {
        String query = "insert into jugador(dni, nombre, apelldios, fecha_nacimiento, resistencia, velocidad, recuperacion) values(?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = MySQLDBConnector.getInstance().prepareStatement(query);
            statement.setString(1, jugador.getDni());
            statement.setString(2, jugador.getNombre());
            statement.setString(3, jugador.getApellidos());
            statement.setString(4, jugador.getFechaNacimiento());
            statement.setInt(5, jugador.getResistencia());
            statement.setInt(6, jugador.getVelocidad());
            statement.setInt(7, jugador.getRecuperacion());
            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(int id, Jugador jugador) {

    }

    @Override
    public void reset() {
        String query = "delete from jugador";


        try {
            PreparedStatement statement = MySQLDBConnector.getInstance().prepareStatement(query);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
