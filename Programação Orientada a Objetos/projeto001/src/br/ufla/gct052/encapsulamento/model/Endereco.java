package br.ufla.gct052.encapsulamento.model;

public class Endereco {
    private String rua;
    private int numero;

    public Endereco(String rua, int numero){
        if(rua == null){
            throw new IllegalArgumentException("Rua inválida.");
        }
        this.rua = rua;
        if(numero < 0){
            throw new IllegalArgumentException("Número inválido.");
        }
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return rua + ", " + numero;
    }
}
