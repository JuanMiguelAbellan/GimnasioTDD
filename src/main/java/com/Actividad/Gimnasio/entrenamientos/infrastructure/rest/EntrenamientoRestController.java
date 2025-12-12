package com.Actividad.Gimnasio.entrenamientos.infrastructure.rest;

import com.Actividad.Gimnasio.entrenamientos.aplication.EntrenamientoUsesCases;
import com.Actividad.Gimnasio.entrenamientos.domain.Entrenamiento;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntrenamientoRestController {

    private EntrenamientoUsesCases entrenamientoUsesCases;

    public EntrenamientoRestController(EntrenamientoUsesCases entrenamientoUsesCases) {
        this.entrenamientoUsesCases = entrenamientoUsesCases;
    }

    @GetMapping("/api/entrenamientos")
    public List<Entrenamiento> list(){
        return this.entrenamientoUsesCases.list();
    }

    @PostMapping("/api/entrenamientos")
    public List<Entrenamiento> add(@RequestBody Entrenamiento entrenamiento){
        //Insertar sin asistentes
        return list();
    }
}
