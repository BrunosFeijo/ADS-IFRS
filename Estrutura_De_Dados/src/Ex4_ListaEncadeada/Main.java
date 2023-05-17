package Ex4_ListaEncadeada;

public class Main {
    public static void main(String[] args) throws Exception {
        
    }
    public static void testesManuais(){
        //Testes manuais
        System.out.println("---------------Lista---------------");
        Lista lista = new Lista();
        lista.adicionar(2);
        lista.adicionar(5);
        lista.adicionar(1);
        lista.adicionar(3);
        lista.adicionar(4);
        lista.adicionar(-10);
        lista.adicionar(100);
        lista.adicionar(99);
        System.out.println(lista); // ordenado
        System.out.println(lista.getTamanho()); // 8
        System.out.println("Elemento do início da lista: " + lista.espiarInicio());
        System.out.println("Elemento do fim da lista: " + lista.espiarFim());

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

        System.out.println("---------------Fila---------------");
        Fila fila = new Fila();

        fila.adicionar(2);
        fila.adicionar(5);
        fila.adicionar(9);
        fila.adicionar(4);
        fila.adicionar(1);
        System.out.println(fila);

        System.out.println("Valor " + fila.remover() + " removido");
        System.out.println("Valor " + fila.remover() + " removido");
        System.out.println("Valor " + fila.remover() + " removido");
        System.out.println(fila);
        System.out.println("Valor " + fila.remover() + " removido");
        System.out.println("Valor " + fila.remover() + " removido");
        fila.remover();//Fila Vazia
        System.out.println(fila);



        System.out.println("---------------Pilha---------------");

        Pilha pilha = new Pilha();

        pilha.adicionar(2);
        pilha.adicionar(5);
        pilha.adicionar(9);
        pilha.adicionar(4);
        pilha.adicionar(1);
        System.out.println(pilha);

        System.out.println("Valor " + pilha.remover() + " removido");
        System.out.println("Valor " + pilha.remover() + " removido");
        System.out.println("Valor " + pilha.remover() + " removido");
        System.out.println(pilha);
        System.out.println("Valor " + pilha.remover() + " removido");
        System.out.println("Valor " + pilha.remover() + " removido");
        pilha.remover();//Fila Vazia
        System.out.println(pilha);
    }
}
