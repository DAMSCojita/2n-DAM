package org.example.examenud10i112023;

import java.util.List;

public interface ContacteStorage {
    // Métodes que implementarà la classe que guardi les dades.
    void guardarDades(Contacte contacto);
    List<Contacte> obtenirDades(int maxNo);
}
