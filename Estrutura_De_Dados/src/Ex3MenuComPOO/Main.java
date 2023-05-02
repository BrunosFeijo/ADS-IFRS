package Ex3MenuComPOO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

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
            case 2:
                vetor.preencherVetorOrdenado();
            case 3:
                System.out.println("Este vetor possui " + vetor.getTamanho() + "elementos válidos");
            case 4:
                System.out.println("O menor valor é: " + vetor.menorValor() + "\n" +
                        "O maior valor é: " + vetor.maiorValor());
            case 5:
                System.out.println(vetor);
            case 6:
                System.out.print("\nInforme o valor a ser inserido: ");
                valor = entrada.nextInt();
                System.out.print("\nInforme a posição a ser subsituída: ");
                posicao = entrada.nextInt();
                vetor.inserirValor(valor, posicao);
            case 7:
                System.out.print("\nInforme o valor a ser inserido: ");
                valor = entrada.nextInt();
                vetor.inserirValor(valor);
            case 8:
                System.out.print("\nInforme a posição a ser removida: ");
                posicao = entrada.nextInt();
                vetor.removerValorDaPosicao(posicao);
            case 9:
                System.out.print("\nInforme o valor a ser removido: ");
                valor = entrada.nextInt();
                vetor.removerValor(valor);
            case 10:
                System.out.print("\nInforme o valor a ser buscado: ");
                valor = entrada.nextInt();
                vetor.buscaSequencial(valor);
            case 11:
                System.out.print("\nInforme o valor a ser buscado: ");
                valor = entrada.nextInt();
                vetor.buscaBinaria(valor, 0, vetor.getTamanho() - 1);

            case 12:
            case 13:
            case 14:
            case 15:
        }

        return op;
    }

}
