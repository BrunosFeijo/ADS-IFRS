package Ex8_GrafoCidades;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
    public List<Vertice> cidades;
    public List<Aresta> conexoes;

    public Grafo() {
        this.cidades = new ArrayList<>();
        this.conexoes = new ArrayList<>();
    }

    public void infoCidades() {

    }

    public void infoConexoes() {
    }

    public void cadastraCidade(String nomeCidade) {
        cidades.add(new Vertice(nomeCidade));
        System.out.println("Cidade cadastrada!");
    }

    public void cadastraConexao(String cidade1, String cidade2,int distancia) {
        if (!contemCidade(cidade1)) {
            cadastraCidade(cidade1);
        }
        if (!contemCidade(cidade2)) {
            cadastraCidade(cidade2);
        }
        Vertice vertice1 = retornaVertice(cidade1);
        Vertice vertice2 = retornaVertice(cidade2);
        Aresta aresta = new Aresta(vertice1,vertice2,distancia);


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
    private Vertice retornaVertice(String cidade){
        for (Vertice vertice: cidades){
            if (vertice.nomeCidade.equalsIgnoreCase(cidade)) {
                return vertice;
            }
        }
        return null;
    }



}
