package Ex9_Livraria_v3;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        int op = menu();
        while (op != 0) {
            op = menu();
            if (op == 0) {
                encerrarPrograma();
                System.out.println("Programa encerrado");
            }
        }
    }

    public static int menu() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("-------------------Menu-------------------");
        System.out.println(" 1- Cadastrar novo livro (Filial) ");
        System.out.println(" 2- Listagem de Estoque (Filial) ");
        System.out.println(" 3- Buscar livro por nome (Filial)");
        System.out.println(" 4- Buscar livro por categoria (Filial)");
        System.out.println(" 5- Buscar livro por valor (Filial)");
        System.out.println(" 6- Buscar livro por quantidade em estoque (Filial)");
        System.out.println(" 7- Valor total no estoque (Filial)");
        System.out.println(" 8- Carregar estoque (txt)");
        System.out.println(" 9- Atualizar arquivo de estoque");
        System.out.println("10- Buscar livro por código (Geral)");
        System.out.println("11- Cadastrar Filial");
        System.out.println("12- Exemplos Prontos");
        System.out.println(" 0- Sair");
        System.out.println("------------------------------------------");
        System.out.print("Informe a opção desejada: ");
        int opcao = entrada.nextInt();
        opcoes(opcao);

        return opcao;
    }

    public static void opcoes(int op) {
        if (op < 0 || op > 12) {
            System.out.println("Opção inválida!");
        } else {

            switch (op) {
                case 1 -> {
                    Filial filial = ListaDeFiliais.escolherFilial();
                    if (filial != null) {
                        filial.cadastrarLivro();
                    }else {
                        System.out.println("Filial não localizada");
                    }
                }
                case 2 -> {
                    Filial filial = ListaDeFiliais.escolherFilial();
                    System.out.println(filial != null ? filial : "Filial não encontrada");
                }
                case 3 -> {
                    Filial filial = ListaDeFiliais.escolherFilial();
                    Livro livro = filial.buscaPorTitulo();
                    System.out.println(livro != null ? livro : "Livro não encontrado");
                }
                case 4 -> {
                    Filial filial = ListaDeFiliais.escolherFilial();
                    String listaLivros = filial.buscaPorCategoria();
                    System.out.println(listaLivros.length() != 0 ? listaLivros : "Nenhum livro encontrado nesta categoria");
                }
                case 5 -> {
                    Filial filial = ListaDeFiliais.escolherFilial();
                    String listaLivros = filial.buscaPorValor();
                    System.out.println(listaLivros.length() != 0 ? listaLivros : "Nenhum livro encontrado com preço menor que o informado");
                }
                case 6 -> {
                    Filial filial = ListaDeFiliais.escolherFilial();
                    String listaLivros = filial.buscaPorQuantidadeEmEstoque();
                    System.out.println(listaLivros.length() != 0 ? listaLivros : "Nenhum livro encontrado com quantidade maior que a informada");
                }
                case 7 -> {
                    Filial filial = ListaDeFiliais.escolherFilial();
                    System.out.println("Valor total em estoque: " + filial.valorTotalEmEstoque());
                }
                case 8 -> {
                    String nomeArquivo = Arquivos.nomeArquivo();
                    String texto = Arquivos.leitor(".\\Prog_II/src/" + nomeArquivo + ".txt");
                    String[] aux = texto.split("\n", 2);//separa apenas a primeira linha do resto
                    Filial filial = verificarPrimeiraLinha(aux[0]);
                    if (filial != null) { // se a primeira linha foi utilizada para criar a filial, então resto vira o texto para criar a lista de livros
                        texto = aux[1];
                    }
                    if (texto.isEmpty()) {
                        System.out.println("Arquivo vazio");
                    } else {
                        boolean ok = filial.adicionarLote(texto);
                        if (ok) {
                            System.out.println("Livraria atualizada com sucesso");
                        } else {
                            System.out.println("Erro na atualização da Livraria");
                        }
                    }
                }
                case 9 -> {
                    Filial filial = ListaDeFiliais.escolherFilial();
                    String caminho = ".\\Prog_II/src/" + filial.getCodigo() + ".txt";
                    String texto = filial.formatoEntreVirgulas();
                    boolean ok = Arquivos.escritor(caminho, texto);
                    if (ok) {
                        System.out.println("Arquivo de Estoque atualizado com sucesso");
                    } else {
                        System.out.println("Erro ao atualizar arquivo");
                    }
                }
                case 10 -> System.out.println(ListaDeFiliais.procuraCodLivro());
                case 11 -> ListaDeFiliais.cadastrarFilial();
                case 12 -> {
                    ListaDeFiliais.cadastrarFilial(new Filial("00", "Teste", "rua Teste", "5133876733"));
                    ListaDeFiliais.getListaDeFiliais().get(0).bibliotecaPadrao();
                    ListaDeFiliais.cadastrarFilial(new Filial("02", "Teste2", "rua Teste", "5133876733"));
                    ListaDeFiliais.getListaDeFiliais().get(1).bibliotecaPadrao();

                }
            }
        }
    }

    public static void encerrarPrograma() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Deseja salvar alterações?");
        System.out.println("1- Sim");
        System.out.println("2- Não");
        int opcao = entrada.nextInt();

        switch (opcao) {
            case 1 -> {
                for (Filial filial : ListaDeFiliais.getListaDeFiliais()) {
                    String caminho = ".\\Prog_II/src/" + filial.getCodigo() + ".txt";
                    String texto = filial.formatoEntreVirgulas();
                    Arquivos.escritor(caminho, texto);
                }
            }
            case 2 -> {
                System.out.println("Programa encerrado");
                System.exit(0);
            }
        }
    }

    public static Filial verificarPrimeiraLinha(String linha) {
        if (linha.contains("#FL")) {
            String[] texto = linha.split(",");
            Filial filial = new Filial(texto[0], texto[1], texto[2], texto[3]);
            ListaDeFiliais.cadastrarFilial(filial);
            return filial;
        }
        return null;
    }

}
