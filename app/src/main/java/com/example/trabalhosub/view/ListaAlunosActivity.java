package com.example.trabalhosub.view;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;

import com.example.trabalhosub.R;
import com.example.trabalhosub.dao.AlunoDAO;
import com.example.trabalhosub.model.Aluno;
import java.util.List;

public class ListaAlunosActivity extends AppCompatActivity {

    private ListView listViewAlunos;
    private AlunoDAO alunoDAO;  // Referência ao DAO que acessa o banco de dados
    private ArrayAdapter<Aluno> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);  // Referência ao layout

        listViewAlunos = findViewById(R.id.listViewAlunos);
        alunoDAO = new AlunoDAO(this);  // Instância do DAO

        // Obtém a lista de alunos do banco de dados
        List<Aluno> listaAlunos = alunoDAO.getAllAlunos();

        // Criar um adaptador para a lista de alunos
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaAlunos);

        // Configura o ListView para exibir a lista de alunos
        listViewAlunos.setAdapter(adapter);
    }
}
