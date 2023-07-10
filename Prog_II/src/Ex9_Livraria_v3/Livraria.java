package Ex9_Livraria_v3;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Livraria {
    protected List<Livro> livros;

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

        System.out.print("Informe o gênero literário do livro: ");
        String categoria = entrada.nextLine();

        System.out.print("Informe o ano do livro: ");
        int ano = entrada.nextInt();

        System.out.print("Informe o valor do livro: ");
        double valor = entrada.nextDouble();

        System.out.print("Informe a quantidade em estoque do livro: ");
        int qtd = entrada.nextInt();

        Livro livro = new Livro(titulo, codigo, editora, categoria, ano, valor, qtd);
        cadastrarLivro(livro);

        System.out.println("Livro cadastrado com sucesso!\n");
    }

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
        ListaDeFiliais.cadastrarLivro(livro);
    }

    public void bibliotecaPadrao() {
        Livro livro1 = new Livro("1984", 1, "Companhia das Letras", "Distopia", 1949, 39.90, 7);
        Livro livro2 = new Livro("Dom Quixote", 2, "Penguin Classics", "Conto", 1605, 45.00, 12);
        Livro livro3 = new Livro("Cem Anos de Solidão", 3, "Record", "Realismo Mágico", 1967, 59.90, 7);
        Livro livro4 = new Livro("Orgulho e Preconceito", 4, "Martin Claret", "Romance", 1813, 29.90, 9);
        Livro livro5 = new Livro("O Senhor dos Anéis: A Sociedade do Anel", 5, "Martins Fontes", "Fantasia", 1954, 1954, 2);
        Livro livro6 = new Livro("Moby Dick", 6, "Zahar", "Conto", 1851, 49.90, 21);
        Livro livro7 = new Livro("Crime e Castigo", 7, "L&PM Editores", "Romance", 1866, 39.90, 30);
        Livro livro8 = new Livro("O Grande Gatsby", 8, "Penguin Books", "Ficção Contemporânea", 1925, 42.00, 4);
        Livro livro9 = new Livro("O Morro dos Ventos Uivantes", 9, "Nova Fronteira", "Romance", 1847, 36.00, 9);
        Livro livro10 = new Livro("Ulisses", 10, "Penguin Modern Classics", "Romance", 1922, 58.00, 13);
        Livro livro11 = new Livro("O Apanhador no Campo de Centeio", 11, "Editora do Autor", "Romance", 1951, 32.90, 14);
        Livro livro12 = new Livro("O Processo", 12, "Companhia das Letras", "Romance", 1925, 43.00, 15);
        Livro livro13 = new Livro("A Metamorfose", 13, " L&PM Editores", "Ficção", 1915, 26.90, 18);
        Livro livro14 = new Livro("A Revolução dos Bichos", 14, "Companhia das Letras", "Sátira", 1945, 35.90, 9);
        Livro livro15 = new Livro("O Retrato de Dorian Gray", 15, "Penguin Classics", "Romance", 1890, 38.90, 7);
        Livro livro16 = new Livro("A Menina que Roubava Livros", 16, "Intrínseca", "Ficção Histórica", 2005, 49.90, 5);
        Livro livro17 = new Livro("O Hobbit", 17, "WMF Martins Fontes", "Fantasia", 1937, 44.00, 16);
        Livro livro18 = new Livro("O Pequeno Príncipe", 18, "Agir", "Conto", 1943, 19.90, 11);

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
    public Livro buscaPorTitulo() {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Informe o nome do livro procurado: ");

        return buscaPorTitulo(entrada.nextLine());
    }

    public Livro buscaPorTitulo(String nome) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(nome)) return livro;
        }
        return null;
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

    private double informarValor() {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Informe valor limite: $");

        return entrada.nextDouble();
    }

    public String buscaPorCategoria() {
        StringBuilder stringBuilder = new StringBuilder();
        String genero = informarCategoria();
        if (genero.equals("Categoria não encontrada!")) return genero;

        for (Livro livro : livros) {
            if (genero.equals(livro.getCategoria())) stringBuilder.append(livro).append("\n");
        }
        return stringBuilder.toString();
    }

    private String informarCategoria() {
        Scanner entrada = new Scanner(System.in);
        String[] categorias = new String[livros.size()];
        int tamanho = 0;

        //guardar categorias não duplicadas
        for (Livro livro : livros) {
            boolean categoriaExiste = false;
            for (int j = 0; j < tamanho; j++) {
                if (livro.getCategoria().equals(categorias[j])) {
                    categoriaExiste = true;
                    j = tamanho;
                }
            }
            if (!categoriaExiste) {
                categorias[tamanho++] = livro.getCategoria();
            }
        }
        //listar categorias
        for (int j = 0; j < tamanho; j++) {
            System.out.println(j + " - " + categorias[j]);
        }

        System.out.print("Informe a categoria do livro procurado: ");
        int indice = entrada.nextInt();
        if (indice >= 0 && indice < tamanho) {
            return categorias[indice];
        }
        return "Categoria não encontrada!";
    }

    public String buscaPorQuantidadeEmEstoque() {
        int qtd = informarQuantidadeEmEstoque();
        StringBuilder stringBuilder = new StringBuilder();

        for (Livro livro : livros) {
            if (qtd <= livro.getQtd()) stringBuilder.append(livro).append("\n");
        }
        return stringBuilder.toString();
    }

    private int informarQuantidadeEmEstoque() {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Informe a quantidade buscada: ");

        return entrada.nextInt();
    }

    public String valorTotalEmEstoque() {
        NumberFormat monetario = NumberFormat.getCurrencyInstance();
        double valorTotal = 0;
        for (Livro livro : livros) {
            valorTotal += livro.getValorTotal();
        }
        return monetario.format(valorTotal);
    }

    public String formatoEntreVirgulas() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Livro livro : livros) {
            stringBuilder.append(livro.getCodigo()).append(",")
                    .append(livro.getTitulo()).append(",")
                    .append(livro.getAno()).append(",")
                    .append(livro.getCategoria()).append(",")
                    .append(livro.getEditora()).append(",")
                    .append("R$").append(String.format("%.2f", livro.getValor()).replace(",", ".")).append(",")
                    .append(livro.getQtd()).append("\n");
        }
        return stringBuilder.toString();
    }

    public boolean adicionarLote(String texto) {
        String[] linhas = texto.split("\n");
        if (linhas.length != 0) {
            for (String linha : linhas) {
                String[] linhaAtual = linha.split(",");
                boolean livroExiste = false;
                //Verificar se o código do livro já existe. Neste caso somente atualizar dados (valor e qtd)
                for (Livro livro : livros) {
                    if (Integer.parseInt(linhaAtual[0]) == livro.getCodigo()) {
                        livroExiste = true;
                        livro.setValor(Double.parseDouble(linhaAtual[5].replace("R$", "")));
                        livro.setQtd(Integer.parseInt(linhaAtual[6]));
                        break;
                    }
                }
                //Se não existir adicionar livro
                if (!livroExiste) {
                    cadastrarLivro(new Livro(linhaAtual[1], Integer.parseInt(linhaAtual[0]),
                            linhaAtual[4], linhaAtual[3], Integer.parseInt(linhaAtual[2]),
                            Double.parseDouble(linhaAtual[5].replace("R$", "")), Integer.parseInt(linhaAtual[6])));
                }
            }
            return true;
        }
        return false;
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
