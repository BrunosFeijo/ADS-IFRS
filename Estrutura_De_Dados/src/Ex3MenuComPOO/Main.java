package Ex3MenuComPOO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Vetor vetor = new Vetor(10000);
        int opcao = menu(vetor);

        while(opcao != 0){
            opcao = menu(vetor);
        }
        System.out.println("Fim do programa");

    }

    public static int opcao() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("---------------------------Menu---------------------------");
        System.out.println("01- Preencher o vetor com números aleatórios");
        System.out.println("02- Preencher o vetor com números aleatórios já ordenados");
        System.out.println("03- Informar a quantidade de elementos");
        System.out.println("04- Informar o maior e o menor valor existentes");
        System.out.println("05- Listar elementos");
        System.out.println("06- Inserir valor(por posição)");
        System.out.println("07- Inserir valor(próxima posição válida)");
        System.out.println("08- Apagar elemento (por posição)");
        System.out.println("09- Apagar elemento (por valor)");
        System.out.println("10- Consultar valor (busca sequencial)");
        System.out.println("11- Consultar valor (busca binária)");
        System.out.println("12- Ordenar vetor usando BubbleSort");
        System.out.println("13- Ordenar vetor usando InsetionSort");
        System.out.println("14- Ordenar vetor usando SelectionSort");
        System.out.println("15- Ordenar vetor usando QuickSort");
        System.out.println("16- Limpar vetor");
        System.out.println("00- Sair");
        System.out.println("----------------------------------------------------------");
        System.out.print("\nEscolha um opção: ");
        return entrada.nextInt();
    }

    public static int menu(Vetor vetor) {
        Scanner entrada = new Scanner(System.in);
        int op = opcao();
        int valor, posicao;

        if (op < 0 || op > 16) {
            System.out.println("Opção inválida! Tente novamente!");
            return -1;
        }

        switch (op) {
            case 1:
                vetor.preencherVetor();
                break;
            case 2:
                vetor.preencherVetorOrdenado();
                break;
            case 3:
                System.out.println("Este vetor possui " + vetor.getTamanho() + "elementos válidos");
                break;
            case 4:
                System.out.println("O menor valor é: " + vetor.menorValor() + "\n" +
                        "O maior valor é: " + vetor.maiorValor());
                break;
            case 5:
                System.out.println(vetor);
                break;
            case 6:
                System.out.print("\nInforme o valor a ser inserido: ");
                valor = entrada.nextInt();
                System.out.print("\nInforme a posição a ser subsituída: ");
                posicao = entrada.nextInt();
                vetor.inserirValor(valor, posicao);
                break;
            case 7:
                System.out.print("\nInforme o valor a ser inserido: ");
                valor = entrada.nextInt();
                vetor.inserirValor(valor);
                break;
            case 8:
                System.out.print("\nInforme a posição a ser removida: ");
                posicao = entrada.nextInt();
                vetor.removerValorDaPosicao(posicao);
                break;
            case 9:
                System.out.print("\nInforme o valor a ser removido: ");
                valor = entrada.nextInt();
                vetor.removerValor(valor);
                break;
            case 10:
                System.out.print("\nInforme o valor a ser buscado: ");
                valor = entrada.nextInt();
                posicao = vetor.buscaSequencial(valor);
                if (posicao == -1) {
                    System.out.println("Valor não encontrado");
                } else {
                    System.out.println("Valor encontrado na posição " + posicao);
                }
                break;
            case 11:
                System.out.print("\nInforme o valor a ser buscado: ");
                valor = entrada.nextInt();
                posicao = vetor.buscaBinaria(valor, 0, vetor.getTamanho() - 1);

                if (posicao == -1) {
                    System.out.println("Valor não encontrado");
                } else {
                    System.out.println("Valor encontrado na posição " + posicao);
                }
                break;
            case 12:
                if (!vetor.validarVetorOrdenado()) {
                    vetor.bubbleSort();
                    System.out.println("Vetor ordenado com sucesso");
                } else if (vetor.vazio()) {
                    System.out.println("Vetor vazio");
                } else {
                    System.out.println("Vetor já está ordenado");
                }
                break;
            case 13:
                if (!vetor.validarVetorOrdenado()) {
                    vetor.insertionSort();
                    System.out.println("Vetor ordenado com sucesso");
                } else if (vetor.vazio()) {
                    System.out.println("Vetor vazio");
                } else {
                    System.out.println("Vetor já está ordenado");
                }
                break;
            case 14:
                if (!vetor.validarVetorOrdenado()) {
                    vetor.selectionSort();
                    System.out.println("Vetor ordenado com sucesso");
                } else if (vetor.vazio()) {
                    System.out.println("Vetor vazio");
                } else {
                    System.out.println("Vetor já está ordenado");
                }
                break;
            case 15:
                if (!vetor.validarVetorOrdenado()) {
                    vetor.quickSort(0, vetor.getTamanho() - 1);
                    System.out.println("Vetor ordenado com sucesso");
                } else if (vetor.vazio()) {
                    System.out.println("Vetor vazio");
                } else {
                    System.out.println("Vetor já está ordenado");
                }
                break;
            case 16:
                if (vetor.limparVetor()){
                    System.out.println("Vetor vazio novamente");
                }else {
                    System.out.println("Vetor já está vazio");
                }
                break;
        }

        return op;
    }

}
