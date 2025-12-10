package com.Actividad.Gimnasio.ejercicios.domain;

import java.util.List;

public interface EjercicioRepositoryMongo {

    public List<Ejercicio> list();
    public Ejercicio getEjercicio(int id);
    public void add(Ejercicio ejercicio);
    public void update(int id, Ejercicio ejercicio);
    public void reset();
    public void remove(int id);
}
