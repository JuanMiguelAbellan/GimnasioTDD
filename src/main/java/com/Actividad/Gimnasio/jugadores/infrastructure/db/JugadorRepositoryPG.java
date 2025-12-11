package com.Actividad.Gimnasio.jugadores.infrastructure.db;

import com.Actividad.Gimnasio.context.PGDBConnector;
import com.Actividad.Gimnasio.jugadores.domain.Jugador;
import com.Actividad.Gimnasio.jugadores.domain.JugadorRepository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JugadorRepositoryPG implements JugadorRepository {
    @Override
    public List<Jugador> list() {
        String query = "select * from jugador";
        List<Jugador> jugadores = new ArrayList<>();

        try {
            PreparedStatement statement = PGDBConnector.getInstance().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Jugador jugador = new Jugador();
                jugador.dni(rs.getString("dni"))
                        .nombre(rs.getString("nombre"))
                        .apellidos(rs.getString("apellidos"))
                        .fechaNacimiento(rs.getString("fecha_nacimiento"))
                        .resistencia(rs.getInt("resistencia"))
                        .velocidad(rs.getInt("velocidad"))
                        .recuperacion(rs.getInt("recuperacion"));
                jugadores.add(jugador);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return jugadores;
    }

    @Override
    public Jugador getJugador(int id) {
        Jugador jugador = new Jugador();
        String query = "select * from jugador where id = ?";

        try {
            PreparedStatement statement = PGDBConnector.getInstance().prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                jugador.dni(rs.getString("dni"))
                        .nombre(rs.getString("nombre"))
                        .apellidos(rs.getString("apellidos"))
                        .fechaNacimiento(rs.getString("fecha_nacimiento"))
                        .resistencia(rs.getInt("resistencia"))
                        .velocidad(rs.getInt("velocidad"))
                        .recuperacion(rs.getInt("recuperacion"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return jugador;
    }

    @Override
    public void add(Jugador jugador) {
        String query = "insert into jugador(dni, nombre, apellidos, fecha_nacimiento, resistencia, velocidad, recuperacion) values(?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = PGDBConnector.getInstance().prepareStatement(query);
            statement.setString(1, jugador.getDni());
            statement.setString(2, jugador.getNombre());
            statement.setString(3, jugador.getApellidos());
            statement.setDate(4, (Date) Date.valueOf(jugador.getFechaNacimiento()));
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
        StringBuilder query = new StringBuilder("update jugador set id = " + id);
        List<Object> params = new ArrayList<>();
        if (jugador.getDni() !=null && !jugador.getDni().isEmpty()){
            query.append(", dni = ?");
            params.add(jugador.getDni());
        }
        if (jugador.getNombre() !=null && !jugador.getNombre().isEmpty()){
            query.append(", nombre = ?");
            params.add(jugador.getNombre());
        }
        if (jugador.getApellidos() !=null && !jugador.getApellidos().isEmpty()){
            query.append(", apellidos = ?");
            params.add(jugador.getApellidos());
        }
        if (jugador.getFechaNacimiento() !=null && !jugador.getFechaNacimiento().isEmpty()){
            query.append(", fecha_nacimiento = ?");
            params.add(jugador.getFechaNacimiento());
        }
        if ((Integer)jugador.getRecuperacion() !=null){
            query.append(", recuperacion = ?");
            params.add(jugador.getRecuperacion());
        }
        if ((Integer)jugador.getResistencia() !=null){
            query.append(", resistencia = ?");
            params.add(jugador.getResistencia());
        }
        if ((Integer)jugador.getVelocidad() !=null){
            query.append(", velocidad = ?");
            params.add(jugador.getVelocidad());
        }

        try{
            query.append(" where id = " + id);
            PreparedStatement statement = PGDBConnector.getInstance().prepareStatement(query.toString());
            for(int i =0; i < params.size();i++){
                statement.setObject(i+1, params.get(i));
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void reset() {
        String query = "delete from jugador";

        try {
            PreparedStatement statement = PGDBConnector.getInstance().prepareStatement(query);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void remove(int id) {
        String query = "delete from jugador where id = ?";

        try {
            PreparedStatement statement = PGDBConnector.getInstance().prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
