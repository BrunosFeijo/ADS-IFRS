package Ex5_ArvoreAVL;

public class Main {
    public static void main(String[] args) {
        ArvoreAVL lista = new ArvoreAVL();

        lista.adicionar(5);
        lista.adicionar(3);
        lista.adicionar(4);
        lista.adicionar(7);
        lista.adicionar(6);

        System.out.println(lista.imprimirEmOrdem(lista.getRaiz()));
    }
}
