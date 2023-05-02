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
            System.out.println("Vetor preenchido com sucesso!");
            return (cheio = true);
        } else {
            System.out.println("Vetor já está cheio");
            return false;
        }
    }

    public boolean preencherVetorOrdenado() {
        if (preencherVetor()) {
            quickSort(0, tamanho - 1);
            return true;
        }
        return false;
    }

    public boolean inserirValor(int valor) {
        if (!cheio && valor != 0) {
            vetor[tamanho++] = valor;
            System.out.println("Valor inserido com sucesso");
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
        System.out.println("A posição " + posicao + " foi alterada de " + valorAtual + " para " + valor);

        return true;
    }

    public int informarValorNaPosicao(int posicao) {
        if (posicao >= tamanho || posicao < 0) {
            System.out.println("A posição é menor que 0 ou maior que o tamanho atual do vetor!");
            return -1;
        }
        System.out.println("Valor encontrado na posição: " + vetor[posicao]);
        return vetor[posicao];
    }

    public int getTamanho() {
        return tamanho;
    }
    public boolean vazio(){
        return tamanho == 0;
    }

    public int getTamanhoMaximo() {
        return vetor.length;
    }

    public boolean removerValor(int valor) {
        int posicao = buscaBinaria(valor, 0, tamanho - 1);
        if (posicao == -1) {
            System.out.println("Número não localizado!");
            return false;
        }
        vetor[posicao] = 0;

        for (int i = posicao; i < tamanho - 1; i++) {
            vetor[i] = vetor[i + 1];
        }
        tamanho--;
        System.out.println("Valor removido com sucesso");
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
        System.out.println("Posição removido com sucesso");
        return true;
    }

    public int menorValor() {
        if (tamanho == 0) {
            System.out.println("Vetor está vazio");
            return 0;
        }
        int menor = vetor[0];
        for (int i = 0; i < tamanho; i++) {
            if (menor > vetor[i]) {
                menor = vetor[i];
            }
        }
        return menor;
    }

    public int maiorValor() {
        if (tamanho == 0) {
            System.out.println("Vetor está vazio");
            return 0;
        }
        int maior = vetor[0];
        for (int i = 0; i < tamanho; i++) {
            if (maior < vetor[i]) {
                maior = vetor[i];
            }
        }
        return maior;
    }

    public int buscaSequencial(int valor) {
        for (int i = 0; i < tamanho; i++) {
            if (valor == vetor[i]) {
                return i;
            }
        }

        return (vetor[0] == valor ? 0 : -1);
    }

    public int buscaBinaria(int valor, int inicio, int fim) {
        if (!validarVetorOrdenado()) {
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
        if (tamanho == 0) {
            return -1;
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

    public int insertionSort() {
        if (tamanho == 0) {
            return -1;
        }
        int iteradorTrocas = 0;
        boolean aindaNaoOrdenado = true;

        for (int i = 1; i < tamanho; i++) {
            int valor = vetor[i];
            int j = i - 1;

            for (; j >= 0 && vetor[j] > valor; j--) {
                vetor[j + 1] = vetor[j];
                iteradorTrocas++;
            }
            vetor[j + 1] = valor;
        }

        return iteradorTrocas;
    }

    public int selectionSort() {
        if (tamanho == 0) {
            return -1;
        }
        int iteradorTrocas = 0;
        boolean aindaNaoOrdenado = true;
        int menor;

        for (int i = 0; i < tamanho; i++) {
            menor = i;
            aindaNaoOrdenado = false;
            for (int j = i + 1; j < tamanho; j++) {
                if (vetor[menor] > vetor[j]) {
                    menor = j;
                    aindaNaoOrdenado = true;
                    iteradorTrocas++;
                }
            }
            if (aindaNaoOrdenado) iteradorTrocas += trocarElementos(i, menor);
        }
        return iteradorTrocas;
    }

    public int quickSort(int menor, int maior) {
        if (tamanho == 0) {
            return -1;
        }
        int iteradorTrocas = 0;
        if (menor < maior) {

            int pivo = vetor[maior];
            int i = menor - 1;

            for (int j = menor; j < maior; j++) {
                if (vetor[j] <= pivo) {
                    i++;
                    iteradorTrocas += trocarElementos(i, j);
                }
            }

            int aux = vetor[i + 1];
            vetor[i + 1] = pivo;
            vetor[maior] = aux;

            iteradorTrocas += quickSort(menor, i);
            iteradorTrocas += quickSort(i + 2, maior);
        }
        return iteradorTrocas;
    }
    public boolean limparVetor(){
        if (vazio()) return false;

        tamanho = 0;
        cheio = false;

        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (tamanho != 0) {
            for (int i = 0; i <= tamanho - 1; i++) {
                stringBuilder.append("[").append(i).append("] = ").append(vetor[i]).append("\n");
            }
        } else {
            stringBuilder.append("Vetor vazio");
        }

        return stringBuilder.toString();
    }
}
