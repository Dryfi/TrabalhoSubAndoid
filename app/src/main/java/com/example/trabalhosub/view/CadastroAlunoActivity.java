package com.example.trabalhosub.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.trabalhosub.R;
import com.example.trabalhosub.controller.AlunoController;

public class CadastroAlunoActivity extends AppCompatActivity {
    private EditText edtNome, edtMatricula;
    private Button btnCadastrar;
    private AlunoController alunoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_aluno);  // Conecta com o layout activity_cadastro_aluno.xml

        edtNome = findViewById(R.id.edtNome);
        edtMatricula = findViewById(R.id.edtMatricula);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        alunoController = new AlunoController(this);

        // Configurar o OnClickListener para o botão "Cadastrar"
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pega os valores dos campos
                String nome = edtNome.getText().toString();
                String matricula = edtMatricula.getText().toString();

                // Chama o método para adicionar o aluno
                alunoController.adicionarAluno(nome, matricula);

                // Limpa os campos de nome e matrícula
                edtNome.setText("");  // Limpa o campo de nome
                edtMatricula.setText("");  // Limpa o campo de matrícula

                // Exibe uma mensagem de sucesso
                Toast.makeText(CadastroAlunoActivity.this, "Aluno cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}