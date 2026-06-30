package br.ufla.gct052.encapsulamento.model;

public class ClienteRefatorado {
    private String nome;
    private String cpf;
    private Endereco endereco;

    public ClienteRefatorado(String nome, String cpf){
        if(nome == null){
            throw new IllegalArgumentException("Nome inválido.");
        }
        this.nome = nome;
        if(cpf == null || cpf.length() == 0){
            throw new IllegalArgumentException ("CPF nulo ou vazio.") ;
        }
        this.cpf = cpf;
    }

    public ClienteRefatorado(String nome, String cpf, Endereco endereco){
        this(nome, cpf);
        this.endereco = endereco;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome == null){
            throw new IllegalArgumentException("Nome inválido.");
        }
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    // PARTE C
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    // Protegendo
    public Endereco getEnderecoProtegido(){
        return new Endereco(getEndereco().getRua(), getEndereco().getNumero());
    }

    public void setEnderecoProtegido(Endereco endereco) {
        this.endereco = new Endereco(getEndereco().getRua(), getEndereco().getNumero());
    }
    
    @Override
    public String toString() {
        return "cliente " + nome + ", CPF: " + cpf;
    }
}