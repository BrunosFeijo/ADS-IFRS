package Ex8_GrafoCidades;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
    public String nomeCidade;
    public List<Vertice> vizinhanca;
    public List<Aresta> conexoes;

    public Vertice(String nomeCidade) {
        this.nomeCidade = nomeCidade;
        this.vizinhanca = new ArrayList<>();
        this.conexoes = new ArrayList<>();
    }
    public void infoVizinhanca(){
        System.out.println("\n" + nomeCidade + " -> Cidades vizinhas: ");
        System.out.println(vizinhanca);
    }
    public void infoConexoes(){
        System.out.println("\nConexões: ");
        System.out.println("|Cidade1------------------Distância (km)---Cidade2---------------------|");
        for(Aresta aresta: conexoes){
            System.out.println(aresta);
        }
        System.out.println("|----------------------------------------------------------------------|");
    }
    public void infoVertice(){
        System.out.println("\n------------Info Vértice------------");
        System.out.println("Cidade: "+ nomeCidade);
        System.out.println("------Vizinhos------");
        System.out.println(vizinhanca);
    }
}
