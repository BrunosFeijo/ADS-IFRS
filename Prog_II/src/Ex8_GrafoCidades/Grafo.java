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
        if (cidades.isEmpty()) {
            System.out.println("Nenhuma cidade cadastrada!");
            return;
        }
        System.out.println("\n------------Cidades Cadastradas------------");
        for (Vertice vertice : cidades) {
            vertice.infoVertice();
        }
    }

    public void infoCidades(String cidade) {
        if (contemCidade(cidade)) {
            for (Vertice vertice : cidades) {
                if (vertice.nomeCidade.equalsIgnoreCase(cidade)) {
                    System.out.println("\n------------Vizinhos de " + cidade + " ------------");
                    for (Aresta aresta : vertice.conexoes) {
                        if (vertice.equals(aresta.cidade1)) {
                            System.out.println(aresta.cidade2.nomeCidade + " - " + aresta.distancia + "km");
                        } else {
                            System.out.println(aresta.cidade1.nomeCidade + " - " + aresta.distancia + "km");
                        }
                    }
                }
            }
        } else {
            System.out.println("Cidade não encontrada!");
        }
    }

    public void infoConexoes() {
        if (conexoes.isEmpty()) {
            System.out.println("Nenhuma conexão cadastrada!");
            return;
        }
        System.out.println("|---------Cidade1---------|-Distância (km)-|---------Cidade2---------|");
        for (Aresta aresta : conexoes) {
            System.out.println(aresta);
        }
        System.out.println("|-------------------------|----------------|-------------------------|");
    }

    public boolean cadastraCidade(String nomeCidade) {
        if (!contemCidade(nomeCidade)) {
            cidades.add(new Vertice(nomeCidade));
            cidades.sort(Comparator.comparing(Vertice::toString));
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
        conexoes.sort(Comparator.comparing(Aresta::getDistancia));

        vertice1.vizinhanca.add(vertice2);
        vertice1.conexoes.add(aresta);
        vertice1.conexoes.sort(Comparator.comparing(Aresta::getDistancia));

        vertice2.vizinhanca.add(vertice1);
        vertice2.conexoes.add(aresta);
        vertice2.conexoes.sort(Comparator.comparing(Aresta::getDistancia));
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

    private void ordenarPorDistancia(List<Aresta> conexoes, int menor, int maior) {
        if (conexoes.isEmpty()) {
            return;
        }
        if (menor < maior) {
            Aresta pivo = conexoes.get(maior);
            int i = menor - 1;

            for (int j = menor; j < maior; j++) {
                if (conexoes.get(j).distancia <= pivo.distancia) {
                    i++;
                    Aresta aux = conexoes.get(i);
                    conexoes.set(i, conexoes.get(j));
                    conexoes.set(j, aux);
                }
            }

            Aresta aux = conexoes.get(i + 1);
            conexoes.set(i + 1, pivo);
            conexoes.set(maior, aux);

            ordenarPorDistancia(conexoes, menor, i);
            ordenarPorDistancia(conexoes, i + 2, maior);
        }
    }


}
