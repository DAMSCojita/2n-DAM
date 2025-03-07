package org.example.examenud10i112023;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class StorageSQLite extends SQLiteOpenHelper implements ContacteStorage {

    private static final String DATABASE_NAME = "contactes.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "contactos";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NOM = "nom";
    private static final String COLUMN_TELEFON = "telefon";
    private static final String COLUMN_POBLACIO = "poblacio";

    public StorageSQLite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NOM + " TEXT, "
                + COLUMN_TELEFON + " TEXT, "
                + COLUMN_POBLACIO + " TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void guardarDades(Contacte contacto) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOM, contacto.getNom());
        values.put(COLUMN_TELEFON, contacto.getTelefon());
        values.put(COLUMN_POBLACIO, contacto.getPoblacio());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public List<Contacte> obtenirDades(int maxNo) {
        List<Contacte> contactes = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " LIMIT ?", new String[]{String.valueOf(maxNo)});

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID));
                String nom = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NOM));
                String telefon = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TELEFON));
                String poblacio = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_POBLACIO));
                contactes.add(new Contacte(id, nom, telefon, poblacio));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return contactes;
    }
}
