package org.example.examenud10i112023;

import java.util.ArrayList;
import java.util.List;

public class StorageList implements ContacteStorage {

    private List<Contacte> data;

    public StorageList() {
        data = new ArrayList<>();
        data.add(new Contacte("Stefan Cojita", "619409459", "Es Castell"));
        data.add(new Contacte("Rigoberto Carrillo", "646693008", "Alaior"));
        data.add(new Contacte("Carmen Sol", "619409458", "Ferreries"));
    }

    @Override
    public void guardarDades(Contacte contacto) {
        data.add(0, contacto);
    }

    @Override
    public List<Contacte> obtenirDades(int maxNo) {
        return data.subList(0, Math.min(maxNo, data.size()));
    }
}
