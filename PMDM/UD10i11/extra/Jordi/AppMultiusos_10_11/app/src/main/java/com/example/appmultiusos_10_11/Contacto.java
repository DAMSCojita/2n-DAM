package com.example.appmultiusos_10_11;

import java.util.Random;

public class Contacto {
    private int id;
    private String nombre;
    private String telefono;
    private String poblacion;

    // Constructor usado cuando creamos un nuevo contacto (sin ID, SQLite lo genera)
    public Contacto(String nombre, String telefono, String poblacion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.poblacion = poblacion;
    }

    // Constructor usado cuando recuperamos un contacto desde la base de datos
    public Contacto(int id, String nombre, String telefono, String poblacion) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.poblacion = poblacion;
    }

    // Métodos getter y setter (opcional)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getPoblacion() {
        return poblacion;
    }
    @Override
    public String toString() {
        return nombre + " - " + telefono + " - " + poblacion;
    }

}
