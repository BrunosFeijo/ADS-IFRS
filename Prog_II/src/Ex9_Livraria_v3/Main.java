package Ex9_Livraria_v3;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Livraria livros = new Livraria(); //já incluída uma biblioteca padrão
        int op = menu(livros);
        while (op != 0) {
            op = menu(livros);
            if (op == 0) {
                encerrarPrograma(livros);
            }
        }
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
        System.out.println("8- Carregar estoque (txt)");
        System.out.println("9- Atualizar arquivo de estoque");
        System.out.println("0- Sair");
        System.out.println("------------------------------------------");
        System.out.print("Informe a opção desejada: ");
        int opcao = entrada.nextInt();
        opcoes(opcao, livros);

        return opcao;
    }

    public static void opcoes(int op, Livraria livros) {
        if (op < 0 || op > 9) {
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
                case 8 -> {
                    String arquivo = "Livros Prog II.txt";
                    String texto = Arquivos.leitor(arquivo);

                    if (texto.isEmpty()) {
                        System.out.println("Arquivo vazio");
                    } else {
                        boolean ok = livros.adicionarLote(texto);
                        if (ok) {
                            System.out.println("Livraria atualizada com sucesso");
                        } else {
                            System.out.println("Erro na atualização da Livraria");
                        }
                    }
                }
                case 9 -> {
                    String caminho = "Livros Prog II.txt";
                    String texto = livros.formatoEntreVirgulas();
                    boolean ok = Arquivos.escritor(caminho, texto);
                    if (ok){
                        System.out.println("Arquivo de Estoque atualizado com sucesso");
                    }else{
                        System.out.println("Erro ao atualizar arquivo");
                    }
                }
            }
        }
    }

    public static void encerrarPrograma(Livraria livros) {
        String caminho = "Livros Prog II.txt";
        String texto = livros.formatoEntreVirgulas();
        Scanner entrada = new Scanner(System.in);

        System.out.println("Deseja salvar alterações?");
        System.out.println("1- Sim");
        System.out.println("2- Não");
        int opcao = entrada.nextInt();

        switch (opcao) {
            case 1 -> Arquivos.escritor(caminho, texto);
            case 2 -> System.exit(0);
        }
    }
}
