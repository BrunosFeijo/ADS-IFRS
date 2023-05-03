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
    public Livro buscaPorTitulo(){
        String nome = informarTitulo();
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(nome)) return livro;
        }
        return null;
    }
    private String informarTitulo(){
        Scanner entrada = new Scanner(System.in);

        System.out.print("Informe o nome do livro procurado: ");

        return entrada.nextLine();
    }

    public int buscaQuantidadeEmEstoque(String nome) {
        for (Livro livro : livros) {
            if (nome.equalsIgnoreCase(livro.getTitulo())) return livro.getQtd();
        }

        return -1;
    }

    public String buscaPorValor() {
        double valor = informarValor();
        StringBuilder stringBuilder = new StringBuilder();

        for (Livro livro : livros) {
            if (valor >= livro.getValor()) stringBuilder.append(livro).append("\n");
        }

        return stringBuilder.toString();
    }
    public double informarValor(){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Informe valor limite: $");

        return entrada.nextDouble();
    }

    public String buscaPorCategoria() {
        StringBuilder stringBuilder = new StringBuilder();
        Categoria genero = informarCategoria();

        for (Livro livro : livros) {
            if (genero.equals(livro.getCategoria())) stringBuilder.append(livro).append("\n");
        }
        return stringBuilder.toString();
    }
    public Categoria informarCategoria(){
        Scanner entrada = new Scanner(System.in);
        for (Categoria genero: Categoria.values()){
            System.out.println(genero.ordinal() + " - " + genero.name());
        }
        System.out.print("Informe a categoria do livro procurado: ");
        int indice = entrada.nextInt();
        if (indice >= 0 && indice < Categoria.values().length){
            return Categoria.values()[indice];
        }
        return Categoria.CANCELAR;
    }

    public String buscaPorQuantidadeEmEstoque() {
        int qtd = informarQuantidadeEmEstoque();
        StringBuilder stringBuilder = new StringBuilder();

        for (Livro livro : livros) {
            if (qtd <= livro.getQtd()) stringBuilder.append(livro).append("\n");
        }
        return stringBuilder.toString();
    }
    public int informarQuantidadeEmEstoque(){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Informe a quantidade buscada: ");

        return entrada.nextInt();
    }
    public double valorTotalEmEstoque(){
        double valorTotal = 0;
        for (Livro livro:livros){
            valorTotal += livro.getValorTotal();
        }
        return valorTotal;
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
