package com.example.appmultiusos_10_11;

import java.util.ArrayList;
import java.util.List;

public class StorageList implements DataStorage {

    private List<Contacto> data;

    public StorageList() {
        // Inicializamos la lista
        data = new ArrayList<>();
        // Añadimos algunos contactos de ejemplo
        data.add(new Contacto("Juan Sánchez", "123000", "Madrid"));
        data.add(new Contacto("Pedro Martínez", "111000", "Barcelona"));
        data.add(new Contacto("Paco Pérez", "011000", "Valencia"));
    }

    @Override
    public void storeData(Contacto contacto) {
        // Añadimos el nuevo contacto al principio de la lista
        data.add(0, contacto);
    }

    @Override
    public List<Contacto> getDataList(int maxNo) {
        // Retorna hasta `maxNo` contactos (si hay menos de `maxNo` contactos, devuelve todos)
        return data.subList(0, Math.min(maxNo, data.size()));
    }

    @Override
    public void deleteData(String telefono) {
        // Elimina el contacto que tenga el número de teléfono proporcionado
        data.removeIf(contacto -> contacto.getTelefono().equals(telefono));
    }
}
