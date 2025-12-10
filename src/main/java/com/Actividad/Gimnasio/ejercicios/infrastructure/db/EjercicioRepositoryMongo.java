package com.Actividad.Gimnasio.ejercicios.infrastructure.db;

import com.Actividad.Gimnasio.context.MongoDBConnector;
import com.Actividad.Gimnasio.ejercicios.domain.Ejercicio;
import com.Actividad.Gimnasio.ejercicios.domain.entitites.Dureza;
import com.Actividad.Gimnasio.ejercicios.domain.entitites.Material;
import com.Actividad.Gimnasio.ejercicios.domain.entitites.Multimedia;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class EjercicioRepositoryMongo implements com.Actividad.Gimnasio.ejercicios.domain.EjercicioRepositoryMongo {

    @Override
    public List<Ejercicio> list() {
        MongoCollection<Document> collection = MongoDBConnector.getDatabase().getCollection("ejercicios");
        List<Ejercicio> ejercicios = new ArrayList<>();
        FindIterable<Document> iterable = collection.find();
        for (Document document: iterable){
            Ejercicio ejercicio = new Ejercicio();
            ejercicio.idMongo(document.getObjectId("_id").toString());

            List<Document> etiquetasDoc = document.getList("etiquetas", Document.class);
            List<String> etiquetas = new ArrayList<>();
            if (etiquetasDoc != null) {
                for(Document etiquetaDoc : etiquetasDoc){
                    etiquetas.add(etiquetaDoc.toString());
                }
                ejercicio.etiquetas(etiquetas);
            }

            List<Document> durezasDoc = document.getList("dureza", Document.class);
            List<Dureza> durezas = new ArrayList<>();
            if(durezasDoc != null){
                for(Document durezaDoc : durezasDoc){
                    Dureza dureza = new Dureza(durezaDoc.getInteger("resistencia"), durezaDoc.getInteger("velocidad"), durezaDoc.getInteger("recuperacion"));
                    durezas.add(dureza);
                }
                ejercicio.dureza(durezas);
            }

            List<Document> materialesDoc = document.getList("materiales", Document.class);
            List<Material> materiales = new ArrayList<>();
            if(materialesDoc != null){
                for(Document materialDoc : materialesDoc){
                    Material material = new Material(materialDoc.getString("tipo"), materialDoc.getInteger("cantidad"));
                    materiales.add(material);
                }
                ejercicio.materiales(materiales);
            }

            List<Document> multimediasDoc = document.getList("multimedia", Document.class);
            List<Multimedia> multimedias = new ArrayList<>();
            if(multimediasDoc != null){
                for(Document multimediaDoc : multimediasDoc){
                    Multimedia multimedia = new Multimedia(multimediaDoc.getString("tipo"), multimediaDoc.getString("url"));
                    multimedias.add(multimedia);
                }
                ejercicio.multimedia(multimedias);
            }

            ejercicios.add(ejercicio);
        }
        return ejercicios;
    }

    @Override
    public Ejercicio getEjercicio(int id) {
        return null;
    }

    @Override
    public void add(Ejercicio ejercicio) {
        Document document = new Document();
        document.append("titulo", ejercicio.getTitulo());
        MongoDBConnector.getDatabase().getCollection("ejercicios").insertOne(document);
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
