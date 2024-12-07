package com.example.trabalhosub.view;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.trabalhosub.R;
import com.example.trabalhosub.dao.NotaDAO;
import com.example.trabalhosub.model.Nota;

import java.util.List;

public class RelacaoMediasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relacao_medias);

        TableLayout tableMedias = findViewById(R.id.tableMedias);
        NotaDAO notaDAO = new NotaDAO(this);

        int alunoId = 1;
        List<Nota> notas = notaDAO.getNotasPorAluno(alunoId);

        for (Nota nota : notas) {
            TableRow row = new TableRow(this);

            TextView disciplina = new TextView(this);
            disciplina.setText("Programação de dispositivos moveis");

            TextView notaView = new TextView(this);
            notaView.setText(String.valueOf(nota.getNota()));

            row.addView(disciplina);
            row.addView(notaView);

            tableMedias.addView(row);
        }
    }
}
