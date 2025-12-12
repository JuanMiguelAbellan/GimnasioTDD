package com.Actividad.Gimnasio.entrenamientos.infrastructure.db;

import com.Actividad.Gimnasio.context.MongoDBConnector;
import com.Actividad.Gimnasio.ejercicios.domain.Ejercicio;
import com.Actividad.Gimnasio.entrenamientos.domain.Entrenamiento;
import com.Actividad.Gimnasio.entrenamientos.domain.EntrenamientoRepository;
import com.Actividad.Gimnasio.jugadores.domain.Jugador;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

public class EntrenamientoRespositoryMongo implements EntrenamientoRepository {
    @Override
    public List<Entrenamiento> list() {
        List<Entrenamiento> entrenamientos = new ArrayList<>();
        MongoCollection<Document> collection = MongoDBConnector.getDatabase().getCollection("entrenamientos");
        FindIterable<Document> iterable = collection.find();

        for(Document document: iterable){
            Entrenamiento entrenamiento = new Entrenamiento();
            entrenamiento.id_Mongo(document.getObjectId("_id").toString());
            List<Document> asistentesDoc = document.getList("asistentes", Document.class);
            List<Jugador> aistentes = new ArrayList<>();
            if (asistentesDoc != null){
                for (Document jugadorDoc : asistentesDoc){
                    Jugador jugador = new Jugador();
                    jugador.dni(jugadorDoc.getString("dni"))
                            .nombre(jugadorDoc.getString("nombre"));
                    aistentes.add(jugador);
                }
                entrenamiento.asistentes(aistentes);
            }
            List<Document> ejerciciosDoc = document.getList("ejercicios", Document.class);
            List<Ejercicio> ejercicios = new ArrayList<>();
            if (ejerciciosDoc != null){
                for (Document ejercicioDoc : ejerciciosDoc){
                    Ejercicio ejercicio = new Ejercicio();
                    ejercicio.id_Mongo(ejercicioDoc.getString("idMongo"))
                            .titulo(ejercicioDoc.getString("titulo"));
                    ejercicios.add(ejercicio);
                }
                entrenamiento.ejercicios(ejercicios);
            }
            entrenamientos.add(entrenamiento);
        }
        return entrenamientos;
    }

    @Override
    public Entrenamiento getEntrenamiento(int id) {
        return null;
    }

    @Override
    public void add(Entrenamiento entrenamiento) {
        Document document = new Document();
        document.append("id_SQL", entrenamiento.getId_SQL());
        document.append("fecha", entrenamiento.getFecha());
        List<Document> asistentes = new ArrayList<>();
        for(Jugador asistente: entrenamiento.getAsistentes()){
            Document asistenteDoc = new Document();
            asistenteDoc.append("dni", asistente.getDni());
            asistenteDoc.append("nombre", asistente.getNombre());
            asistentes.add(asistenteDoc);
        }
        document.append("asistentes", asistentes);

        List<Document> ejercicios = new ArrayList<>();
        for (Ejercicio ejercicio: entrenamiento.getEjercicios()){
            Document ejercicioDoc = new Document();
            ejercicioDoc.append("idMongo", ejercicio.getIdMongo());
            ejercicioDoc.append("titulo", ejercicio.getTitulo());
            ejercicios.add(ejercicioDoc);
        }
        document.append("ejercicios", ejercicios);

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
