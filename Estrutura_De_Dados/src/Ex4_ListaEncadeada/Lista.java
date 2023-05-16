package Ex4_ListaEncadeada;

public class Lista {
    protected No inicio;
    protected No fim;
    protected int tamanho;

    public Lista() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    protected boolean isVazio() {
        return tamanho == 0;
    }

    protected void adicionarNoInicio(int valor) {
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

    protected void adicionaNoFinal(int valor) {
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

    protected void adicionaNoMeio(No noAtual, No novoNo) {
        //apontar novo nó para o nó anterior e o nó posterior
        novoNo.setAnterior(noAtual.getAnterior());
        novoNo.setProximo(noAtual);
        //apontar o nó anterior para o novo nó
        noAtual.getAnterior().setProximo(novoNo);
        //apontar o nó atual para o novo nó
        noAtual.setAnterior(novoNo);
        tamanho++;
    }

    protected void adicionaEmOrdemCrescente(int valor) {
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
            while(noAux.getValor() <= novoNo.getValor()){
                noAux = noAux.getProximo();
            }
            adicionaNoMeio(noAux, novoNo);
        }
    }
    protected int removeDoInicio(){
        int valorRemovido = inicio.getValor();
        inicio.getProximo().setAnterior(null);
        inicio = inicio.getProximo();

        return valorRemovido;
    }
    protected int removeDoFim(){
        int valorRemovido = fim.getValor();
        fim.getAnterior().setProximo(null);
        fim = fim.getAnterior();

        return valorRemovido;
    }
    protected int removeDoMeio(No noAtual){
        int valorRemovido = noAtual.getValor();
        //apontar o nó anterior para o próximo
        noAtual.getAnterior().setProximo(noAtual.getProximo());
        //apontar o próximo nó para o anterior
        noAtual.getProximo().setAnterior(noAtual.getAnterior());
        //tornar nó null



        return valorRemovido;
    }


    protected int espiarTopo() throws Exception {
        if (isVazio()) throw new Exception("Lista Vazia");
        return fim.getValor();
    }

    protected int espiarInicio() throws Exception {
        if (isVazio()) throw new Exception("Lista Vazia");
        return inicio.getValor();
    }

    protected int getTamanho() {
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
