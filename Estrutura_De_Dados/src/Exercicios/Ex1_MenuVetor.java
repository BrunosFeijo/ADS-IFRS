package Exercicios;

import java.util.Scanner;

public class Ex1_MenuVetor {
    static Scanner entrada = new Scanner(System.in);
    static int vetor[] = new int[20];
    static int tamanho = 0;
    static int opcao = -1, valor = -1;

    public static void main(String[] args) {


        while (opcao != 0) {
            opcao = menu();
            switch (opcao) {
                case 1: // zerar vetor
                    zerarVetor();
                    System.out.println("Vetor Zerado");
                    break;
                case 2: // inserir valor
                    adicionarValor();
                    System.out.println("Valor adicionado");
                    break;
                case 3://apagar valor
                    apagarValor();
                    break;
                case 4://procurar valor
                    procurarValor();
                    break;
                case 5://tamanho do vetor
                    System.out.println("Este vetor tem " + tamanho + " elementos preenchidos");
                    break;
                case 6://maior valor
                    maiorValor();
                    break;
                case 7://menor valor
                    menorValor();
                    break;
                case 8://listar vetor
                    listarVetor();
                    break;
            }
        }
        System.out.println("Fim do Programa");
    }

    public static int menu() {
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

    public static void zerarVetor() {
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = 0;
        }
        tamanho = 0;
    }

    public static void adicionarValor() {
        System.out.print("Digite um valor a ser armazenado no vetor: ");
        vetor[tamanho++] = entrada.nextInt();
    }

    public static void apagarValor() {
        System.out.print("Digite o valor a ser apagado do vetor: ");
        valor = entrada.nextInt();
        for (int i = 0; i < tamanho; i++) {
            if (vetor[i] == valor) {
                vetor[i] = 0;
                System.out.println("Valor " + valor + " foi apagado do índice " + i);
                for (int j = i; j < tamanho - 1; j++) {
                    vetor[j] = vetor[j + 1];
                }
                i = tamanho;
                tamanho--;


            }
            if (i == tamanho - 1) {
                System.out.println("Valor não encontrado");
            }
        }

    }

    public static void procurarValor() {
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
    }

    public static void maiorValor() {
        int maior = vetor[0];
        int posicao = 0;
        for (int i = 1; i < tamanho; i++) {
            if (vetor[i] > maior) {
                maior = vetor[i];
                posicao =i;
            }
        }
        System.out.println("O maior valor é " + maior + " e está na posição " + posicao);
    }

    public static void menorValor() {
        int menor = vetor[0];
        int posicao = 0;
        for (int i = 1; i < tamanho; i++) {
            if (vetor[i] < menor) {
                menor = vetor[i];
                posicao = i;
            }
        }
        System.out.println("O maior valor é " + menor + " e está na posição " + posicao);
    }

    public static void listarVetor() {
        if (tamanho > 0) {
            for (int i = 0; i < tamanho; i++) {
                System.out.println("[" + i + "] = " + vetor[i]);
            }
        } else {
            System.out.println("Vetor vazio");
        }
    }


}