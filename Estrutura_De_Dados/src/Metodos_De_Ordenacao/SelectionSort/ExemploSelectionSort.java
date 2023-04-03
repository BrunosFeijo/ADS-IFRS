package Metodos_De_Ordenacao.SelectionSort;

import Metodos_De_Ordenacao.VetorAleatorio;

import java.util.Arrays;

public class ExemploSelectionSort {
    public static void main(String[] args) {
        VetorAleatorio vetorAleatorio = new VetorAleatorio();
        int[] vetor = vetorAleatorio.preencherVetor(10);
        System.out.println(Arrays.toString(vetor));

        selectionSort(vetor);

        System.out.println(Arrays.toString(vetor));
    }

    public static void selectionSort(int[] vetor) {
        int menor;
        for (int i = 0; i < vetor.length; i++) {
            menor = i;
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[menor] > vetor[j]) {
                    menor = j;
                }
            }
            trocarIndices(vetor, i, menor);
        }
    }

    public static void trocarIndices(int[] vetor, int i, int menor) {
        int aux = vetor[i];
        vetor[i] = vetor[menor];
        vetor[menor] = aux;
    }
}
