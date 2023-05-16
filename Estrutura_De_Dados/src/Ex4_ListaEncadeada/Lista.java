package Ex4_ListaEncadeada;

public class Lista {
    private No inicio;
    private No fim;
    private int tamanho;

    public Lista() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    public boolean isVazio() {
        return tamanho == 0;
    }

    private void adicionarNoInicio(int valor) {
        No novoNo = new No(valor);
        if (isVazio()) {
            inicio = fim = novoNo;
        } else {
            novoNo.setAnterior(null); // apenas para tornar explícito
            novoNo.setProximo(inicio);
            inicio.setAnterior(novoNo);
            inicio = novoNo;
        }
        tamanho++;
    }

    private void adicionaNoFinal(int valor) {
        No novoNo = new No(valor);
        if (isVazio()) {
            inicio = fim = novoNo;
        } else {
            novoNo.setAnterior(fim);
            novoNo.setProximo(null); // apenas para tornar explícito
            fim.setProximo(novoNo);
            fim = novoNo;
        }
        tamanho++;
    }

    private void adicionaNoMeio(No noAtual, No novoNo) {
        //apontar novo nó para o nó anterior e o nó posterior
        novoNo.setAnterior(noAtual.getAnterior());
        novoNo.setProximo(noAtual);
        //apontar o nó anterior para o novo nó
        noAtual.getAnterior().setProximo(novoNo);
        //apontar o nó atual para o novo nó
        noAtual.setAnterior(novoNo);
        tamanho++;
    }

    public void adicionaEmOrdemCrescente(int valor) {
        No novoNo = new No(valor);
        if (isVazio()) {
            inicio = fim = novoNo;
            tamanho++;
        } else if (novoNo.getValor() <= inicio.getValor()) {
            adicionarNoInicio(valor);
        } else if (novoNo.getValor() >= fim.getValor()) {
            adicionaNoFinal(valor);
        } else {
            No noAux = inicio;
            while (noAux.getValor() <= novoNo.getValor()) {
                noAux = noAux.getProximo();
            }
            adicionaNoMeio(noAux, novoNo);
        }
    }

    private int removeDoInicio() {
        int valorRemovido = inicio.getValor();
        if (tamanho != 1) {
            inicio.getProximo().setAnterior(null);
            inicio = inicio.getProximo();
        } else {
            inicio = fim = null;
        }
        tamanho--;
        return valorRemovido;
    }

    private int removeDoFim() {
        int valorRemovido = fim.getValor();
        if (tamanho != 1) {
            fim.getAnterior().setProximo(null);
            fim = fim.getAnterior();
        } else {
            inicio = fim = null;
        }
        tamanho--;
        return valorRemovido;
    }

    private int removeDoMeio(No noAtual) {
        int valorRemovido = noAtual.getValor();
        //apontar o nó anterior para o próximo
        noAtual.getAnterior().setProximo(noAtual.getProximo());
        //apontar o próximo nó para o anterior
        noAtual.getProximo().setAnterior(noAtual.getAnterior());
        //tornar nó null
        noAtual = null;
        tamanho--;
        return valorRemovido;
    }

    public int removerPorValor(int valor) {
        if (isVazio()) {
            System.out.println("Lista Vazia");
            return -1;
        }
        if (valor == inicio.getValor()) {
            return removeDoInicio();
        } else if (valor == fim.getValor()) {
            return removeDoFim();
        }
        No noAux = inicio.getProximo();
        for (int i = 1; i < tamanho; i++) {
            if (noAux.getValor() == valor) return removeDoMeio(noAux);
            noAux = noAux.getProximo();
        }
        System.out.println("Valor " + valor + " não encontrado");
        return -1;
    }

    public int removerPorIndice(int indice) {
        if (isVazio()) {
            System.out.println("Lista Vazia");
            return -1;
        }
        if (indice < 0 || indice >= tamanho) {
            System.out.println("Índice inválido");
            return -1;
        }
        if (indice == 0) {
            return removeDoInicio();
        } else if (indice == tamanho - 1) {
            return removeDoFim();
        }
        No noAux = inicio.getProximo();
        for (int i = 1; i < indice; i++) {
            noAux = noAux.getProximo();
        }
        return removeDoMeio(noAux);
    }

    public int espiarTopo() throws Exception {
        if (isVazio()) throw new Exception("Lista Vazia");
        return fim.getValor();
    }

    public int espiarInicio() throws Exception {
        if (isVazio()) throw new Exception("Lista Vazia");
        return inicio.getValor();
    }

    public int getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        if (isVazio()) return "[]";

        StringBuilder stringBuilder = new StringBuilder("[");
        No no = inicio;

        for (int i = 0; i < tamanho - 1; i++) {
            stringBuilder.append(no.getValor()).append(",");
            no = no.getProximo();
        }

        stringBuilder.append(no.getValor()).append("]");

        return stringBuilder.toString();
    }
}
