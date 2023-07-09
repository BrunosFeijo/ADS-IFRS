package Ex8_GrafoCidades;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
    public List<Vertice> cidades;
    public List<Aresta> conexoes;

    public Grafo(List<Vertice> cidades, List<Aresta> conexoes) {
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

    public void cadastraConexao(Vertice cidade1,Vertice cidade2) {
        if (procuraCidade(cidade1) && procuraCidade(cidade2)){
            
        }
    }

    private boolean procuraCidade(Vertice cidade) {
        return cidades.contains(cidade);
    }


}
