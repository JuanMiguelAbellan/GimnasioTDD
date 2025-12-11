package com.Actividad.Gimnasio.ejercicios.infrastructure.db;

import com.Actividad.Gimnasio.context.PGDBConnector;
import com.Actividad.Gimnasio.ejercicios.domain.Ejercicio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EjercicioRepositoryPG implements com.Actividad.Gimnasio.ejercicios.domain.EjercicioRepositoryPG {
    @Override
    public List<Ejercicio> list() {
        List<Ejercicio> ejercicios = new ArrayList<>();
        String query = "select * from ejercicio";

        try {
            PreparedStatement statement = PGDBConnector.getInstance().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Ejercicio ejercicio= new Ejercicio();
                ejercicio.idSql(rs.getInt("id"))
                        .titulo(rs.getString("titulo"))
                        .descripcion(rs.getString("descripcion"))
                        .duracion(rs.getDouble("duracion"));
                ejercicios.add(ejercicio);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ejercicios;
    }

    @Override
    public Ejercicio getEjercicio(int id) {
        return null;
    }

    @Override
    public void add(Ejercicio ejercicio) {
        String query = "insert into ejercicio(titulo, descripcion, duracion) values(?, ?, ?)";

        try {
            PreparedStatement statement = PGDBConnector.getInstance().prepareStatement(query);
            statement.setString(1, ejercicio.getTitulo());
            statement.setString(2, ejercicio.getDescripcion());
            statement.setObject(3, ejercicio.getDuracion());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(int id, Ejercicio ejercicio) {

    }

    @Override
    public void reset() {

    }

    @Override
    public void remove(int id) {

    }
}
