package com.example.trabalhosub.view;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

import com.example.trabalhosub.R;
import com.example.trabalhosub.dao.AlunoDAO;
import com.example.trabalhosub.model.Aluno;

import java.util.List;

public class ListaAlunosActivity extends AppCompatActivity {

    private Spinner spinnerAluno; // Utilizando o Spinner para exibir os alunos
    private AlunoDAO alunoDAO;
    private ArrayAdapter<Aluno> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cadastro_notas);

        spinnerAluno = findViewById(R.id.spinnerDisciplina); // Reutilizando o Spinner existente
        alunoDAO = new AlunoDAO(this);

        List<Aluno> listaAlunos = alunoDAO.getAllAlunos();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaAlunos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAluno.setAdapter(adapter);
    }
}