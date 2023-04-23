package Ex3MenuComPOO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    }
    public static int menu(){
        Scanner entrada = new Scanner(System.in);

        System.out.println("Preencher o vetor com números aleatórios");
        System.out.println("Preencher o vetor com números aleatórios já ordenados");
        System.out.println("Informar maior e menor valor do vetor");

        return entrada.nextInt();
    }
}
