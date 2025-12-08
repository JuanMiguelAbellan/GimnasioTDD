package com.Actividad.Gimnasio.entrenamientos.infrastructure.db;

import com.Actividad.Gimnasio.context.MySQLDBConnector;
import com.Actividad.Gimnasio.entrenamientos.domain.Ejercicio;
import com.Actividad.Gimnasio.entrenamientos.domain.EjercicioRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EjercicioRepositorySQL implements EjercicioRepository {
    @Override
    public List<Ejercicio> list() {
        List<Ejercicio> ejercicios = new ArrayList<>();
        String query = "select * from ejercicio";

        try {
            PreparedStatement statement = MySQLDBConnector.getInstance().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Ejercicio ejercicio= new Ejercicio();
                ejercicio.id(rs.getInt("id"))
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
    public Ejercicio getEntrenamiento(int id) {
        return null;
    }

    @Override
    public void add(Ejercicio ejercicio) {

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
