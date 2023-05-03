package Ex4_Livraria;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Livraria livros = new Livraria();
        bibliotecaPadrao(livros);

        int op = menu(livros);
        while(op != 0) {
            op = menu(livros);
        }

    }
    public static void bibliotecaPadrao(Livraria livros){

    }

    public static int menu(Livraria livros) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("-------------------Menu-------------------");
        System.out.println("1- Cadastrar novo livro");
        System.out.println("2- Listar livros");
        System.out.println("3- Buscar livro por nome");
        System.out.println("4- Buscar livro por categoria");
        System.out.println("5- Buscar livro por valor");
        System.out.println("6- Buscar livro por quantidade em estoque");
        System.out.println("7- Valor total no estoque");
        System.out.println("0- Sair");
        System.out.println("------------------------------------------");
        System.out.print("Informe a opção desejada: ");
        int opcao = entrada.nextInt();
        opcoes(opcao,livros);

        return opcao;
    }

    public static void opcoes(int op, Livraria livros) {
        if (op < 0 || op > 7) {
            System.out.println("Opção inválida!");
        } else {
            switch (op) {
                case 1 -> livros.cadastrarLivro();
                case 2 -> System.out.println(livros);
                case 3 -> {
                    Livro livro = livros.buscaPorTitulo();
                    if (livro != null){
                        System.out.println(livro);
                    }else{
                        System.out.println("Livro não encontrado");
                    }
                }
                case 4 -> {
                    String listaLivros = livros.buscaPorCategoria();
                    System.out.println( listaLivros.length() != 0  ? listaLivros : "Nenhum livro encontrado nesta categoria");
                }
                case 5 -> {
                    String listaLivros = livros.buscaPorValor();
                    System.out.println(listaLivros.length() != 0 ? listaLivros : "Nenhum livro encontrado com preço menor que o informado");
                }
                case 6 -> {
                    String listaLivros = livros.buscaPorQuantidadeEmEstoque();
                    System.out.println(listaLivros.length() != 0 ? listaLivros : "Nenhum livro encontrado com preço menor que o informado");
                }
                case 7 -> System.out.println(livros.valorTotalEmEstoque());
            }
        }
    }
}
