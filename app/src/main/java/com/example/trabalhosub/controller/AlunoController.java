package com.example.trabalhosub.controller;

import android.content.Context;
import android.widget.Toast;
import com.example.trabalhosub.dao.AlunoDAO;

public class AlunoController {

    private Context context;
    private AlunoDAO alunoDAO;

    public AlunoController(Context context) {
        this.context = context;
        this.alunoDAO = new AlunoDAO(context);
    }

    public void adicionarAluno(String nome, String matricula) {
        if (nome.isEmpty() || matricula.isEmpty()) {
            Toast.makeText(context, "Nome ou matrícula não podem estar vazios!", Toast.LENGTH_SHORT).show();
            return;
        }


        boolean sucesso = alunoDAO.inserir(nome, matricula);
        if (sucesso) {
            Toast.makeText(context, "Aluno cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Erro ao cadastrar o aluno!", Toast.LENGTH_SHORT).show();
        }
    }
}
