package br.ufla.gct052.biblioteca.model;

public class Exemplar {
    private String codigo;
    private StatusExemplar status;

    public Exemplar(String codigo, StatusExemplar status){
        if(codigo == null || codigo.isBlank()){
            throw new IllegalArgumentException("código inválido/nulo");
        }
        this.codigo = codigo;
        status = StatusExemplar.DISPONIVEL;
    }
    
    public String getCodigo() {
        return codigo;
    }
    public StatusExemplar getStatus() {
        return status;
    }

    @Override
    public String toString(){
        return "Exemplar " + getCodigo(); 
    }
}