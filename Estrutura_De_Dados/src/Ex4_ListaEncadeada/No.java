package Ex4_ListaEncadeada;

public class No {
    private int valor;
    private No proximo;
    private No anterior;

    public No(int valor){
        this.valor = valor;
        proximo = null;
        anterior = null;
    }
}
