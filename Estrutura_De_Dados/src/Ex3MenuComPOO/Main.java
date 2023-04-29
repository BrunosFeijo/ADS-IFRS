package Ex3MenuComPOO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    }
    public static int menu(){
        Scanner entrada = new Scanner(System.in);

        System.out.println("1- Preencher o vetor com números aleatórios");
        System.out.println("2- Preencher o vetor com números aleatórios já ordenados");
        System.out.println("3- Informar a quantidade de elementos");
        System.out.println("4- Informar o maior e o menor valor existentes");
        System.out.println("5- Listar elementos");
        System.out.println("6- Inserir valor(por posição)");
        System.out.println("7- Apagar elemento (por valor)");
        System.out.println("8- Apagar elemento (por posição)");
        System.out.println("9- Consultar valor (busca sequencial)");
        System.out.println("10- Consultar valor (busca binária)");
        System.out.println("11- Ordenar vetor usando BubbleSort");
        System.out.println("12- Ordenar vetor usando InsetionSort");
        System.out.println("13- Ordenar vetor usando SelectionSort");
        System.out.println("14- Ordenar vetor usando QuickSort");
        System.out.println("15- Limpar vetor");

        return entrada.nextInt();
    }
}
