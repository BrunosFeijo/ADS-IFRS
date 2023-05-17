package Ex4_ListaEncadeada;

public class Pilha extends Lista{
    public Pilha() {
        super();
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
        if (isVazio()) {
            System.out.println("Pilha Vazia");
            return -1;
        }
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
    }

