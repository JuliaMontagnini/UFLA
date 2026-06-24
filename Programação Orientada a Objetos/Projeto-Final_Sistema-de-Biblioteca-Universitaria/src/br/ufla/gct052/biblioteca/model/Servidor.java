package br.ufla.gct052.biblioteca.model;

public class Servidor extends Usuario{
    private String setor;
    private String cargo;

    public Servidor(String id, String nome, String email, String setor, String cargo){
        super(id, nome, email);
        if(setor == null || setor.isBlank()){
            throw new IllegalArgumentException("setor inválido/nulo");
        }
        this.setor = setor;
        if(cargo == null || cargo.isBlank()){
            throw new IllegalArgumentException("cargo inválida/nula");
        }
        this.cargo = cargo;
    }

    @Override
    public int getLimiteEmprestimos(){
        return 5;
    }
}