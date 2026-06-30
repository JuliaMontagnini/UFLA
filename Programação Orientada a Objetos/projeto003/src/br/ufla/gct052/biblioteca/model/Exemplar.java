package br.ufla.gct052.biblioteca.model;

public class Exemplar {
    private String codigo;
    private StatusExemplar status;
    private Livro livro;

    public Exemplar(String codigo){
        if(codigo == null || codigo.isBlank()){
            throw new IllegalArgumentException("código inválido/nulo");
        }
        this.codigo = codigo;
        this.status = StatusExemplar.DISPONIVEL;
    }
    
    public String getCodigo() {
        return codigo;
    }
    public StatusExemplar getStatus() {
        return status;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Livro getLivro() {
        return livro;
    }
    
    public void emprestar(){
        this.status = StatusExemplar.EMPRESTADO;
    }
    
    public void devolver(){
        this.status = StatusExemplar.DISPONIVEL;
    }

    @Override
    public String toString(){
        return getCodigo() + " | Título: " + getLivro().getTitulo(); 
    }
}