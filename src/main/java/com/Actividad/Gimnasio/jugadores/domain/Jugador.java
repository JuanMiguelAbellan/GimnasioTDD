package com.Actividad.Gimnasio.jugadores.domain;

public class Jugador {
    public String dni;
    public String nombre;
    private String apellidos;
    private String fechaNacimiento;
    private int resistencia;
    private int velocidad;
    private int recuperacion;

    public Jugador() {
    }

    public Jugador(String dni, String nombre, String apellidos, int resistencia, String fechaNacimiento, int velocidad, int recuperacion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.resistencia = resistencia;
        this.fechaNacimiento = fechaNacimiento;
        this.velocidad = velocidad;
        this.recuperacion = recuperacion;
    }

    public int validarCondicion(int valor){
        if(valor > 0 && valor < 4){
            return valor;
        }else {
            return 2;
        }
    }

    public Jugador resistencia(int resistencia){
        this.resistencia=validarCondicion(resistencia);
        return this;
    }

    public Jugador velocidad(int velocidad) {
        this.velocidad = validarCondicion(resistencia);
        return this;
    }

    public Jugador recuperacion(int recuperacion) {
        this.recuperacion =validarCondicion(recuperacion);
        return this;
    }

    public Jugador dni(String dni) {
        this.dni = dni;
        return this;
    }

    public Jugador nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Jugador apellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    public Jugador fechaNacimiento(String fechaNacimiento) {
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
