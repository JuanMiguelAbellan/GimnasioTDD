package com.Actividad.Gimnasio.jugadores.domain;

public class Jugador {
    private String dni;
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
    private int resistencia;
    private int velocidad;
    private int recuperacion;

    public Jugador() {
    }

    public int validarCondicion(int valor){
        if(valor > 0 && valor < 4){
            return valor;
        }else {
            return 2;
        }
    }

    public Jugador setResistencia(int resistencia){
        this.resistencia=validarCondicion(resistencia);
        return this;
    }

    public Jugador setVelocidad(int velocidad) {
        this.velocidad = validarCondicion(resistencia);
        return this;
    }

    public Jugador setRecuperacion(int recuperacion) {
        this.recuperacion =validarCondicion(recuperacion);
        return this;
    }

    public Jugador setDni(String dni) {
        this.dni = dni;
        return this;
    }

    public Jugador setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Jugador setApellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    public Jugador setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getResistencia() {
        return resistencia;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getRecuperacion() {
        return recuperacion;
    }
}
