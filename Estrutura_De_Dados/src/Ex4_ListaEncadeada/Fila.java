package Ex4_ListaEncadeada;

public class Fila {
    private No inicio;
    private No fim;
    private int tamanho;
    public Fila() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }
    public void adicionar(int valor){
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
    public int remover() {
        if (isVazio()){
            System.out.println("Lista Vazia");
            return -1;
        }
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
    public boolean isVazio() {
        return tamanho == 0;
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
