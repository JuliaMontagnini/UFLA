package br.ufla.gct052.biblioteca.app;
import br.ufla.gct052.biblioteca.model.*;
import br.ufla.gct052.biblioteca.service.BibliotecaService;

public class App {
    public static void main(String[] args) {
        BibliotecaService biblioteca = new BibliotecaService();
        
        System.out.println("\n=== Cadastro de Usuários ===");
        Usuario aluno1 = new Aluno("001", "Peter", "parker@email.com", "Engenharia de Software", 5);
        biblioteca.cadastrarUsuario(aluno1);
        System.out.println("Aluno cadastrado: " + aluno1.getNome());
        
        Usuario professor1 = new Professor("010", "Octopus", "octopus@email.com", "ICTIN", "Doutor");
        biblioteca.cadastrarUsuario(professor1);
        System.out.println("Professor cadastrado: " + professor1.getNome());

        Usuario servidor1 = new Servidor("100", "Ned", "ned@email.com", "TI", "Auxiliar");
        biblioteca.cadastrarUsuario(servidor1);
        System.out.println("Servidor cadastrado: " + servidor1.getNome());

        System.out.println("\nLimite de empréstimos para o aluno: " + aluno1.getLimiteEmprestimos());
        System.out.println("Prazo de empréstimo para o aluno: " + aluno1.getPrazoEmprestimoDias());
        System.out.println("\nLimite de empréstimos para o professor: " + professor1.getLimiteEmprestimos());
        System.out.println("Prazo de empréstimo para o professor: " + professor1.getPrazoEmprestimoDias());
        System.out.println("\nLimite de empréstimos para o servidor: " + servidor1.getLimiteEmprestimos());
        System.out.println("Prazo de empréstimo para o servidor: " + servidor1.getPrazoEmprestimoDias());

        System.out.println("\n=== Cadastro de livros ===");
        Livro livro1 = new Livro("978-85-6457-416-8", "Fundamentos da programação de computadores", "Ascencio", 2012);
        biblioteca.cadastrarLivro(livro1);
        System.out.println("Livro cadastrado: " + livro1.getTitulo());

        Livro livro2 = new Livro("978-85-8260-469-4", "Conceitos de Linguagens de Programação", "Sebesta", 2018);
        biblioteca.cadastrarLivro(livro2);
        System.out.println("Livro cadastrado: " + livro2.getTitulo());

        Livro livro3 = new Livro("978-85-8055-569-1", "Métodos Numéricos para Engenharia", "Chapra", 2016);
        biblioteca.cadastrarLivro(livro3);
        System.out.println("Livro cadastrado: " + livro3.getTitulo());
        
        System.out.println("\n=== Cadastro de Exemplares ===");
        Exemplar exemplar1 = new Exemplar("01");
        biblioteca.cadastrarExemplar(exemplar1, "978-85-6457-416-8");
        System.out.println("ID: " + exemplar1.getCodigo() + " | Livro: " + exemplar1.getLivro());
        
        Exemplar exemplar2 = new Exemplar("02");
        biblioteca.cadastrarExemplar(exemplar2, "978-85-6457-416-8");
        System.out.println("ID: " + exemplar2.getCodigo() + " | Livro: " + exemplar2.getLivro());

        Exemplar exemplar3 = new Exemplar("03");
        biblioteca.cadastrarExemplar(exemplar3, "978-85-8260-469-4");
        System.out.println("ID: " + exemplar3.getCodigo() + " | Livro: " + exemplar3.getLivro());

        Exemplar exemplar4 = new Exemplar("04");
        biblioteca.cadastrarExemplar(exemplar4, "978-85-8260-469-4");
        System.out.println("ID: " + exemplar4.getCodigo() + " | Livro: " + exemplar4.getLivro());

        Exemplar exemplar5 = new Exemplar("05");
        biblioteca.cadastrarExemplar(exemplar5, "978-85-8055-569-1");
        System.out.println("ID: " + exemplar5.getCodigo() + " | Livro: " + exemplar5.getLivro());

        System.out.println("\n=== EMPRÉSTIMO VÁLIDO ===");
        System.out.println("Emprestando o exemplar 03 ao aluno " + aluno1.getNome() + ".\n");
        Emprestimo emprestimo1 = biblioteca.emprestar("001", "03");
        biblioteca.gerarRelatorio();
        
        System.out.println("\n=== EMPRÉSTIMO INVÁLIDO ===");
        System.out.println("Tentando emprestar o exemplar 03 ao professor " + professor1.getNome());
        try {
            biblioteca.emprestar("010", "03");
        } catch (IllegalArgumentException e) {
            System.out.println("Exemplar 03 está indisponível");
        }
        
        System.out.println("\nEmprestando o exemplar 01 ao aluno 001.");
        Emprestimo emprestimo2 = biblioteca.emprestar("001", "01");

        System.out.println("Emprestando o exemplar 05 ao aluno 001.\n");
        Emprestimo emprestimo3 = biblioteca.emprestar("001", "05");

        biblioteca.gerarRelatorio();
        try {
            biblioteca.emprestar("001", "02");
        } catch (IllegalArgumentException e) {
            System.out.println("\nTentativa de emprestar o exemplar 02 ao aluno 001 (impedido por exceder limite de empréstimos).");
        }
        
        System.out.println("\n=== DEVOLUÇÃO VÁLIDA ===");
        System.out.println("Peter devolve o exemplar 01");
        biblioteca.devolucao("001", "01", 2);
        System.out.println();
        biblioteca.gerarRelatorio();
        
        System.out.println("\n=== DEVOLUÇÃO INVÁLIDA ===");
        System.out.println("Peter tenta devolver o exemplar 01 de novo.");
        try {
            biblioteca.devolucao("001", "01", 2);
        } catch (IllegalArgumentException e) {
            System.out.println("Operação impedida, exemplar já devolvido.");
        }
        
        System.out.println("\n= = = = = = = = = = = = =\n");
        System.out.println("Empréstimos ativos no nome de Peter: " + aluno1.getEmprestimosAtivos());
        biblioteca.gerarRelatorioUsuario(aluno1);
        System.out.println();

        biblioteca.gerarRelatorioUsuario(professor1);
        System.out.println("\n=== Exemplares disponíveis para empréstimo:");
        biblioteca.listarExemplaresDisponiveis();
        
        System.out.println("\nEmprestando exemplar 04 ao professor " + professor1.getNome() + "\n");
        Emprestimo emprestimo4 = biblioteca.emprestar("010", "04");
        biblioteca.gerarRelatorioUsuario(professor1);
        System.out.println("\n=== Exemplares disponíveis para empréstimo:");
        biblioteca.listarExemplaresDisponiveis();

        System.out.println("\n=== ATRASOS E MULTAS ===");
        biblioteca.gerarRelatorioAtrasados();
        
        System.out.println("\nPeter devolve o exemplar 03:");
        biblioteca.devolucao("001", "03", 1);
        System.out.println();
        biblioteca.gerarRelatorioAtrasados();

    }
}
