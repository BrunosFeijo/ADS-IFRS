package Ex4_Livraria;

import java.util.ArrayList;
import java.util.Scanner;

public class Livraria {
    private ArrayList<Livro> livros;

    public Livraria() {
        livros = new ArrayList<>();
    }

    public void cadastrarLivro() {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Informe o título do livro: ");
        String titulo = entrada.nextLine();

        System.out.print("Informe o código do livro: ");
        int codigo = entrada.nextInt();

        System.out.print("Informe a editora do livro: ");
        String editora = entrada.nextLine();

        System.out.println("Informe o gênero literário do livro: ");
        for (Categoria genero : Categoria.values()) {
            System.out.println(genero.ordinal() + " - " + genero.name());
        }
        Categoria categoria = Categoria.values()[entrada.nextInt()];

        System.out.print("Informe o ano do livro: ");
        int ano = entrada.nextInt();

        System.out.print("Informe o valor do livro: ");
        double valor = entrada.nextDouble();

        System.out.print("Informe a quantidade em estoque do livro: ");
        int qtd = entrada.nextInt();

        Livro livro = new Livro(titulo, codigo, editora, categoria, ano, valor, qtd);
        livros.add(livro);

        System.out.println("Livro cadastrado com sucesso!\n");
    }

    public int buscaQuantidadeEmEstoque(String nome) {
        for (Livro livro : livros) {
            if (nome.equalsIgnoreCase(livro.getTitulo())) return livro.getQtd();
        }

        return -1;
    }

    public String buscaPorValor(double valor) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Livro livro : livros) {
            if (valor >= livro.getValor()) stringBuilder.append(livro).append("\n");
        }

        return stringBuilder.toString();
    }

    public String buscaPorCategoria(Categoria genero) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Livro livro : livros) {
            if (genero.equals(livro.getCategoria())) stringBuilder.append(livro).append("\n");
        }
        return stringBuilder.toString();
    }
    
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Livro livro : livros) {
            stringBuilder.append(livro).append("\n\n");
        }

        return stringBuilder.toString();
    }
}
