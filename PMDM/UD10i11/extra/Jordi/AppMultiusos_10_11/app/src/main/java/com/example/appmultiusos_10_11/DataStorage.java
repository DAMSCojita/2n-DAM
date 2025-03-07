package com.example.appmultiusos_10_11;

import java.util.List;



import java.util.List;

public interface DataStorage {
    void storeData(Contacto contacto);
    List<Contacto> getDataList(int maxNo);
    void deleteData(String telefono); // Opcional, para eliminar contactos por teléfono
}

