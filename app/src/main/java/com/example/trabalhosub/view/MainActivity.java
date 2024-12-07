package com.example.trabalhosub.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.trabalhosub.R;
import com.example.trabalhosub.model.Aluno;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Vincula o layout activity_main.xml

        // Encontrando os botões pelo ID
        Button btnCadastrarAluno = findViewById(R.id.btnCadastrarAluno); // Botão de cadastrar aluno
        Button btnListarAlunos = findViewById(R.id.btnListarAlunos); // Botão para listar alunos

        // Ação para o botão "Cadastrar Aluno"
        btnCadastrarAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent para abrir a tela de cadastro do aluno
                Intent intent = new Intent(MainActivity.this, CadastroAlunoActivity.class);
                startActivity(intent); // Inicia a CadastroAlunoActivity
            }
        });

        // Ação para o botão "Ver Lista de Alunos"
        btnListarAlunos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent para abrir a tela de listagem de alunos
                Intent intent = new Intent(MainActivity.this, Aluno.class); // Supondo que a atividade que exibe os alunos seja ListaAlunosActivity
                startActivity(intent); // Inicia a ListaAlunosActivity
            }
        });
    }
}
