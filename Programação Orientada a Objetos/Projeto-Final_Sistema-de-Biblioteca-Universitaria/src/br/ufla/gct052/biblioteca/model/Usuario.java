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
    public abstract int getPrazoEmprestimoDias();

    public boolean podeEmprestar(){
        if(getEmprestimosAtivos() < getLimiteEmprestimos()){
            return true;
        }
        return false;
    }

    protected void incrementarEmprestimos(){
        emprestimosAtivos += 1;
    }

    protected void decrementarEmprestimos(){
        if(emprestimosAtivos > 0){
            emprestimosAtivos -= 1;
        }
    }

    public void registrarEmprestimo() { // o direto de incrementar é protected
        incrementarEmprestimos();
    }

    public void registrarDevolucao() {
        decrementarEmprestimos();
    }

    @Override
    public String toString(){
        return getClass() + ": " + getId() + ", " + getNome();
    }
}