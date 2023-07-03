package Ex7_SistemaBancario;

import java.util.Scanner;

public class Main {
    static int valor = 3;
    public static void main(String[] args) {
        exemplosBancos();
        System.out.println(BancosDisponiveis.getBanco(0));
    }
    public static void exemplosBancos(){
        Banco santander = new Banco("Santander", "12345678000101", 123);
        Banco itau = new Banco("Itaú", "98765432000102", 456);
        Banco bradesco = new Banco("Bradesco", "11223344000103", 789);
        Banco bancoDoBrasil = new Banco("Banco do Brasil", "55443322000104", 987);
        Banco caixaEconomica = new Banco("Caixa Econômica Federal", "33221110000105", 654);

        System.out.println("5 bancos instanciados");
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
        System.out.println("0 - Sair");
        System.out.println("--------------------------------------");
        System.out.print("Digite uma opção: ");
        while(opcao < 0 || opcao > 8){
            opcao = entrada.nextInt();
            if (opcao < 0 || opcao > 8) System.out.println("Opção inválida!");
        }

        return 0;
    }

}
