package com.example.trabalhosub.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "app_database.db";
    private static final int DATABASE_VERSION = 2;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Aluno (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, matricula TEXT NOT NULL UNIQUE);");
        db.execSQL("CREATE TABLE Disciplina (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL UNIQUE);");
        db.execSQL("CREATE TABLE Nota (id INTEGER PRIMARY KEY AUTOINCREMENT, alunoId INTEGER, disciplinaId INTEGER, nota REAL, bimestre INTEGER, FOREIGN KEY (alunoId) REFERENCES Aluno(id), FOREIGN KEY (disciplinaId) REFERENCES Disciplina(id));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Nota");
        db.execSQL("DROP TABLE IF EXISTS Disciplina");
        db.execSQL("DROP TABLE IF EXISTS Aluno");
        onCreate(db);
    }
}