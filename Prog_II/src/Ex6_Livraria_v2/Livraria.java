package Ex6_Livraria_v2;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Livraria {
    private ArrayList<Livro> livros;

    public Livraria() {
        livros = new ArrayList<>();
        bibliotecaPadrao();
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
    public void bibliotecaPadrao(){
        Livro livro1 = new Livro("1984",001,"Companhia das Letras", Categoria.DISTOPIA,1949,39.90,7);
        Livro livro2 = new Livro("Dom Quixote",002,"Penguin Classics", Categoria.CONTO,1605,45.00,12);
        Livro livro3 = new Livro("Cem Anos de Solidão",003,"Record", Categoria.REALISMO_MÁGICO,1967,59.90,7);
        Livro livro4 = new Livro("Orgulho e Preconceito",004,"Martin Claret", Categoria.ROMANCE,1813,29.90,9);
        Livro livro5 = new Livro("O Senhor dos Anéis: A Sociedade do Anel",5,"Martins Fontes", Categoria.FANTASIA,1954,1954,2);
        Livro livro6 = new Livro("Moby Dick",6,"Zahar", Categoria.CONTO,1851,49.90,21);
        Livro livro7 = new Livro("Crime e Castigo",7,"L&PM Editores", Categoria.ROMANCE,1866,39.90,30);
        Livro livro8 = new Livro("O Grande Gatsby",8,"Penguin Books", Categoria.FICÇÃO_CONTEMPORÂNEA,1925,42.00,4);
        Livro livro9 = new Livro("O Morro dos Ventos Uivantes",9,"Nova Fronteira", Categoria.ROMANCE,1847,36.00,9);
        Livro livro10 = new Livro("Ulisses",10,"Penguin Modern Classics", Categoria.ROMANCE,1922,58.00,13);
        Livro livro11 = new Livro("O Apanhador no Campo de Centeio",11,"Editora do Autor", Categoria.ROMANCE,1951,32.90,14);
        Livro livro12 = new Livro("O Processo",12,"Companhia das Letras", Categoria.ROMANCE,1925,43.00,15);
        Livro livro13 = new Livro("A Metamorfose",13," L&PM Editores", Categoria.FICÇÃO,1915,26.90,18);
        Livro livro14 = new Livro("A Revolução dos Bichos",14,"Companhia das Letras", Categoria.SÁTIRA,1945,35.90,9);
        Livro livro15 = new Livro("O Retrato de Dorian Gray",15,"Penguin Classics", Categoria.ROMANCE,1890,38.90,7);
        Livro livro16 = new Livro("A Menina que Roubava Livros",16,"Intrínseca", Categoria.FICÇÃO_HISTÓRICA,2005,49.90,5);
        Livro livro17 = new Livro("O Hobbit",17,"WMF Martins Fontes", Categoria.FANTASIA,1937,44.00,16);
        Livro livro18 = new Livro("O Pequeno Príncipe",17,"Agir", Categoria.CONTO,1943,19.90,11);

        livros.add(livro1);
        livros.add(livro2);
        livros.add(livro3);
        livros.add(livro4);
        livros.add(livro5);
        livros.add(livro6);
        livros.add(livro7);
        livros.add(livro8);
        livros.add(livro9);
        livros.add(livro10);
        livros.add(livro11);
        livros.add(livro12);
        livros.add(livro13);
        livros.add(livro14);
        livros.add(livro15);
        livros.add(livro16);
        livros.add(livro17);
        livros.add(livro18);
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
    public String valorTotalEmEstoque(){
        NumberFormat monetario = NumberFormat.getCurrencyInstance();
        double valorTotal = 0;
        for (Livro livro:livros){
            valorTotal += livro.getValorTotal();
        }
        return monetario.format(valorTotal);
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
