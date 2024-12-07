package com.example.trabalhosub.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "app_database.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crie as tabelas aqui
        db.execSQL("CREATE TABLE Aluno (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, matricula TEXT);");
        db.execSQL("CREATE TABLE Nota (id INTEGER PRIMARY KEY AUTOINCREMENT, alunoId INTEGER, disciplinaId INTEGER, nota REAL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Aluno");
        db.execSQL("DROP TABLE IF EXISTS Nota");
        onCreate(db);
    }
}