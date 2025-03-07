package org.example.examenud10i112023;

public class Contacte {

    // Declaració de atributs.
    private int id;
    private final String nom;
    private final String telefon;
    private final String poblacio;

    // Declaració de constructor.
    public Contacte(String nombre, String telefono, String poblacion) {
        this.nom = nombre;
        this.telefon = telefono;
        this.poblacio = poblacion;
    }

    // Declaració de un altre constructor que emprem quan accedim a la base de dades.
    public Contacte(int id, String nombre, String telefono, String poblacion) {
        this.id = id;
        this.nom = nombre;
        this.telefon = telefono;
        this.poblacio = poblacion;
    }

    // Getters i setters.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getPoblacio() {
        return poblacio;
    }

    @Override
    public String toString() {
        return nom + " - " + telefon + " - " + poblacio;
    }

}
