package br.ufla.gct052.encapsulamento.model;

public class ContaRefatorada {
    private int numero;
    private double saldo;
    private double limite;
    private ClienteRefatorado titular;

    public ContaRefatorada(int numero, double limite, ClienteRefatorado titular){
        this.saldo = 0;
        if(limite < 0){
            throw new IllegalArgumentException ("Limite não pode ser menor que 0.");
        }
        this.limite = limite;
        this.numero = numero;
        if(titular == null){
            throw new IllegalArgumentException("Titular não pode ser nulo.");
        }
        this.titular = titular;

    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        if (limite < 0){
            throw new IllegalArgumentException ("Limite não pode ser menor que 0.");
        }
        this.limite = limite;
    }

    public ClienteRefatorado getTitular() {
        return titular;
    }

    public void depositar(double valor){
        if(valor <= 0){
            throw new IllegalArgumentException ("Não há como depositar um valor <= 0.") ;
        }
        this.saldo += valor;
    }

    public boolean sacar(double valor){
        if(valor <= 0){
            return false;
        }
        if(saldo + limite < valor){
            return false;
        }
        this.saldo -= valor ;
        return true ;
    }

    public boolean transferir(ContaRefatorada destino, double valor){
        boolean ok = this.sacar(valor);
        if(ok){
            destino.depositar(valor);
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return "conta " + numero + ", pertencente ao(à) " + titular;
    }
}