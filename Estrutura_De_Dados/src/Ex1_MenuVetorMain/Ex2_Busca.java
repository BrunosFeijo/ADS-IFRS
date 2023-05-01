package Ex1_MenuVetorMain;
//Monte um programa conforme descrito abaixo.
//
//1) Considerar que vetor terá tamanho 10.000 elementos e que só armazenará valores inteiros e positivos. Dessa forma,
// se houver ZERO no elemento do vetor, é considerado vazio.
//
//2) O programa deverá possuir as funcionalidades definidas no exercício anterior e mais a seguintes:
// a) inserir conteúdo no vetor a partir da geração de valores aleatórios já ordenados sequencialmente.
//
// b) mais uma funcionalidade de consulta, que utilize busca binária implementada com recursividade.
//
// c) uma opção de consulta comparando as duas formas de busca (sequencial e binária) que apresenta o número total
// de comparações realizado até o resultado da consulta( encontrado ou não, o valor ).

import java.util.Random;
import java.util.Scanner;

public class Ex2_Busca {
    static Scanner entrada = new Scanner(System.in);
    static int vetor[] = new int[10000];
    static int tamanho = 0;
    static int opcao = -1, valor = -1, indice;

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
                    System.out.print("Digite um valor a ser procurado no vetor: ");
                    valor = entrada.nextInt();
                    indice = procurarValor(valor);
                    System.out.println(indice == -1
                            ? "Valor não encontrado"
                            : "O valor procurado está no índice " + indice);
                    break;
                case 5://tamanho do vetor
                    setTamanho();
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
                case 9://preencher vetor com números aleatórios
                    preencherVetor();
                    break;
                case 10:
                    System.out.print("Digite o valor a ser procurado: ");
                    valor = entrada.nextInt();
                    indice = buscaBinaria(valor, 0, tamanho - 1);
                    System.out.println(indice == -1
                            ? "Valor não encontrado"
                            : "O valor procurado está no índice " + indice);
                    break;
                case 11:
                    System.out.print("Digite o valor a ser procurado: ");
                    valor = entrada.nextInt();
                    comparadorTempoExecucao(valor);
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
        System.out.println("9) Preencher vetor aleatóriamente");
        System.out.println("10) Buscar valor usando busca binária");
        System.out.println("11) Comparar Buscas <Sequencial -- Binária>");
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
        if (tamanho == 0) {
            System.out.println("Vetor vazio");
        } else {
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

    }

    public static int procurarValor(int valor) {
        for (int i = 0; i < tamanho; i++) {
            if (vetor[i] == valor) {
                return i;
            }
        }
        return -1;
    }
    public static void setTamanho(){
        if (tamanho == 0) {
            System.out.println("Vetor vazio");
        } else {
            System.out.println("Este vetor tem " + tamanho + " elementos preenchidos");
        }
    }

    public static void maiorValor() {
        if (tamanho == 0) {
            System.out.println("Vetor vazio");
        } else {
            int maior = vetor[0];
            int posicao = 0;
            for (int i = 1; i < tamanho; i++) {
                if (vetor[i] > maior) {
                    maior = vetor[i];
                    posicao = i;
                }
            }
            System.out.println("O maior valor é " + maior + " e está na posição " + posicao);
        }
    }

    public static void menorValor() {
        if (tamanho == 0) {
            System.out.println("Vetor vazio");
        } else {
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

    public static void preencherVetor() {
        Random random = new Random();
        if (tamanho == 0) {
            vetor[0] = random.nextInt(100);
            tamanho++;
        }
        while (vetor.length != tamanho) {
            vetor[tamanho] = vetor[tamanho - 1] + random.nextInt(100) + 1;
            tamanho++;
        }
    }

    public static int buscaBinaria(int procurado, int inicio, int fim) {
        int meio = (inicio + fim) / 2;

        if (fim >= inicio) {
            if (vetor[meio] == procurado) {
                return meio;
            } else if (vetor[meio] > procurado) {
                return buscaBinaria(procurado, inicio, meio - 1);
            } else {
                return buscaBinaria(procurado, meio + 1, fim);
            }
        }
        return -1;
    }

    public static void comparadorTempoExecucao(int valor) {
        double inicio = System.nanoTime();
        procurarValor(valor);
        double fim = System.nanoTime();
        System.out.println("A busca do valor " + valor + " na busca sequencial foi de " + (fim - inicio) + " ns");

        inicio = System.nanoTime();
        buscaBinaria(valor, 0, tamanho - 1);
        fim = System.nanoTime();

        System.out.println("A busca do valor " + valor + " na busca binária foi de " + (fim - inicio) + " ns");
    }


}
