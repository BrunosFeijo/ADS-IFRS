package Ex7_SistemaBancario;

import java.awt.image.BandedSampleModel;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Pessoa> pessoasSemConta = new ArrayList<>();

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcao;
        do {
            opcao = menu();
            switch (opcao) {

                case 1 -> criarBanco();
                case 2 -> criarConta();
                case 3 -> pessoasSemConta.add(criarPessoa());
                case 4 -> BancosDisponiveis.novoMes();
                case 5 -> {
                    Banco banco = BancosDisponiveis.procuraBanco();
                    System.out.println("Digite o número da Conta: ");
                    int nroConta = entrada.nextInt();
                    ContaBancaria conta = banco.contemNroConta(nroConta);
                    if (conta != null){
                        conta.saque();
                    }else{
                        System.out.println("Número de conta inválido");
                    }
                }
                case 6 -> {
                    Banco banco = BancosDisponiveis.procuraBanco();
                    System.out.println("Digite o número da Conta: ");
                    int nroConta = entrada.nextInt();
                    ContaBancaria conta = banco.contemNroConta(nroConta);
                    if (conta != null){
                        conta.deposito();
                    }else{
                        System.out.println("Número de conta inválido");
                    }
                }
                case 7 ->{
                    Banco banco = BancosDisponiveis.procuraBanco();
                    System.out.println("Digite o número da Conta: ");
                    int nroConta = entrada.nextInt();
                    ContaBancaria conta = banco.contemNroConta(nroConta);
                    if (conta != null){
                        conta.transferir();
                    }else{
                        System.out.println("Número de conta inválido");
                    }
                }
                case 8 ->{
                    Banco banco = BancosDisponiveis.procuraBanco();
                    System.out.println("Digite o número da Conta: ");
                    int nroConta = entrada.nextInt();
                    ContaBancaria conta = banco.contemNroConta(nroConta);
                    if (conta != null){
                        banco.fecharConta(conta);
                        if (conta.titular.getContasBancarias().size() == 0) pessoasSemConta.add(conta.titular);
                    }else{
                        System.out.println("Número de conta inválido");
                    }
                }
                case 9 -> {
                    exemplosBancos();
                    exemplosContas();
                }
            }
        } while (opcao != 0);
        System.out.println("Fim do programa");
    }

    public static int menu() {
        Scanner entrada = new Scanner(System.in);
        int opcao = -1;
        System.out.println("-----------------Menu-----------------");
        System.out.println("1 - Adicionar Banco");
        System.out.println("2 - Adicinar Conta");
        System.out.println("3 - Adicionar Pessoa");
        System.out.println("4 - Simular passagem de mês");
        System.out.println("5 - Realizar saque");
        System.out.println("6 - Realizar depósito");
        System.out.println("7 - Realizar transferência");
        System.out.println("8 - Fechar Conta");
        System.out.println("9 - Gerar exemplos prontos");
        System.out.println("0 - Sair");
        System.out.println("--------------------------------------");
        System.out.print("Digite uma opção: ");
        while (opcao < 0 || opcao > 8) {
            opcao = entrada.nextInt();
            if (opcao < 0 || opcao > 8) System.out.println("Opção inválida!");
        }
        return opcao;
    }

    public static void criarBanco() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("-------------Novo Banco-------------");

        System.out.print("Digite o nome do Banco: ");
        String nome = entrada.nextLine();

        System.out.print("Digite o CNPJ do Banco: ");
        String cnpj = entrada.nextLine();

        System.out.print("Digite o N° do Banco: ");
        int nroBanco = entrada.nextInt();

        Banco banco = new Banco(nome, cnpj, nroBanco);
        System.out.println("------------------------------------");
    }

    public static void criarConta() {
        Scanner entrada = new Scanner(System.in);
        int opcao;
        Pessoa titular = null;
        System.out.println("-------------Nova Conta-------------");
        do {
            System.out.println("1 - Criar uma nova Pessoa");
            System.out.println("2 - Pessoa já criada");
            opcao = entrada.nextInt();
            if (opcao == 1) {
                titular = criarPessoa();
            } else if (opcao == 2) {
                do {
                    System.out.println("Esta Pessoa já possui alguma conta? ");
                    System.out.println("1 - Sim");
                    System.out.println("2 - Não");
                    opcao = entrada.nextInt();
                    if (opcao == 1) {
                        System.out.println("Digite o CPF: ");
                        int cpf = entrada.nextInt();
                        titular = BancosDisponiveis.getPessoa(cpf);
                        if (titular == null) {
                            System.out.println("CPF inválido");
                            opcao = 0;
                        }
                    } else if (opcao == 2) {
                        System.out.println("Digite o CPF: ");
                        int cpf = entrada.nextInt();
                        boolean encontrado = false;

                        for (Pessoa pessoa : pessoasSemConta) {
                            if (pessoa.getCpf().equals(String.valueOf(cpf))) {
                                titular = pessoa;
                                encontrado = true;
                            }
                        }
                        if (!encontrado) {
                            System.out.println("CPF inválido");
                            opcao = 0;
                        }
                    }
                } while (opcao < 1 || opcao > 2);
            }
        } while (opcao < 1 || opcao > 2);
        System.out.print("Digite o N° do Banco: ");
        Banco banco = BancosDisponiveis.procuraBanco();

        System.out.print("Digite uma senha para a conta: ");
        int senha = entrada.nextInt();

        do {
            System.out.println("Qual tipo de conta: ");
            System.out.println("1 - Conta Corrente");
            System.out.println("2 - Conta Poupança");
            opcao = entrada.nextInt();
            if (opcao == 1) {
                ContaBancaria contaBancaria = new ContaCorrente(titular, banco, String.valueOf(senha));
            } else if (opcao == 2) {
                ContaBancaria contaBancaria = new ContaPoupanca(titular, banco, String.valueOf(senha));
            }
        } while (opcao < 1 || opcao > 2);

        pessoasSemConta.remove(titular);

        System.out.println("------------------------------------");
    }

    public static Pessoa criarPessoa() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("-------------Nova Pessoa-------------");

        System.out.print("Digite o nome do Cliente: ");
        String nome = entrada.nextLine();

        System.out.print("Digite o sobrenome do Cliente: ");
        String sobrenome = entrada.nextLine();

        System.out.print("Digite a idade do Cliente: ");
        int idade = entrada.nextInt();

        System.out.print("Digite o CPF do Cliente: ");
        int cpf = entrada.nextInt();

        System.out.println("------------------------------------");
        return new Pessoa(nome, sobrenome, idade, String.valueOf(cpf));
    }


    public static void exemplosBancos() {
        Banco santander = new Banco("Santander", "12345678000101", 123);
        Banco itau = new Banco("Itaú", "98765432000102", 456);
        Banco bradesco = new Banco("Bradesco", "11223344000103", 789);
        Banco bancoDoBrasil = new Banco("Banco do Brasil", "55443322000104", 987);
        Banco caixaEconomica = new Banco("Caixa Econômica Federal", "33221110000105", 654);

        System.out.println("5 bancos instanciados");
    }

    public static void exemplosContas() {
        Pessoa bruno = new Pessoa("Bruno", "Feijó", 29, "02406690050");
        ContaBancaria contaBancaria;
        //Conta Corrente
        contaBancaria = new ContaCorrente(bruno, BancosDisponiveis.getBanco(0), "123456");
        contaBancaria.deposito(200);
        contaBancaria = new ContaCorrente(bruno, BancosDisponiveis.getBanco(1), "123456");
        contaBancaria.deposito(200);
        contaBancaria = new ContaCorrente(bruno, BancosDisponiveis.getBanco(2), "123456");
        contaBancaria.deposito(200);
        contaBancaria = new ContaCorrente(bruno, BancosDisponiveis.getBanco(3), "123456");
        contaBancaria.deposito(200);
        contaBancaria = new ContaCorrente(bruno, BancosDisponiveis.getBanco(4), "123456");
        contaBancaria.deposito(200);

        Pessoa thais = new Pessoa("Thais", "Maciel", 26, "93495365211");
        contaBancaria = new ContaCorrente(thais, BancosDisponiveis.getBanco(0), "123456");
        contaBancaria.deposito(200);
        contaBancaria = new ContaCorrente(thais, BancosDisponiveis.getBanco(1), "123456");
        contaBancaria.deposito(200);
        contaBancaria = new ContaCorrente(thais, BancosDisponiveis.getBanco(2), "123456");
        contaBancaria.deposito(200);
        contaBancaria = new ContaCorrente(thais, BancosDisponiveis.getBanco(3), "123456");
        contaBancaria.deposito(200);
        contaBancaria = new ContaCorrente(thais, BancosDisponiveis.getBanco(4), "123456");
        contaBancaria.deposito(200);

        //Conta Poupança
        contaBancaria = new ContaPoupanca(bruno, BancosDisponiveis.getBanco(0), "123456");
        contaBancaria.deposito(200);
        contaBancaria = new ContaPoupanca(bruno, BancosDisponiveis.getBanco(1), "123456");
        contaBancaria.deposito(200);
        contaBancaria = new ContaPoupanca(bruno, BancosDisponiveis.getBanco(2), "123456");
        contaBancaria.deposito(200);
        contaBancaria = new ContaPoupanca(bruno, BancosDisponiveis.getBanco(3), "123456");
        contaBancaria.deposito(200);
        contaBancaria = new ContaPoupanca(bruno, BancosDisponiveis.getBanco(4), "123456");
        contaBancaria.deposito(200);

        contaBancaria = new ContaPoupanca(thais, BancosDisponiveis.getBanco(0), "123456");
        contaBancaria.deposito(200);
        contaBancaria = new ContaPoupanca(thais, BancosDisponiveis.getBanco(1), "123456");
        contaBancaria.deposito(200);
        contaBancaria = new ContaPoupanca(thais, BancosDisponiveis.getBanco(2), "123456");
        contaBancaria.deposito(200);
        contaBancaria = new ContaPoupanca(thais, BancosDisponiveis.getBanco(3), "123456");
        contaBancaria.deposito(200);
        contaBancaria = new ContaPoupanca(thais, BancosDisponiveis.getBanco(4), "123456");
        contaBancaria.deposito(200);


        System.out.println(bruno);
        System.out.println(thais);
    }
}
