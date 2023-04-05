package Exercicios;

import java.util.Random;
import java.util.Scanner;

public class Ex3_Busca_Ordenacao {
    static Scanner entrada = new Scanner(System.in);
    static int vetor[] = new int[10000];
    static int tamanho = 0;
    static int opcao = -1, valor = -1, indice;
    static boolean vetorOrdenado = false;

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
                    vetor = preencherVetorJaOrdenado();
                    break;
                case 10:
                    if (validarVetorOrdenado()) {
                        System.out.print("Digite o valor a ser procurado: ");
                        valor = entrada.nextInt();
                        indice = buscaBinaria(valor, 0, tamanho - 1);
                        System.out.println(indice == -1
                                ? "Valor não encontrado"
                                : "O valor procurado está no índice " + indice);
                    } else {
                        System.out.println("Vetor não está ordenado. Refaça a operação");
                    }

                    break;
                case 11:
                    if (validarVetorOrdenado()) {
                        System.out.print("Digite o valor a ser procurado: ");
                        valor = entrada.nextInt();
                        comparadorTempoExecucao(valor);
                    } else {
                        System.out.println("Vetor não está ordenado. Refaça a operação");
                    }

                    break;
                case 12:
                    vetor = preencherVetorNaoOrdenado(vetor.length);
                    break;
                case 13:
                    darRetornoDeVetorOrdenado();
                    break;
                case 14:
                    break;
                case 15:
                    System.out.println("Foram feitas " + selectionSort() + " iterações");
                    break;
            }
        }
        System.out.println("Fim do Programa");
    }

    public static int menu() {
        int opcao;
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
        System.out.println("12) Preencher vetor não ordenado");
        System.out.println("13) Verificar se vetor está ordenado");
        System.out.println("14) Comparar métodos de ordenação");
        System.out.println("15) Ordenar Vetor");
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

    public static void setTamanho() {
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

    public static int[] preencherVetorJaOrdenado() {
        Random random = new Random();
        int[] v = new int[vetor.length];
        if (tamanho == 0) {
            v[0] = random.nextInt(100);
            tamanho++;
        } else {
            if (tamanho > 0) System.arraycopy(vetor, 0, v, 0, tamanho);
        }
        while (v.length != tamanho) {
            v[tamanho] = v[tamanho - 1] + random.nextInt(100) + 1;
            tamanho++;
        }

        return v;
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

    public static int[] preencherVetorNaoOrdenado(int qtd) {
        Random valores = new Random(100);
        int[] v = new int[qtd];
        while (tamanho < qtd) {
            v[tamanho] = valores.nextInt(10000) + 1;
            tamanho++;
        }
        return v;
    }

    public static boolean validarVetorOrdenado() {
        for (int i = 0; i < tamanho - 1; i++) {
            if (vetor[i] > vetor[i + 1] || vetor[0] == 0) {
                return false;
            }
        }

        return true;
    }

    public static void darRetornoDeVetorOrdenado() {
        if (validarVetorOrdenado()) {
            System.out.println("Vetor está ordenado");
        } else {
            System.out.println("Vetor não está ordenado");
        }
    }

    public static int selectionSort() {
        int iteradorTrocas = 0;
        boolean aindaNaoOrdenado = true;
        int menor;

        for (int i = 0; i < tamanho; i++) {
            menor = i;
            for (int j = i + 1; j < tamanho; j++) {
                if (vetor[menor] > vetor[j]) {
                    menor = j;
                    iteradorTrocas++;
                }
            }
            trocarElementos(vetor, i, menor);
        }
        return iteradorTrocas;
    }

    public static int[] insertionSort() {
        int[] v = new int[0];

        return v;
    }

    public static int[] quickSort() {
        int[] v = new int[0];

        return v;
    }
    public static void zerarVetorEPreencherNumerosFixos(){
        zerarVetor();
        preencherVetorNaoOrdenado(vetor.length);
    }

    public static int bubbleSort() {
        int iteradorTrocas = 0;
        boolean aindaNaoOrdenado = true;

        for (int ultimo = tamanho - 1; aindaNaoOrdenado && ultimo > 0; ultimo--) {
            aindaNaoOrdenado = false;
            for (int i = 0; i < ultimo; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    trocarElementos(vetor, i, i + 1);
                    iteradorTrocas++;
                    aindaNaoOrdenado = true;
                }
            }
        }

        return iteradorTrocas;
    }

    public static void trocarElementos(int[] vetor, int i, int j) {
        int aux = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = aux;
    }

    public static void compararOrdenadores() {
        StringBuilder stringBuilder = new StringBuilder();

        zerarVetorEPreencherNumerosFixos();
        stringBuilder.append("BubbleSort fez ").append(bubbleSort()).append(" trocas/iterações.\n");
        zerarVetorEPreencherNumerosFixos();
        stringBuilder.append("SelectionSort fez ").append(selectionSort()).append(" trocas/iterações.\n");
        zerarVetorEPreencherNumerosFixos();
        stringBuilder.append("InsertionSort fez ").append(insertionSort()).append(" trocas/iterações.\n");
        zerarVetorEPreencherNumerosFixos();
        stringBuilder.append("QuickSort fez ").append(quickSort()).append(" trocas/iterações.\n");

        System.out.println(stringBuilder.toString());
    }
}
