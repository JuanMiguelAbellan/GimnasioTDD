package com.Actividad.Gimnasio.ejercicios.infrastructure.rest;

import com.Actividad.Gimnasio.ejercicios.aplication.EjercicioUsesCases;
import com.Actividad.Gimnasio.ejercicios.domain.Ejercicio;
import com.Actividad.Gimnasio.ejercicios.infrastructure.db.EjercicioRepositoryMongo;
import com.Actividad.Gimnasio.ejercicios.infrastructure.db.EjercicioRepositoryPG;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EjercicioResController {

    private EjercicioUsesCases ejercicioUsesCases;

    public EjercicioResController() {
        this.ejercicioUsesCases = new EjercicioUsesCases(new EjercicioRepositoryPG(), new EjercicioRepositoryMongo());
    }

    @GetMapping("/api/ejercicios")
    public List<Ejercicio> list(){
        return this.ejercicioUsesCases.list();
    }

    @PostMapping("/api/ejercicios")
    public Ejercicio add(@RequestBody Ejercicio ejercicio){
        this.ejercicioUsesCases.add(ejercicio);
        return ejercicio;
    }
}
