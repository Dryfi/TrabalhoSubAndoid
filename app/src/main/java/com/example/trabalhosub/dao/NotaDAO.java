package com.example.trabalhosub.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.trabalhosub.helper.DatabaseHelper;
import com.example.trabalhosub.model.Nota;

import java.util.ArrayList;
import java.util.List;

public class NotaDAO {

    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public NotaDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public boolean inserirNota(int alunoId, int disciplinaId, double nota, int bimestre) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("alunoId", alunoId);
        values.put("disciplinaId", disciplinaId);
        values.put("nota", nota);
        values.put("bimestre", bimestre);

        long resultado = db.insert("Nota", null, values);
        db.close();
        return resultado != -1;
    }
    public List<Nota> getNotasPorAluno(int alunoId) {
        List<Nota> listaNotas = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Nota WHERE alunoId = ?", new String[]{String.valueOf(alunoId)});

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                int disciplinaId = cursor.getInt(cursor.getColumnIndexOrThrow("disciplinaId"));
                double nota = cursor.getDouble(cursor.getColumnIndexOrThrow("nota"));
                int bimestre = cursor.getInt(cursor.getColumnIndexOrThrow("bimestre"));
                listaNotas.add(new Nota(id, alunoId, disciplinaId, nota, bimestre));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return listaNotas;
    }

    public boolean deletarNota(int notaId) {
        db = dbHelper.getWritableDatabase();
        int resultado = db.delete("Nota", "id = ?", new String[]{String.valueOf(notaId)});
        db.close();
        return resultado > 0;
    }
}
