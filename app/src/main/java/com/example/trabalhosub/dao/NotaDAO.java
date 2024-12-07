package com.example.trabalhosub.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.trabalhosub.model.Nota;
import com.example.trabalhosub.helper.DatabaseHelper;
import com.example.trabalhosub.model.Aluno;
import com.example.trabalhosub.model.Disciplina;

import java.util.ArrayList;
import java.util.List;

public class NotaDAO {
    private SQLiteDatabase db;
    private DatabaseHelper helper;

    public NotaDAO(Context context) {
        helper = new DatabaseHelper(context);
        db = helper.getWritableDatabase();
    }

    // Método para inserir uma nota
    public long inserir(Nota nota) {
        ContentValues values = new ContentValues();
        values.put("id_aluno", nota.getAluno().getMatricula());
        values.put("id_disciplina", nota.getDisciplina().getNome());
        values.put("nota", nota.getNota());
        return db.insert("nota", null, values);
    }

    // Método para listar as notas
    public List<Nota> listar() {
        List<Nota> notas = new ArrayList<>();
        Cursor cursor = db.query("nota", new String[]{"id", "id_aluno", "id_disciplina", "nota"},
                null, null, null, null, null);
        while (cursor.moveToNext()) {
            // Exemplo simples, falta conectar com Aluno e Disciplina
            Nota nota = new Nota(new Aluno(cursor.getString(1), ""),
                    new Disciplina(cursor.getString(2), 0),
                    cursor.getDouble(3));
            notas.add(nota);
        }
        cursor.close();
        return notas;
    }
}
