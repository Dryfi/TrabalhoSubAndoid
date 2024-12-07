package com.example.trabalhosub.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.trabalhosub.helper.DatabaseHelper;
import com.example.trabalhosub.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public AlunoDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public boolean inserir(String nome, String matricula) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nome", nome);
        values.put("matricula", matricula);

        long resultado = db.insert("Aluno", null, values);
        db.close();
        return resultado != -1;
    }

    public List<Aluno> getAllAlunos() {
        db = dbHelper.getReadableDatabase();
        List<Aluno> listaAlunos = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM Aluno", null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String nome = cursor.getString(cursor.getColumnIndexOrThrow("nome"));
                String matricula = cursor.getString(cursor.getColumnIndexOrThrow("matricula"));
                listaAlunos.add(new Aluno(id, nome, matricula));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return listaAlunos;
    }
    public boolean deletar(int alunoId) {
        db = dbHelper.getWritableDatabase();
        int resultado = db.delete("Aluno", "id = ?", new String[]{String.valueOf(alunoId)});
        db.close();
        return resultado > 0;
    }
    public boolean atualizar(int id, String nome, String matricula) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nome", nome);
        values.put("matricula", matricula);

        int resultado = db.update("Aluno", values, "id = ?", new String[]{String.valueOf(id)});
        db.close();
        return resultado > 0;
    }
}