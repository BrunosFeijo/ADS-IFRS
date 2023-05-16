package Ex4_ListaEncadeada;

public class Main {
    public static void main(String[] args) throws Exception {
        //Testes manuais
        Lista lista = new Lista();
        lista.adicionaEmOrdemCrescente(2);
        lista.adicionaEmOrdemCrescente(5);
        lista.adicionaEmOrdemCrescente(1);
        lista.adicionaEmOrdemCrescente(3);
        lista.adicionaEmOrdemCrescente(4);
        lista.adicionaEmOrdemCrescente(-10);
        lista.adicionaEmOrdemCrescente(100);
        lista.adicionaEmOrdemCrescente(99);
        System.out.println(lista); // ordenado
        System.out.println(lista.getTamanho()); // 8

        lista.removerPorValor(2);
        lista.removerPorValor(5);
        lista.removerPorValor(1);
        lista.removerPorValor(3);
        lista.removerPorValor(10); //não encontrado
        System.out.println("Valor " + lista.removerPorIndice(2) + " removido");
        System.out.println("Valor " + lista.removerPorIndice(1) + " removido");
        System.out.println("Valor " + lista.removerPorIndice(0) + " removido");
        lista.removerPorIndice(1); //índice inválido
        System.out.println("Valor " + lista.removerPorIndice(0) + " removido");
        lista.removerPorIndice(1); //Lista vazia
        System.out.println(lista); // []
        System.out.println(lista.getTamanho()); // 0

        Fila fila = new Fila();

        fila.adicionar(2);
        fila.adicionar(5);
        fila.adicionar(9);
        fila.adicionar(4);
        fila.adicionar(1);
        System.out.println(fila);


    }
}
