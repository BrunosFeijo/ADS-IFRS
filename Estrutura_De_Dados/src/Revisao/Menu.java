package Revisao;

//O programa deverá possuir um menu de alternativas para que o usuário escolha o que deve ser realizado,
// conforme sugestão abaixo:
//
//1) criar o vetor vazio ou "zerar o vetor"
//2) inserir um valor no vetor - utilizando uma estratégia para que o próximo elemento vazio receba este novo valor
//3) apagar um valor do vetor - indicando o valor e procurar qual o elemento que deverá ser "zerado"
//4) consultar se existe determinado valor no vetor - para saber qual o elemento que contém esse valor
//5) consultar quantos valores significativos já ocupam o vetor
//6) consultar qual o maior valor armazenado no vetor e indicar qual o elemento que contém esse valor
//7) consultar qual o menor valor armazenado no vetor e indicar qual o elemento que contém esse valor
//8) apresentar uma listagem dos valores armazenados no vetor
//0) sair do programa

import java.util.Scanner;

public class Menu {
    static int vetor[] = new int[20];
    static int tamanho = 0;
    static int opcao = -1, valor = -1;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);


        while (opcao != 0) {
            opcao = menu(entrada);
            switch (opcao) {
                case 1: // zerar vetor
                    for (int i = 0; i < tamanho; i++) {
                        vetor[i] = 0;
                    }
                case 2: // inserir valor
                    System.out.print("Digite um valor a ser armazenado no vetor: ");
                    vetor[tamanho++] = entrada.nextInt();
                case 3://apagar valor
                    System.out.print("Digite o valor a ser apagado do vetor: ");
                    valor = entrada.nextInt();
                    for (int i = 0; i < tamanho; i++) {
                        if (vetor[i] == valor) {
                            vetor[i] = 0;
                            System.out.println("Valor " + valor + " foi apagado do índice " + i);
                            i = tamanho;
                            tamanho--;
                        }
                        if (i == tamanho - 1) {
                            System.out.println("Valor não encontrado");
                        }
                    }
                case 4://procurar valor
                    System.out.print("Digite um valor a ser procurado no vetor");
                    valor = entrada.nextInt();
                    for (int i = 0; i < tamanho; i++) {
                        if (vetor[i] == valor) {
                            System.out.println("O valor procurado está no índice " + i);
                            i = tamanho;
                        }
                        if (i == tamanho - 1) {
                            System.out.println("Valor não encontrado");
                        }
                    }
                case 5://tamanho do vetor
                    System.out.println("Este vetor tem " + tamanho + " elementos preenchidos");
                case 6://maior valor
                    maiorValor();
                case 7://menor valor

                case 8://listar vetor

            }
        }
        System.out.println("Fim do Programa");

    }

    public static int menu(Scanner entrada) {
        int opcao = 0;
        System.out.println("------------------------Menu----------------------");
        System.out.println("1) Zerar vetor");
        System.out.println("2) Inserir um valor no vetor");
        System.out.println("3) Apagar um valor do vetor");
        System.out.println("4) Consultar índice atravez de um valor existente");
        System.out.println("5) Consultar tamanho do vetor");
        System.out.println("6) Consultar maior valor");
        System.out.println("7) Consultar menor valor");
        System.out.println("8) Exibir valores");
        System.out.println("0) Sair");
        System.out.println("---------------------------------------------------");

        opcao = entrada.nextInt();

        return opcao;
    }

    public static void maiorValor() {
        int maior = vetor[0];
        for (int i = 0; i < tamanho; i++) {
            
        }
    }


}
