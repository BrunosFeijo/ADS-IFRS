package Ex8_GrafoCidades;

public class Main {
    public static void main(String[] args) {
        Aresta aresta = new Aresta(new Vertice("Porto Alegre"),new Vertice("Canoas"),20);
        Aresta aresta1 = new Aresta(new Vertice("Porto Alegre"),new Vertice("Canoas"),200);
        System.out.println(aresta);
        System.out.println(aresta1);

    }
}
