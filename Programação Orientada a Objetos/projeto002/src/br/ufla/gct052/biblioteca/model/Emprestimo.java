package br.ufla.gct052.biblioteca.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.concurrent.ThreadLocalRandom;
import java.time.temporal.ChronoUnit;

public class Emprestimo{
    private int id;
    private static int codigoEmprestimo = 1;
    private Usuario usuario;
    private Exemplar exemplar;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolucao;
    private StatusEmprestimo status;

    public Emprestimo(Usuario usuario, Exemplar exemplar){
        if(usuario == null){
            throw new IllegalArgumentException("Usuário nulo");
        }
        this.usuario = usuario;
        if(exemplar == null){
            throw new IllegalArgumentException("Exemplar nulo");
        }
        this.exemplar = exemplar;
        this.status = StatusEmprestimo.ATIVO;
        // tomando a data de empréstimo como um dia aleatório entre 01/01/2026 e 01/07/2026
        this.dataEmprestimo = LocalDate.ofEpochDay(ThreadLocalRandom.current().nextLong(20454, 20636));
        this.dataPrevistaDevolucao = dataEmprestimo.plusDays(usuario.getPrazoEmprestimoDias());
        this.id = codigoEmprestimo;
        codigoEmprestimo++;
    }

    public int getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public StatusEmprestimo getStatus() {
        return status;
    }

    public static int getCodigoEmprestimo() {
        return codigoEmprestimo;
    }

    public double devolver(){
        double multa = 0;
        if(atrasado()){
            multa = multaAtraso();
        }
        this.dataDevolucao = LocalDate.now();
        this.status = StatusEmprestimo.DEVOLVIDO;
        return multa;
    }    

    public boolean atrasado(){ 
        if(this.getStatus() != StatusEmprestimo.DEVOLVIDO && LocalDate.now().isAfter(dataPrevistaDevolucao)){
            this.status = StatusEmprestimo.ATRASADO;
            return true;
        }
        return false;
    }

    public double multaAtraso(){
        long diasAtraso = ChronoUnit.DAYS.between(dataPrevistaDevolucao, LocalDate.now());
        return diasAtraso * 0.5; // multa de 50 centavos por dia para todos
    }

    @Override
    public String toString(){
        return "Empréstimo: " + getId() + " | Data do Empréstimo: " + getDataEmprestimo() + " | Usuário: " + getUsuario().getNome() + " | Exemplar: " + getExemplar();
    }
}