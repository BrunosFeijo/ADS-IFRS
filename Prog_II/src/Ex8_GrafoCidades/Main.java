package Ex8_GrafoCidades;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        exemplos(grafo);

        grafo.infoConexoes();
        grafo.infoCidades();
        grafo.infoCidades("Porto Alegre");
        grafo.infoCidades("Canoas");
        grafo.infoCidades("Rio Grande");
        grafo.infoCidades("Esteio");

    }
    public static void exemplos(Grafo grafo){
        grafo.cadastraConexao("Porto Alegre", "Canoas", 20);
        grafo.cadastraConexao("Porto Alegre", "Gramado", 117);
        grafo.cadastraConexao("Porto Alegre", "Pelotas", 262);
        grafo.cadastraConexao("Porto Alegre", "Santa Maria", 297);
        grafo.cadastraConexao("Canoas", "Novo Hamburgo", 16);
        grafo.cadastraConexao("Canoas", "São Leopoldo", 10);
        grafo.cadastraConexao("Canoas", "Gravataí", 27);
        grafo.cadastraConexao("Gramado", "Canela", 7 );
        grafo.cadastraConexao("Gramado", "Bento Gonçalves", 99);
        grafo.cadastraConexao("Pelotas", "Rio Grande", 52 );
        grafo.cadastraConexao("Pelotas", "Bagé", 118);
        grafo.cadastraConexao("Santa Maria", "Cachoeira do Sul", 136);
        grafo.cadastraConexao("Santa Maria", "São Gabriel", 184);
        grafo.cadastraConexao("Rio Grande", "São José do Norte", 36);
        grafo.cadastraConexao("Rio Grande", "Chuí", 291);
    }
}
