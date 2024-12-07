package com.example.trabalhosub.model;

public class Nota {
    private Aluno aluno;
    private Disciplina disciplina;
    private double nota;

    // Construtor
    public Nota(Aluno aluno, Disciplina disciplina, double nota) {
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.nota = nota;
    }

    // Getters e Setters
    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "aluno=" + aluno.getNome() +
                ", disciplina=" + disciplina.getNome() +
                ", nota=" + nota +
                '}';
    }
}
