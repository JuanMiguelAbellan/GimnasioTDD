package com.Actividad.Gimnasio.entrenamientos.aplication;

import com.Actividad.Gimnasio.ejercicios.domain.Ejercicio;
import com.Actividad.Gimnasio.entrenamientos.domain.Entrenamiento;
import com.Actividad.Gimnasio.entrenamientos.infrastructure.db.EntrenamientoRepositoryPG;
import com.Actividad.Gimnasio.entrenamientos.infrastructure.db.EntrenamientoRespositoryMongo;

import java.util.ArrayList;
import java.util.List;

public class EntrenamientoUsesCases {

    private EntrenamientoRepositoryPG entrenamientoRepositoryPG;
    private EntrenamientoRespositoryMongo entrenamientoRespositoryMongo;

    public EntrenamientoUsesCases(EntrenamientoRepositoryPG entrenamientoRepositoryPG, EntrenamientoRespositoryMongo entrenamientoRespositoryMongo) {
        this.entrenamientoRepositoryPG = entrenamientoRepositoryPG;
        this.entrenamientoRespositoryMongo = entrenamientoRespositoryMongo;
    }

    public List<Entrenamiento> add(Entrenamiento entrenamiento){
        this.entrenamientoRepositoryPG.add(entrenamiento);
        this.entrenamientoRespositoryMongo.add(entrenamiento);
        return list();
    }

    public List<Entrenamiento> list(){
        return unificar(this.entrenamientoRepositoryPG.list(), this.entrenamientoRespositoryMongo.list());
    }

    public List<Entrenamiento> unificar(List<Entrenamiento> entrenamientosPG, List<Entrenamiento> entrenamientosMongo){
        List<Entrenamiento> listaUnificada = new ArrayList<>();
        int maximo = 0;
        if(entrenamientosPG.size() < entrenamientosPG.size()){
            maximo = entrenamientosPG.size();
        }else {
            maximo = entrenamientosMongo.size();
        }

        for(int i = 0 ; i < maximo; i++){
            Entrenamiento entrenamiento = new Entrenamiento();
            Entrenamiento entrenamientoPG = entrenamientosPG.get(i);
            Entrenamiento entrenamientoMongo = entrenamientosMongo.get(i);
            entrenamiento.id_SQL(entrenamientoPG.getId_SQL())
                    .id_Mongo(entrenamientoMongo.getId_Mongo())
                    .fecha(entrenamientoPG.getFecha())
                    .asistentes(entrenamientoMongo.getAsistentes())
                    .ejercicios(entrenamientoMongo.getEjercicios());
            listaUnificada.add(entrenamiento);
        }
        return listaUnificada;
    }
}
