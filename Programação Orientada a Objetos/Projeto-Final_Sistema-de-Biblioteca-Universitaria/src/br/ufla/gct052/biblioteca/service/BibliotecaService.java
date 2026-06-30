package br.ufla.gct052.biblioteca.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ufla.gct052.biblioteca.model.*;

public class BibliotecaService implements Relatorio{
    private Map<String, Usuario> usuarios = new HashMap<>();
    private Map<String, Livro> livros = new HashMap<>();
    private Map<String, Exemplar> exemplares = new HashMap<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();
    
    public void cadastrarUsuario(Usuario usuario){
        if(usuarios.containsKey(usuario.getId())){
            throw new IllegalArgumentException("ID de usuário já cadastrado");
        }
        usuarios.put(usuario.getId(), usuario);
    }

    public void cadastrarLivro(Livro livro){
        if(livros.containsKey(livro.getIsbn())){
            throw new IllegalArgumentException("ISBN de livro já cadastrado");
        }
        livros.put(livro.getIsbn(), livro);
    }

    public void cadastrarExemplar(Exemplar exemplar, String isbn){
        if(exemplares.containsKey(exemplar.getCodigo())){
            throw new IllegalArgumentException("Código de exemplar já cadastrado");
        }
        exemplares.put(exemplar.getCodigo(), exemplar);
        Livro livro = buscarLivro(isbn);
        livro.adicionarExemplar(exemplar);
        exemplar.setLivro(livro);
    }

    public Usuario buscarUsuario(String id){
        Usuario usuario = usuarios.get(id);
        if(usuario == null){
            throw new IllegalArgumentException("Usuário não encontrado");
        }
        return usuario;
    }

    public Livro buscarLivro(String isbn){
        Livro livro = livros.get(isbn);
        if(livro == null){
            throw new IllegalArgumentException("Livro não encontrado");
        }
        return livro;
    }

    public Exemplar buscarExemplar(String codigo){
        Exemplar exemplar = exemplares.get(codigo);
        if(exemplar == null){
            throw new IllegalArgumentException("Exemplar não encontrado");
        }
        return exemplar;
    }

    public void listarLivros(){
        for (Livro livro : livros.values()) {
            System.out.println(livro);
        }
    }

    public void listarExemplaresDisponiveis(){
        for (Exemplar exemplar : exemplares.values()) {
            if(exemplar.getStatus() == StatusExemplar.DISPONIVEL){
                System.out.println(exemplar);
            }
        }
    }

    public void listarUsuarios(){
        for (Usuario usuario : usuarios.values()) {
            System.out.println(usuario);
        }
    }

    public Emprestimo emprestar(String idUsuario, String codigoExemplar){
        Usuario u = buscarUsuario(idUsuario);
        if(u == null){
            throw new IllegalArgumentException("Usuário inválido");
        }
        Exemplar e = buscarExemplar(codigoExemplar);
        if(e == null){
            throw new IllegalArgumentException("Exemplar inválido");
        }
        
        // validações
        if(!u.podeEmprestar()){
            throw new IllegalArgumentException("Usuário atingiu o limite de empréstimos");
        }
        if(e.getStatus() == StatusExemplar.EMPRESTADO || e.getStatus() == StatusExemplar.BLOQUEADO){
            throw new IllegalArgumentException("Exemplar indisponível");
        }
        
        Emprestimo novoEmprestimo = new Emprestimo(u, e);
        // muda o status para emprestado e aumenta o numero de emprestimos
        e.emprestar();
        u.registrarEmprestimo();
        
        emprestimos.add(novoEmprestimo);
        return novoEmprestimo;

    }

    public void devolucao(String idUsuario, String codigoExemplar, int codigoEmprestimo){
        Usuario u = buscarUsuario(idUsuario);
        if(u == null){
            throw new IllegalArgumentException("Usuário inválido");
        }
        Exemplar e = buscarExemplar(codigoExemplar);
        if(e == null){
            throw new IllegalArgumentException("Exemplar inválido");
        }

        boolean encontrado = false;
        for (Emprestimo emprestimo : emprestimos) {
            if(emprestimo.getId() == codigoEmprestimo){
                if(emprestimo.getStatus() == StatusEmprestimo.DEVOLVIDO){
                    throw new IllegalArgumentException("Empréstimo já foi devolvido.");
                }
                double multa = emprestimo.devolver();
                if(multa > 0){
                    System.out.println("Multa de R$" + multa);
                }
                encontrado = true;
                break;
            }
        }
        
        if(!encontrado){
            throw new IllegalArgumentException("Empréstimo não encontrado)");
        }
        e.devolver();
        u.registrarDevolucao();
    }

    @Override
    public void gerarRelatorio(){
        System.out.println("=== RELATÓRIO - Empréstimos ativos ===");
        for (Emprestimo emprestimo : emprestimos) {
            if(emprestimo.getStatus() == StatusEmprestimo.ATIVO){
                System.out.println(emprestimo);
            }
        }
    }

    public void gerarRelatorioUsuario(Usuario usuario){
        System.out.println("=== RELATÓRIO - Empréstimos de " + usuario.getNome() + " ===");
        for (Emprestimo emprestimo : emprestimos) {
            if(emprestimo.getStatus() == StatusEmprestimo.ATIVO){
                if(emprestimo.getUsuario().equals(usuario)){
                    System.out.println(emprestimo);
                }
            }
        }
    }

    public void gerarRelatorioAtrasados(){
        System.out.println("=== RELATÓRIO - Empréstimos atrasados ===");
        for (Emprestimo emprestimo : emprestimos) {
            if(emprestimo.atrasado()){
                System.out.println(emprestimo);
            }
        }
    }
}