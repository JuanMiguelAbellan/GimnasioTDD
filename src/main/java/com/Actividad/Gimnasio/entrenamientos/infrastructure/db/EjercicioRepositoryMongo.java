package com.Actividad.Gimnasio.entrenamientos.infrastructure.db;

import com.Actividad.Gimnasio.entrenamientos.domain.Ejercicio;
import com.Actividad.Gimnasio.entrenamientos.domain.EjercicioRepository;

import java.util.List;

public class EjercicioRepositoryMongo implements EjercicioRepository {

    @Override
    public List<Ejercicio> list() {
        return List.of();
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
