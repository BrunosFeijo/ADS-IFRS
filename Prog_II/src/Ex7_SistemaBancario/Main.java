package Ex7_SistemaBancario;

import java.util.Scanner;

public class Main {
    static int valor = 3;
    public static void main(String[] args) {
        int opcao;
        exemplosBancos();
        exemplosContas();


//        do{
//            opcao = menu();
//            switch (opcao){
//                case 1 ->
//                case 2 ->
//                case 3 ->
//                case 4 ->
//                case 5 ->
//                case 6 ->
//                case 7 ->
//                case 8 ->
//                case 9 -> {
//                    exemplosBancos();
//                }
//            }
//
//        }while(opcao != 0);



    }
    public static int menu(){
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
        while(opcao < 0 || opcao > 8){
            opcao = entrada.nextInt();
            if (opcao < 0 || opcao > 8) System.out.println("Opção inválida!");
        }
        return opcao;
    }
    public static void exemplosBancos(){
        Banco santander = new Banco("Santander", "12345678000101", 123);
        Banco itau = new Banco("Itaú", "98765432000102", 456);
        Banco bradesco = new Banco("Bradesco", "11223344000103", 789);
        Banco bancoDoBrasil = new Banco("Banco do Brasil", "55443322000104", 987);
        Banco caixaEconomica = new Banco("Caixa Econômica Federal", "33221110000105", 654);

        System.out.println("5 bancos instanciados");
    }
    public static void exemplosContas(){
        Pessoa bruno = new Pessoa("Bruno","Feijó",29,"02406690050");
        ContaBancaria contaBancaria;
        //Conta Corrente
        contaBancaria = new ContaCorrente(bruno,BancosDisponiveis.getBanco(0),"123456");
        contaBancaria.deposito(200);
        contaBancaria = new ContaCorrente(bruno,BancosDisponiveis.getBanco(1),"123456");
        contaBancaria.deposito(200);
        contaBancaria = new ContaCorrente(bruno,BancosDisponiveis.getBanco(2),"123456");
        contaBancaria.deposito(200);
        contaBancaria = new ContaCorrente(bruno,BancosDisponiveis.getBanco(3),"123456");
        contaBancaria.deposito(200);
        contaBancaria = new ContaCorrente(bruno,BancosDisponiveis.getBanco(4),"123456");
        contaBancaria.deposito(200);

        Pessoa thais = new Pessoa("Thais","Maciel",26,"93495365211");
        contaBancaria = new ContaCorrente(thais,BancosDisponiveis.getBanco(0),"123456");
        contaBancaria.deposito(200);
        contaBancaria = new ContaCorrente(thais,BancosDisponiveis.getBanco(1),"123456");
        contaBancaria.deposito(200);
        contaBancaria = new ContaCorrente(thais,BancosDisponiveis.getBanco(2),"123456");
        contaBancaria.deposito(200);
        contaBancaria = new ContaCorrente(thais,BancosDisponiveis.getBanco(3),"123456");
        contaBancaria.deposito(200);
        contaBancaria = new ContaCorrente(thais,BancosDisponiveis.getBanco(4),"123456");
        contaBancaria.deposito(200);

        //Conta Poupança


        System.out.println(bruno);
        System.out.println(thais);
    }
}
