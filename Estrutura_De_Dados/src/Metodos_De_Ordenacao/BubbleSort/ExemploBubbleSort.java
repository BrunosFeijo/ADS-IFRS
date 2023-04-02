package Metodos_De_Ordenacao.BubbleSort;

import java.util.Arrays;

public class ExemploBubbleSort {
    public static void main(String[] args) {
        int vetor[] = {5,13,2,78,89,22,10,15,3,0,17,30};
        bubbleSort(vetor);
        System.out.println(Arrays.toString(vetor));
    }
    public static void bubbleSort(int[] vetor){
        for (int ultimo = vetor.length-1; ultimo > 0 ; ultimo--){
            for (int i = 0; i < ultimo; i++){
                if (vetor[i] > vetor[i+1]) {
                    trocarElementos(vetor,i,i+1);
                }
            }
        }
    }
    public static void trocarElementos(int [] vetor,int i, int j){
        int aux = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = aux;
    }
}
