package e_Metodos_Funcoes;

//Desenvolva um programa que leia 20 valores inteiros positivos e armazene-os em um vetor exatamente deste tamanho.
// Mostre a sequencia de valores do vetor na tela. Após, realize a trocas dos elementos do vetor da seguinte forma:
// o primeiro troca com o último, o segundo troca com o penúltimo, o terceiro troca com o antepenúltimo,
// e assim sucessivamente. Mostre o vetor na tela, depois das trocas. (Sem casos de teste)

//O programa deverá ser composto pelo método main, um método para leitura,
// um método para mostrar tod o vetor e outro método que efetua as trocas.

import java.util.Scanner;

public class M03_InverterSequencia {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int vetor[] = new int[20];

        for (int i = 0;i< vetor.length;i++){
            vetor[i] = teclado.nextInt();
        }
        mostrarVetor(vetor);
        System.out.println();

        inverterVetor(vetor);
        mostrarVetor(vetor);
    }

    public static void inverterVetor(int vetor[]) {
        int aux;
        for (int i = 0; i < (vetor.length / 2); i++) {
            aux = vetor[i];
            vetor[i] = vetor[vetor.length - i - 1];
            vetor[vetor.length - i - 1] = aux;
        }
    }
    public static void mostrarVetor(int vetor[]){
        for( int v:vetor){
            System.out.print("[" + v + "] ");
        }
    }
}
