package Metodos_De_Ordenacao;

import java.util.Arrays;
import java.util.Random;

public class VetorAleatorio {
    int[] vetor;
    Random valores = new Random();

    public VetorAleatorio(int qtd){
        vetor = new int[qtd];
        for (int i = 0; i<qtd;i++){
            vetor[i] = valores.nextInt(100);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (int i = 0; i < vetor.length-1;i++){
            stringBuilder.append(vetor[i]).append(", ");
        }
        stringBuilder.append(vetor[vetor.length-1]).append("}");
        return stringBuilder.toString();
    }
}
