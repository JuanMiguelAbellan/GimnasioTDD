package com.Actividad.Gimnasio.entrenamientos.infrastructure.db;

import com.Actividad.Gimnasio.context.PGDBConnector;
import com.Actividad.Gimnasio.entrenamientos.domain.Entrenamiento;
import com.Actividad.Gimnasio.entrenamientos.domain.EntrenamientoRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntrenamientoRepositoryPG implements EntrenamientoRepository {
    @Override
    public List<Entrenamiento> list() {
        List<Entrenamiento> entrenamientos = new ArrayList<>();
        String query = "select * from entrenamiento";

        try {
            PreparedStatement statement = PGDBConnector.getInstance().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Entrenamiento entrenamiento = new Entrenamiento();
                entrenamiento.id_SQL(rs.getInt("id")).fecha(rs.getString("fecha"));
                entrenamientos.add(entrenamiento);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return entrenamientos;
    }

    @Override
    public Entrenamiento getEntrenamiento(int id) {
        return null;
    }

    @Override
    public void add(Entrenamiento entrenamiento) {
        String query = "insert into entrenamiento(fecha) values(?)";

        try {
            PreparedStatement statement = PGDBConnector.getInstance().prepareStatement(query);
            statement.setString(1, entrenamiento.getFecha());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(int id, Entrenamiento entrenamiento) {

    }

    @Override
    public void reset() {

    }

    @Override
    public void remove(int id) {

    }
}
