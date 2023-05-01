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
        if (!cheio && valor != 0) {
            vetor[tamanho++] = valor;
            return true;
        }
        System.out.println("Vetor está cheio ou valor é igual a 0!");
        return false;
    }

    public boolean inserirValor(int valor, int posicao) {
        if (posicao >= tamanho || posicao < 0 || valor == 0) {
            System.out.println("A posição é menor que 0, maior que o tamanho atual do vetor ou o valor é igual a 0!");
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
        int posicao = buscaBinaria(valor, 0, tamanho -1);
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
        if (tamanho == 0){
            System.out.println("Vetor está vazio");
            return 0;
        }
        int menor = vetor[0];
        for (int i = 0; i < tamanho;i++){
            if (menor > vetor[i]){
                menor = vetor[i];
            }
        }
        return menor;
    }

    public int maiorValor() {
        if (tamanho == 0){
            System.out.println("Vetor está vazio");
            return 0;
        }
        int maior = vetor[0];
        for (int i = 0; i < tamanho;i++){
            if (maior < vetor[i]){
                maior = vetor[i];
            }
        }
        return maior;
    }

    public int buscaSequencial(int valor) {
        for (int i = 0; i < tamanho; i++){
            if (valor == vetor[i]){
                return i;
            }
        }
        return (vetor[0] == valor ? 0 : -1);
    }

    public int buscaBinaria(int valor, int inicio, int fim) {
        if(!validarVetorOrdenado()){
            System.out.println("Vetor não está ordenado");
            return -1;
        }

        int meio = (inicio + fim) / 2;

        if (fim >= inicio) {
            if (vetor[meio] == valor) {
                return meio;
            } else if (vetor[meio] > valor) {
                return buscaBinaria(valor, inicio, meio - 1);
            } else {
                return buscaBinaria(valor, meio + 1, fim);
            }
        }
        return -1;
    }
    public boolean validarVetorOrdenado() {
        for (int i = 0; i < tamanho - 1; i++) {
            if (vetor[i] > vetor[i + 1] || vetor[0] == 0) {
                return false;
            }
        }
        return true;
    }
    public int trocarElementos(int i, int j) {
        int aux = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = aux;

        return 1;
    }

    public int bubbleSort() {
        if (tamanho == 0){
            System.out.println("Vetor vazio");
            return 0;
        }
        int iteradorTrocas = 0;
        boolean aindaNaoOrdenado = true;

        for (int ultimo = tamanho - 1; aindaNaoOrdenado && ultimo > 0; ultimo--) {
            aindaNaoOrdenado = false;
            for (int i = 0; i < ultimo; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    iteradorTrocas += trocarElementos(i, i + 1);
                    aindaNaoOrdenado = true;
                }
            }
        }
        return iteradorTrocas;
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
