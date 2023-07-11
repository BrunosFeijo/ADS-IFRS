package Ex9_Livraria_v3;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ListaDeFiliais.cadastrarFilial(new Filial("01","Teste","rua Teste","5133876733"));
        ListaDeFiliais.cadastrarFilial(new Filial("02","Teste2","rua Teste","5133876733"));

        int op = menu();
        while (op != 0) {
            op = menu();
            if (op == 0) {
                encerrarPrograma();
            }
        }
    }

    public static int menu() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("-------------------Menu-------------------");
        System.out.println("1- Cadastrar novo livro (Filial) ");
        System.out.println("2- Listagem de Estoque (Filial) ");
        System.out.println("3- Buscar livro por nome (Filial)");
        System.out.println("4- Buscar livro por categoria (Filial)");
        System.out.println("5- Buscar livro por valor (Filial)");
        System.out.println("6- Buscar livro por quantidade em estoque (Filial)");
        System.out.println("7- Valor total no estoque (Filial)");
        System.out.println("8- Carregar estoque (txt)");
        System.out.println("9- Atualizar arquivo de estoque");
        System.out.println("10- Buscar livro por código (Geral)");
        System.out.println("0- Sair");
        System.out.println("------------------------------------------");
        System.out.print("Informe a opção desejada: ");
        int opcao = entrada.nextInt();
        opcoes(opcao);

        return opcao;
    }

    public static void opcoes(int op) {
        if (op < 0 || op > 10) {
            System.out.println("Opção inválida!");
        } else {
            Filial filial = ListaDeFiliais.escolherFilial();
            switch (op) {
                case 1 -> filial.cadastrarLivro();
                case 2 -> System.out.println(filial);
                case 3 -> {
                    Livro livro = filial.buscaPorTitulo();
                    if (livro != null) {
                        System.out.println(livro);
                    } else {
                        System.out.println("Livro não encontrado");
                    }
                }
                case 4 -> {
                    String listaLivros = filial.buscaPorCategoria();
                    System.out.println(listaLivros.length() != 0 ? listaLivros : "Nenhum livro encontrado nesta categoria");
                }
                case 5 -> {
                    String listaLivros = filial.buscaPorValor();
                    System.out.println(listaLivros.length() != 0 ? listaLivros : "Nenhum livro encontrado com preço menor que o informado");
                }
                case 6 -> {
                    String listaLivros = filial.buscaPorQuantidadeEmEstoque();
                    System.out.println(listaLivros.length() != 0 ? listaLivros : "Nenhum livro encontrado com quantidade maior que a informada");
                }
                case 7 -> System.out.println("Valor total em estoque: " + filial.valorTotalEmEstoque());
                case 8 -> {
                    String arquivo = "Livros Prog II.txt";
                    String texto = Arquivos.leitor(arquivo);

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
                    String caminho = "Livros Prog II.txt";
                    String texto = filial.formatoEntreVirgulas();
                    boolean ok = Arquivos.escritor(caminho, texto);
                    if (ok){
                        System.out.println("Arquivo de Estoque atualizado com sucesso");
                    }else{
                        System.out.println("Erro ao atualizar arquivo");
                    }
                }
                case 10 -> System.out.println(ListaDeFiliais.procuraCodLivro());
            }
        }
    }

    public static void encerrarPrograma() {
//        String caminho = "Livros Prog II.txt";
//        String texto = livros.formatoEntreVirgulas();
//        Scanner entrada = new Scanner(System.in);
//
//        System.out.println("Deseja salvar alterações?");
//        System.out.println("1- Sim");
//        System.out.println("2- Não");
//        int opcao = entrada.nextInt();
//
//        switch (opcao) {
//            case 1 -> Arquivos.escritor(caminho, texto);
//            case 2 -> System.exit(0);
//        }
    }

}
