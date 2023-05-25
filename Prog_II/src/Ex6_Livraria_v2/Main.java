package Ex6_Livraria_v2;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Livraria livros = new Livraria(); //já incluída uma biblioteca padrão

        int op = menu(livros);
        while(op != 0) {
            op = menu(livros);
        }
//        String arquivo = "teste.txt";
//        String texto = "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos,\r\n"
//                + "e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja\r\n"
//                + "de tipos e os embaralhou para fazer um livro de modelos de tipos. v2";
//        if (Arquivos.escritor(arquivo,texto)) System.out.println("Arquivo salvo com sucesso!");
//
//        texto = Arquivos.leitor(arquivo);
//        if (texto.isEmpty()){
//            System.out.println("Arquivo vazio");
//        }else{
//            System.out.println(texto);
//        }
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
        opcoes(opcao, livros);

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
                    if (livro != null) {
                        System.out.println(livro);
                    } else {
                        System.out.println("Livro não encontrado");
                    }
                }
                case 4 -> {
                    String listaLivros = livros.buscaPorCategoria();
                    System.out.println(listaLivros.length() != 0 ? listaLivros : "Nenhum livro encontrado nesta categoria");
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
