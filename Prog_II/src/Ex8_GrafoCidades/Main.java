package Ex8_GrafoCidades;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        grafo.cadastraConexao("Porto Alegre", "Canoas", 20);
        grafo.cadastraConexao("Porto Alegre", "Gravatai", 15);
        grafo.cadastraConexao("Porto Alegre", "Cachoeirinha", 10);

        grafo.infoConexoes();
        
    }
}
