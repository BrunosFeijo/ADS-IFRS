package Ex8_GrafoCidades;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Grafo {
    public List<Vertice> cidades;
    public List<Aresta> conexoes;

    public Grafo() {
        this.cidades = new ArrayList<>();
        this.conexoes = new ArrayList<>();
    }

    public void infoCidades() {
        cidades.sort(Comparator.comparing(Vertice::toString));
        System.out.println("\n------------Info Vértices------------");
        for (Vertice vertice : cidades) {
            vertice.infoVertice();
        }
    }

    public void infoCidades(String cidade) {
        for (Vertice vertice : cidades) {
            if (vertice.nomeCidade.equalsIgnoreCase(cidade)) {
                System.out.println("\n------------Vizinhos de " + cidade + " ------------");
                vertice.conexoes.sort(Comparator.comparing(Aresta::getDistancia));
                for (Aresta aresta : vertice.conexoes) {
                    if (vertice.equals(aresta.cidade1)) {
                        System.out.println(aresta.cidade2.nomeCidade + " - " + aresta.distancia + "km");
                    } else {
                        System.out.println(aresta.cidade1.nomeCidade + " - " + aresta.distancia + "km");
                    }
                }
            }
        }
    }

    public void infoConexoes() {
        conexoes.sort(Comparator.comparing(Aresta::getDistancia));
        System.out.println("|---------Cidade1---------|-Distância (km)-|---------Cidade2---------|");
        for (Aresta aresta : conexoes) {
            System.out.println(aresta);
        }
        System.out.println("|-------------------------|----------------|-------------------------|");
    }

    public boolean cadastraCidade(String nomeCidade) {
        if (!contemCidade(nomeCidade)) {
            cidades.add(new Vertice(nomeCidade));
            return true;
        }
        return false;
    }

    public void cadastraConexao(String cidade1, String cidade2, int distancia) {
        if (!contemCidade(cidade1)) {
            cadastraCidade(cidade1);
        }
        if (!contemCidade(cidade2)) {
            cadastraCidade(cidade2);
        }
        Vertice vertice1 = procuraCidade(cidade1);
        Vertice vertice2 = procuraCidade(cidade2);
        Aresta aresta = new Aresta(vertice1, vertice2, distancia);


        this.conexoes.add(aresta);

        vertice1.vizinhanca.add(vertice2);
        vertice1.conexoes.add(aresta);

        vertice2.vizinhanca.add(vertice1);
        vertice2.conexoes.add(aresta);
    }

    private boolean contemCidade(String cidade) {
        for (Vertice vertice : cidades) {
            if (vertice.nomeCidade.equalsIgnoreCase(cidade)) {
                return true;
            }
        }
        return false;
    }

    private Vertice procuraCidade(String cidade) {
        for (Vertice vertice : cidades) {
            if (vertice.nomeCidade.equalsIgnoreCase(cidade)) {
                return vertice;
            }
        }
        return null;
    }


}
