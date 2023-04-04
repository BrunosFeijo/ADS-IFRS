package Exercicios;

import java.util.Random;

public class VetorAleatorio {
    Random valores = new Random();

    public VetorAleatorio() {
    }

    public int[] preencherVetor(int qtd) {
        int[] v = new int[qtd];
        for (int i = 0; i < qtd; i++) {
            v[i] = valores.nextInt(100);
        }
        return v;
    }
}
