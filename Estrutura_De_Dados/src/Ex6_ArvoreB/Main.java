package Ex6_ArvoreB;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArvoreB arvoreB = new ArvoreB();

        int opcao = 0;
        do {
            System.out.print("Digite um opção: ");
            opcao = entrada.nextInt();
            switch (opcao) {
                case 0 -> System.out.println("Programa finalizado!!");
                case 1 -> {
                    System.out.println("Digite um valor para adicionar");
                    int valor = entrada.nextInt();
                    arvoreB.inserir(valor);
                }
                case 2 -> {
                    System.out.println("Digite um valor para excluir");
                    int valor = entrada.nextInt();
                    arvoreB.remove(valor);
                }
                case 3 -> {
                    System.out.println("Digite um valor para consultar");

                }
                case 4 -> {
                    arvoreB.limpar();
                    System.out.println("Árvore zerada!!");
                }
                case 5 -> arvoreB.imprimirNaOrdem();
                default -> System.out.println("Opção inválida");
            }
        } while (opcao != 0);


    }

    public static void menu() {
        System.out.println("|-------------Menu-------------|");
        System.out.println("1- Inserir valor");
        System.out.println("2- Excluir valor");
        System.out.println("3- Verificar se contém valor");
        System.out.println("4- Limpar Árvore");
        System.out.println("5- Listar Árvore");
        System.out.println("0- Sair");
        System.out.println("|------------------------------|");
    }
}
