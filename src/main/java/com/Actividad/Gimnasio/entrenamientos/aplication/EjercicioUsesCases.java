package com.Actividad.Gimnasio.entrenamientos.aplication;

import com.Actividad.Gimnasio.entrenamientos.domain.Ejercicio;
import com.Actividad.Gimnasio.entrenamientos.infrastructure.db.EjercicioRepositoryMongo;
import com.Actividad.Gimnasio.entrenamientos.infrastructure.db.EjercicioRepositorySQL;

import java.util.List;

public class EjercicioUsesCases {

    private EjercicioRepositoryMongo entrenamientoRepositoryMongo;
    private EjercicioRepositorySQL entrenamientoRepositorySQL;

    public EjercicioUsesCases(EjercicioRepositorySQL entrenamientoRepositorySQL, EjercicioRepositoryMongo entrenamientoRepositoryMongo){
        this.entrenamientoRepositoryMongo=entrenamientoRepositoryMongo;
        this.entrenamientoRepositorySQL=entrenamientoRepositorySQL;
    }
    public List<Ejercicio> list(){

    }
}
