package Ex4_ListaEncadeada;

public class Main {
    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.adicionaEmOrdemCrescente(2);
        lista.adicionaEmOrdemCrescente(5);
        lista.adicionaEmOrdemCrescente(1);
        lista.adicionaEmOrdemCrescente(3);
        lista.adicionaEmOrdemCrescente(4);
        lista.adicionaEmOrdemCrescente(-10);
        lista.adicionaEmOrdemCrescente(100);
        lista.adicionaEmOrdemCrescente(99);
        System.out.println(lista);
        System.out.println(lista.getTamanho());
    }
}
