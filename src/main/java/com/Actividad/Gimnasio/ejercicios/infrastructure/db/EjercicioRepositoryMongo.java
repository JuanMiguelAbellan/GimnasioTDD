package com.Actividad.Gimnasio.ejercicios.infrastructure.db;

import com.Actividad.Gimnasio.context.MongoDBConnector;
import com.Actividad.Gimnasio.ejercicios.domain.Ejercicio;
import com.Actividad.Gimnasio.ejercicios.domain.entitites.Dureza;
import com.Actividad.Gimnasio.ejercicios.domain.entitites.Material;
import com.Actividad.Gimnasio.ejercicios.domain.entitites.Multimedia;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import javax.print.Doc;
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
            ejercicio.idSql(document.getInteger("idSQL"));

            List<String> etiquetasDoc = document.getList("etiquetas", String.class);
            if (etiquetasDoc != null) {
                ejercicio.etiquetas(etiquetasDoc);
            }

            Document durezasDoc = (Document) document.get("dureza", Document.class);
            Dureza dureza = new Dureza();
            dureza.setVelocidad(durezasDoc.getInteger("velocidad"));
            dureza.setResistencia(durezasDoc.getInteger("resistencia"));
            dureza.setRecuperacion(durezasDoc.getInteger("recuperacion"));

            ejercicio.dureza(dureza);

            List<Document> materialesDoc = document.getList("materiales", Document.class);
            List<Material> materiales = new ArrayList<>();
            if(materialesDoc != null){
                for(Document materialDoc : materialesDoc){
                    Material material = new Material();
                    material.setTipo(materialDoc.getString("tipo")).setCantidad((Integer) materialDoc.getInteger("cantidad"));
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
        document.append("id_sql", ejercicio.getIdSQL());
        document.append("titulo", ejercicio.getTitulo());
        document.append("etiquetas", ejercicio.getEtiquetas());
        Document dureza = new Document();
        dureza.append("resistencia", ejercicio.getDureza().getResistencia());
        dureza.append("velocidad", ejercicio.getDureza().getVelocidad());
        dureza.append("recuperacion", ejercicio.getDureza().getRecuperacion());
        document.append("dureza", dureza);
        List<Document> listaMateriales = new ArrayList<>();
        for(Material material : ejercicio.getMateriales()){
            Document materialDoc = new Document();
            materialDoc.append("tipo", material.getTipo());
            materialDoc.append("cantidad", material.getCantidad());
            listaMateriales.add(materialDoc);
        }
        document.append("materiales", listaMateriales);
        List<Document> listMultimedia = new ArrayList<>();
        for(Multimedia multimedia : ejercicio.getMultimedia()){
            Document multimediaDoc = new Document();
            multimediaDoc.append("tipo", multimedia.getTipo());
            multimediaDoc.append("url", multimedia.getUrl());
            listaMateriales.add(multimediaDoc);
        }
        document.append("multimedia", listMultimedia);
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
