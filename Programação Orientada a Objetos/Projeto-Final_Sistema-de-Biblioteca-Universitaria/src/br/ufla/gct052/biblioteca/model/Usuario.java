package br.ufla.gct052.biblioteca.model;

public abstract class Usuario {
    private final String id;
    private String nome;
    private String email;
    private int emprestimosAtivos;

    public Usuario(String id, String nome, String email){
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException("id inválido/nulo");
        }
        this.id = id;
        if(nome == null || nome.isBlank()){
            throw new IllegalArgumentException("nome inválido/nulo");
        }
        this.nome = nome;
        if(email == null || email.isBlank()){
            throw new IllegalArgumentException("email inválido/nulo");
        }
        this.email = email;
        this.emprestimosAtivos = 0;
    }

    public String getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public String getEmail(){
        return email;
    }
    public int getEmprestimosAtivos(){
        return emprestimosAtivos;
    }

    public abstract int getLimiteEmprestimos();

    public boolean podeEmprestar(){
        if(getEmprestimosAtivos() < getLimiteEmprestimos()){
            return true;
        }
        return false;
    }

    protected int incrementarEmprestimos(){
        emprestimosAtivos += 1;
        return emprestimosAtivos;
    }

    protected int decrementarEmprestimos(){
        emprestimosAtivos -= 1;
        return emprestimosAtivos;
    }

    @Override
    public String toString(){
        return getClass() + ": " + getId() + ", " + getNome();
    }
}