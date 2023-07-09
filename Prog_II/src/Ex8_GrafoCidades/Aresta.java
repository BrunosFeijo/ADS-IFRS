package Ex8_GrafoCidades;

public class Aresta {
    public Vertice cidade1;
    public Vertice cidade2;
    public int distancia;

    public Aresta(Vertice cidade1, Vertice cidade2, int distancia) {
        this.cidade1 = cidade1;
        this.cidade2 = cidade2;
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return String.format("|%-24s |%-15d |%-25s|", cidade1.nomeCidade, distancia, cidade2.nomeCidade);
    }
    public int getDistancia(){
        return distancia;
    }
}
