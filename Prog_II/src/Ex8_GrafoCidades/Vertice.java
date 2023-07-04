package Ex8_GrafoCidades;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
    public String nomeCidade;
    public List<Vertice> vizinhanca;
    public List<Aresta> conexoes;

    public Vertice(String nomeCidade, List<Vertice> vizinhanca, List<Aresta> conexoes) {
        this.nomeCidade = nomeCidade;
        this.vizinhanca = new ArrayList<>();
        this.conexoes = new ArrayList<>();
    }
    public void infoVizinhanca(){

    }
    public void infoConexoes(){

    }
    public void infoVertices(){

    }
}
