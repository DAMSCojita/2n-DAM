package com.example.appmultiusos_10_11;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class StorageSQLite extends SQLiteOpenHelper implements DataStorage {

    private static final String DATABASE_NAME = "contactos.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "contactos";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NOMBRE = "nombre";
    private static final String COLUMN_TELEFONO = "telefono";
    private static final String COLUMN_POBLACION = "poblacion";

    public StorageSQLite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NOMBRE + " TEXT, "
                + COLUMN_TELEFONO + " TEXT, "
                + COLUMN_POBLACION + " TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void storeData(Contacto contacto) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOMBRE, contacto.getNombre());
        values.put(COLUMN_TELEFONO, contacto.getTelefono());
        values.put(COLUMN_POBLACION, contacto.getPoblacion());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public List<Contacto> getDataList(int maxNo) {
        List<Contacto> contactos = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " LIMIT ?", new String[]{String.valueOf(maxNo)});

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID));
                String nombre = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NOMBRE));
                String telefono = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TELEFONO));
                String poblacion = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_POBLACION));
                contactos.add(new Contacto(id, nombre, telefono, poblacion));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return contactos;
    }

    @Override
    public void deleteData(String telefono) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_TELEFONO + " = ?", new String[]{telefono});
        db.close();
    }
}
