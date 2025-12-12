package com.Actividad.Gimnasio.ejercicios.aplication;

import com.Actividad.Gimnasio.ejercicios.domain.Ejercicio;
import com.Actividad.Gimnasio.ejercicios.infrastructure.db.EjercicioRepositoryMongo;
import com.Actividad.Gimnasio.ejercicios.infrastructure.db.EjercicioRepositoryPG;

import java.util.ArrayList;
import java.util.List;

public class EjercicioUsesCases {

    private EjercicioRepositoryMongo ejercicioRepositoryMongo;
    private EjercicioRepositoryPG ejercicioRepositoryPG;

    public EjercicioUsesCases(EjercicioRepositoryPG ejercicioRepositoryPG, EjercicioRepositoryMongo ejercicioRepositoryMongo){
        this.ejercicioRepositoryPG=ejercicioRepositoryPG;
        this.ejercicioRepositoryMongo=ejercicioRepositoryMongo;
    }

    public List<Ejercicio> add(Ejercicio ejercicio){
        this.ejercicioRepositoryPG.add(ejercicio);
        this.ejercicioRepositoryMongo.add(ejercicio);
        return list();
    }

    public List<Ejercicio> list(){
        return unificar(this.ejercicioRepositoryPG.list(), this.ejercicioRepositoryMongo.list());
    }

    public List<Ejercicio> unificar(List<Ejercicio> ejerciciosSQL, List<Ejercicio> ejerciciosMongo){
        List<Ejercicio> listaUnificada = new ArrayList<>();
        int maximo = 0;
        if(ejerciciosSQL.size() < ejerciciosMongo.size()){
            maximo = ejerciciosSQL.size();
        }else {
            maximo = ejerciciosMongo.size();
        }

        for(int i = 0 ; i < maximo; i++){
            Ejercicio ejercicio = new Ejercicio();
            Ejercicio ejercicioSQL = ejerciciosSQL.get(i);
            Ejercicio ejercicioMongo = ejerciciosMongo.get(i);
            ejercicio.idSql(ejercicioSQL.getIdSQL())
                    .id_Mongo(ejercicioMongo.getIdMongo())
                    .titulo(ejercicioSQL.getTitulo())
                    .descripcion(ejercicioSQL.getDescripcion())
                    .duracion(ejercicioSQL.getDuracion())
                    .etiquetas(ejercicioMongo.getEtiquetas())
                    .dureza(ejercicioMongo.getDureza())
                    .materiales(ejercicioMongo.getMateriales())
                    .multimedia(ejercicioMongo.getMultimedia());
            listaUnificada.add(ejercicio);
        }
        return listaUnificada;
    }
}
