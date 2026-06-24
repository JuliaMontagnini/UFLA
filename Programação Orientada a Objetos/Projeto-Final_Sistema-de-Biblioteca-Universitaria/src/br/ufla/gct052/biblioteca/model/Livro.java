package br.ufla.gct052.biblioteca.model;

import java.util.ArrayList;

public class Livro {
    private String isbn;
    private String titulo;
    private String autores;
    private int ano;
    private ArrayList <Exemplar> exemplares;

    public Livro(String isbn, String titulo, String autores, int ano){
        if(isbn == null || isbn.isBlank()){
            throw new IllegalArgumentException("isbn inválido/nulo");
        }
        this.isbn = isbn;
        if(titulo == null || titulo.isBlank()){
            throw new IllegalArgumentException("título inválido/nulo");
        }
        this.titulo = titulo;
        if(autores == null || autores.isBlank()){
            throw new IllegalArgumentException("autores inválidos/nulo");
        }
        this.autores = autores;
        if(ano >= 2026){
            throw new IllegalArgumentException("ano inválido");
        }
        this.ano = ano;
        exemplares = new ArrayList<Exemplar>();
        
    }

    public String getIsbn() {
        return isbn;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getAutores() {
        return autores;
    }
    public int getAno() {
        return ano;
    }

    public void adicionarExemplar(Exemplar exemplar){
        exemplares.add(exemplar);
    }

    public void listarExemplares(){
        for (Exemplar exemplar: exemplares) {
            System.out.println(exemplar + "\n");
        }
    }

    public void listarExemplaresDisponiveis(){
        for (Exemplar exemplar: exemplares) {
            if(exemplar.getStatus() == StatusExemplar.DISPONIVEL){
                System.out.println(exemplar + "\n");
            }
        }
    }

    @Override
    public String toString(){
        return "Livro: " + getTitulo() + " | " + getIsbn();
    }
}
