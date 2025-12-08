package com.Actividad.Gimnasio.entrenamientos.domain;

import java.util.List;

public interface EjercicioRepository {

    public List<Ejercicio> list();
    public Ejercicio getEntrenamiento(int id);
    public void add(Ejercicio ejercicio);
    public void update(int id, Ejercicio ejercicio);
    public void reset();
    public void remove(int id);
}
