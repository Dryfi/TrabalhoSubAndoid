package com.example.trabalhosub.dao;

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

    // Método para buscar todos os alunos
    public List<Aluno> getAllAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        db = dbHelper.getReadableDatabase(); // Obter o banco de dados para leitura

        // Consultando todos os alunos na tabela "aluno"
        Cursor cursor = db.rawQuery("SELECT * FROM aluno", null);

        // Verifica se há resultados
        if (cursor.moveToFirst()) {
            do {
                // Pega os dados do cursor
                String nome = cursor.getString(cursor.getColumnIndex("nome"));
                String matricula = cursor.getString(cursor.getColumnIndex("matricula"));

                // Cria um objeto Aluno e adiciona na lista
                alunos.add(new Aluno(nome, matricula));
            } while (cursor.moveToNext()); // Move para o próximo registro
        }

        // Fechar o cursor e o banco de dados após o uso
        cursor.close();
        db.close();

        return alunos;
    }
}
