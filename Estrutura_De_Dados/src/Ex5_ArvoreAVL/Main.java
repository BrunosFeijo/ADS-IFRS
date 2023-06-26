package Ex5_ArvoreAVL;

public class Main {
    public static void main(String[] args) {
        ArvoreAVL lista = new ArvoreAVL();

        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.adicionar(4);
        lista.adicionar(5);
        lista.adicionar(6);
        lista.adicionar(7);
        lista.adicionar(8);
        lista.adicionar(9);
        lista.adicionar(10);

        System.out.println(lista);

        lista.remover(4);
        lista.remover(7);
        lista.remover(3);
        lista.remover(5);
        lista.remover(6);
        lista.remover(10);
        lista.remover(9);
        lista.remover(1);
        lista.remover(8);
        lista.remover(2);

        System.out.println(lista);

        if (lista.isVazio()){
            System.out.println("Lista está vazia");
        }

        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.adicionar(4);
        lista.adicionar(5);
        lista.adicionar(6);
        lista.adicionar(7);
        lista.adicionar(8);
        lista.adicionar(9);
        lista.adicionar(10);
        lista.adicionar(11);

        System.out.println(lista);
    }
}
