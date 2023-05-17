package Ex4_ListaEncadeada;

public class Fila extends Lista {

    public Fila() {
        super();
    }

    public void adicionar(int valor) {
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
        if (isVazio()) {
            System.out.println("Fila Vazia");
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
}
