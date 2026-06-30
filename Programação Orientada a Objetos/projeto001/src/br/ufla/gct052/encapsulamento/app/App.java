package br.ufla.gct052.encapsulamento.app;
import br.ufla.gct052.encapsulamento.model.*;

public class App {
    public static void main(String[] args) {
        System.out.println("\n----------------- PARTE A -----------------\n");
        Cliente cliente = new Cliente();
        Conta conta = new Conta();
        conta.titular = cliente; // vinculando o cliente à conta

        conta.numero = 123;
        conta.titular.cpf = "123.456.789-00";
        System.out.println("Inicialmente, o cpf do titular da conta " + conta.numero + " foi definido como: " + conta.titular.cpf);
        
        conta.saldo = 1000000;
        System.out.println("\n1 - Com \"conta.saldo = 1000000\" o saldo da conta foi definido diretamente fora da classe como R$" + conta.saldo + ", algo que quebra a segurança da conta, afinal, nem todos devem poder alterar esse campo desse modo.");

        conta.numero = 124;
        System.out.println("2 - Com \"conta.numero = 124\" o número da conta foi alterado para " + conta.numero + ", algo que não deveria ser alterado depois de criado.");

        conta.titular.cpf = "009.876.543-21";
        System.out.println("3 - O cpf de uma pessoa é único e imutável, logo, também não deveria ser permitido alterá-lo. Entretanto, ele foi modificado para " + conta.titular.cpf + " com o comando \"conta.titular.cpf = \"009.876.543-21\"");

        conta.limite = -100;
        System.out.println("4 - Com \"conta.limite = -100\" o limite da conta foi definido como R$" + conta.limite + ", um valor inválido, pois o limite não pode ser negativo." +
                "\n    Além disso, o meio como isso ocorreu também pode prejudicar a segurança do sistema.");

        String nomeCliente = conta.titular.nome;
        System.out.println("5 - Definindo uma string nomeCliente e tentando armazenar nela \"conta.titular.nome\" é realizada uma tentativa de se obter o nome do cliente, porém, o mesmo ainda não foi definido, o que retorna apenas '" + nomeCliente + "'");

        System.out.println("\n----------------- PARTE B (CÓDIGO REFATORADO) -----------------\n");

        ClienteRefatorado clienteR = new ClienteRefatorado("Cebolinha", "123.456.789-00");        
        ContaRefatorada contaR = new ContaRefatorada(123, 500, clienteR);

        System.out.println("* Entre () estão os números que relacionam o antes e depois da refatoração.");
        
        System.out.println("\nAgora na criação dos objetos já há a passagem obrigatória dos parâmetros, com validação, incluindo também a vinculação conta-cliente. Isso evita erros como NullPointerException.\n" +
        "\n(1) - O saldo de cada cliente se inicia zerado. (R$" + contaR.getSaldo() + ").");
        
        contaR.depositar(1000);
        System.out.println("(1) - Com a operação de depósito, o saldo passou a ser R$" + contaR.getSaldo());
        contaR.sacar(100);
        System.out.println("(1) - Com a operação de saque, o saldo passou a ser R$" + contaR.getSaldo());

        System.out.println("(1, 2 e 3) - Já não é mais possível alterar o número da conta, o cpf do cliente e, diretamente, o saldo, pois são atributos privados.");
        
        try {
            contaR.setLimite(-100);
        } catch (Exception e) {
            System.out.println("(4) - Ao tentar alterar o limite para um valor negativo, como por \"contaR.setLimite(-100)\" é lançada uma exceção, impedindo a operação.");
        }
        
        String nomeClienteR = clienteR.getNome();
        System.out.println("(5) - Agora, com a obrigatoriedade de se fornecer o nome do cliente na criação do objeto, é possível retornar seu nome, que no caso da conta " + contaR.getNumero() + " é " + nomeClienteR);

        System.out.println("\n----------------- PARTE C -----------------\n");

        System.out.println("Definindo uma nova cliente, com seu endereço:");
        Endereco enderecoC = new Endereco("Rua dos Bobos", 0);
        ClienteRefatorado clienteC = new ClienteRefatorado("Mônica", "111.222.333-44", enderecoC);
        ContaRefatorada contaC = new ContaRefatorada(321, 500, clienteC);
        System.out.println("Endereço da cliente " + clienteC.getNome() + ": " + clienteC.getEndereco());

        System.out.println("\nAlterando o endereço da cliente, que é privado, mas tem a referência exposta:");
        clienteC.getEndereco().setRua("Rua dos limoeiros");
        clienteC.getEndereco().setNumero(78);
        System.out.println("Endereço da cliente " + clienteC.getNome() + " alterado para: " + clienteC.getEndereco());

        System.out.println("\nUtilizando o método de cópia defensiva e tentando alterar novamente o endereço:");
        clienteC.getEnderecoProtegido().setRua("Rua dos bobos");
        clienteC.getEnderecoProtegido().setNumero(0);
        System.out.println("O endereço da cliente " + clienteC.getNome() + " é " + clienteC.getEndereco());

        // Bônus para testar o método que faltava
        System.out.println("\n----- Aproveitando as duas contas criadas corretamente, é possível testar o método \"transferir\"");
        contaC.depositar(1500);
        System.out.println("\nA " + contaC + " recebeu um depósito de R$" + contaC.getSaldo());
        contaC.transferir(contaR, 100);
        System.out.println("Foram transferidos R$100.00 da conta " + contaC + " para a " + contaR +
            "\n\nSaldo da conta " + contaC + " atualizado: R$" + contaC.getSaldo() +
            "\nSaldo da conta " + contaR + " atualizado: R$" + contaR.getSaldo());
    }
}