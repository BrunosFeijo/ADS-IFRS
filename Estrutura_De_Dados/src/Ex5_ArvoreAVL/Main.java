package Ex5_ArvoreAVL;

public class Main {
    public static void main(String[] args) {
        ArvoreAVL lista = new ArvoreAVL();

        lista.adicionar(5);
        lista.adicionar(3);
        lista.adicionar(4);
        lista.adicionar(7);
        lista.adicionar(6);
        lista.adicionar(2);
        lista.adicionar(8);
        lista.adicionar(1);
        lista.adicionar(9);
        lista.adicionar(10);
        lista.adicionar(11);
        lista.adicionar(12);

        System.out.println(lista.imprimirEmOrdem(lista.getRaiz()));
        System.out.println(lista.imprimirPosOrdem(lista.getRaiz()));
        System.out.println(lista.imprimirPreOrdem(lista.getRaiz()));
        System.out.println(lista);
    }
}
