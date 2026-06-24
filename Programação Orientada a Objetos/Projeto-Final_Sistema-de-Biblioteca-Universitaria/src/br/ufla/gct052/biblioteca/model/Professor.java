package br.ufla.gct052.biblioteca.model;

public class Professor extends Usuario{
    private String departamento;
    private String titulacao;

    public Professor(String id, String nome, String email, String departamento, String titulacao){
        super(id, nome, email);
        if(departamento == null || departamento.isBlank()){
            throw new IllegalArgumentException("departamento inválido/nulo");
        }
        this.departamento = departamento;
        if(titulacao == null || titulacao.isBlank()){
            throw new IllegalArgumentException("titulação inválida/nula");
        }
        this.titulacao = titulacao;
    }

    @Override
    public int getLimiteEmprestimos(){
        return 5;
    }
}
