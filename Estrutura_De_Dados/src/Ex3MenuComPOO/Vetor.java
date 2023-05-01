package Ex3MenuComPOO;

import java.util.Arrays;
import java.util.Random;

public class Vetor {
    private int[] vetor;
    private int tamanho;
    private boolean cheio = false;

    Vetor() {
        vetor = new int[10];
        tamanho = 0;
    }

    Vetor(int qtd) {
        vetor = new int[qtd];
        tamanho = 0;
    }

    public boolean preencherVetor() {
        Random valores = new Random();
        for (int i = tamanho; i < vetor.length; i++) {
            vetor[i] = valores.nextInt(100000) + 1;
            cheio = true;
        }

        tamanho = vetor.length;

        return cheio;
    }

    public boolean preencherVetorOrdenado() {
        preencherVetor();
        quickSort();

        return cheio;
    }

    public void inserirValor(int valor) {
        
    }

    public void inserirValor(int valor, int posicao) {

    }

    public int informarValorNaPosicao() {

        return 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getTamanhoMaximo() {
        return vetor.length;
    }

    public void removerValor(int valor) {

    }

    public void removerValorDaPosicao(int posicao) {

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

    public int buscaBinaria() {
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
