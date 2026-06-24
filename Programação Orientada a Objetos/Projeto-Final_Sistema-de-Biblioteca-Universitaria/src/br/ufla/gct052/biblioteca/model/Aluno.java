package br.ufla.gct052.biblioteca.model;

public class Aluno extends Usuario{
    private String curso;
    private int periodo; // int pois pode ser incrementado ao fim do semestre

    public Aluno(String id, String nome, String email, String curso, int periodo){
        super(id, nome, email);
        if(curso == null || curso.isBlank()){
            throw new IllegalArgumentException("curso inválido/nulo");
        }
        this.curso = curso;
        if(periodo <= 0 || periodo >= 12){
            throw new IllegalArgumentException("período inválido");
        }
        this.periodo = periodo;
    }

    @Override
    public int getLimiteEmprestimos(){
        return 3;
    }
}