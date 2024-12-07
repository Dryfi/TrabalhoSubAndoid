package com.example.trabalhosub.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trabalhosub.R;
import com.example.trabalhosub.dao.AlunoDAO;
import com.example.trabalhosub.dao.NotaDAO;

public class CadastroAlunoActivity extends AppCompatActivity {

    private EditText edtRA, edtNome, edtNota;
    private Spinner spinnerDisciplina, spinnerBimestre;
    private Button btnAdicionar;
    private AlunoDAO alunoDAO;
    private NotaDAO notaDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_notas);  // Usar o layout existente

        edtRA = findViewById(R.id.edtRA);
        edtNome = findViewById(R.id.edtNome);
        edtNota = findViewById(R.id.edtNota);
        spinnerDisciplina = findViewById(R.id.spinnerDisciplina);
        spinnerBimestre = findViewById(R.id.spinnerBimestre);
        btnAdicionar = findViewById(R.id.btnAdicionar);

        alunoDAO = new AlunoDAO(this);
        notaDAO = new NotaDAO(this);

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarAlunoENota();
            }
        });
    }

    private void cadastrarAlunoENota() {
        String ra = edtRA.getText().toString();
        String nome = edtNome.getText().toString();
        String disciplina = spinnerDisciplina.getSelectedItem().toString();
        String notaString = edtNota.getText().toString();
        String bimestreString = spinnerBimestre.getSelectedItem().toString();

        if (ra.isEmpty() || nome.isEmpty() || notaString.isEmpty() || bimestreString.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        double nota = Double.parseDouble(notaString);
        int bimestre = Integer.parseInt(bimestreString);

        // Inserir o aluno no banco
        boolean alunoInserido = alunoDAO.inserir(nome, ra);
        if (!alunoInserido) {
            Toast.makeText(this, "Erro ao cadastrar o aluno!", Toast.LENGTH_SHORT).show();
            return;
        }

        int alunoId = alunoDAO.getAllAlunos().stream()
                .filter(aluno -> aluno.getMatricula().equals(ra))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Aluno não encontrado!"))
                .getId();

        boolean notaInserida = notaDAO.inserirNota(alunoId, 1, nota, bimestre); // 1 é um exemplo de ID de disciplina
        if (!notaInserida) {
            Toast.makeText(this, "Erro ao cadastrar a nota!", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "Aluno e nota cadastrados com sucesso!", Toast.LENGTH_SHORT).show();

        edtRA.setText("");
        edtNome.setText("");
        edtNota.setText("");
        spinnerDisciplina.setSelection(0);
        spinnerBimestre.setSelection(0);
    }
}
