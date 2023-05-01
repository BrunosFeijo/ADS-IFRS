package Ex3MenuComPOO;

import java.util.Arrays;
import java.util.Random;

public class Vetor {
    private int[] vetor;
    private int tamanho;
    private boolean cheio;

    Vetor() {
        vetor = new int[10];
        tamanho = 0;
        cheio = false;
    }

    Vetor(int qtd) {
        vetor = new int[qtd];
        tamanho = 0;
        cheio = false;
    }

    public boolean preencherVetor() {
        Random valores = new Random();

        if (!cheio) {
            for (int i = tamanho; i < vetor.length; i++) {
                vetor[i] = valores.nextInt(100000) + 1;
            }
            tamanho = vetor.length;
            return (cheio = true);
        } else {
            System.out.println("Vetor já está cheio");
            return false;
        }
    }

    public boolean preencherVetorOrdenado() {
        if (preencherVetor()) {
            quickSort();
            return true;
        }
        return false;
    }

    public boolean inserirValor(int valor) {
        if (!cheio) {
            vetor[tamanho++] = valor;
            return true;
        }
        return false;
    }

    public boolean inserirValor(int valor, int posicao) {
        if (posicao >= tamanho || posicao < 0) {
            System.out.println("A posição é menor que 0 ou maior que o tamanho atual do vetor!");
            return false;
        }
        int valorAtual = vetor[posicao];

        vetor[posicao] = valor;
        System.out.println("A posição " + posicao + "foi alterada de " + valorAtual + " para " + valor);

        return true;
    }

    public int informarValorNaPosicao(int posicao) {
        if (posicao >= tamanho || posicao < 0) {
            System.out.println("A posição é menor que 0 ou maior que o tamanho atual do vetor!");
            return -1;
        }
        return vetor[posicao];
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getTamanhoMaximo() {
        return vetor.length;
    }

    public boolean removerValor(int valor) {
        int posicao = buscaBinaria(valor);
        if (posicao == -1) {
            System.out.println("Número não localizado!");
            return false;
        }
        vetor[posicao] = 0;

        for (int i = posicao; i < tamanho - 1; i++) {
            vetor[i] = vetor[i + 1];
        }
        tamanho--;
        return true;
    }

    public boolean removerValorDaPosicao(int posicao) {
        if (posicao >= tamanho || posicao < 0) {
            System.out.println("A posição é menor que 0 ou maior que o tamanho atual do vetor!");
            return false;
        }
        vetor[posicao] = 0;

        for (int i = posicao; i < tamanho - 1; i++) {
            vetor[i] = vetor[i + 1];
        }
        tamanho--;
        return true;
    }

    public int menorValor() {
        
        return 0;
    }

    public int maiorValor() {
        return 0;
    }

    public int buscaSequencial() {
        return 0;
    }

    public int buscaBinaria(int valor) {
        return 0;
    }

    public void bubbleSort() {

    }

    public void insertionSort() {

    }

    public void selectionSort() {

    }

    public void quickSort() {

    }

    @Override
    public String toString() {


        return "Vetor{" +
                "vetor=" + Arrays.toString(vetor) +
                '}';
    }
}
