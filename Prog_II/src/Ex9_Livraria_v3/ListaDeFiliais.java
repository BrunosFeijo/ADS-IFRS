package Ex9_Livraria_v3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaDeFiliais {
    private static List<Filial> listaDeFiliais = new ArrayList<>();
    private static List<Livro> livrosCadastrados = new ArrayList<>();

    public static void cadastrarFilial() {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite o código da Filial: ");
        String codigo = entrada.next();
        if ((codigo.length() == 1)) codigo = "0" + codigo;
        System.out.print("Digite o nome da Filial: ");
        String nome = entrada.nextLine();
        System.out.print("Digite o endereço da Filial: ");
        String endereco = entrada.nextLine();
        System.out.print("Digite o telefone de contato da Filial: ");
        String telefone = entrada.nextLine();

        cadastrarFilial(new Filial(codigo, nome, endereco, telefone));
    }

    public static void cadastrarFilial(Filial filial) {
        if (!listaDeFiliais.contains(filial)) listaDeFiliais.add(filial);
    }

    public static void cadastrarLivro(Livro livro) {
        if (!livrosCadastrados.contains(livro)) livrosCadastrados.add(livro);
    }

    public static String procuraCodLivro() {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite o código do livro (apenas números): ");
        int codigo = entrada.nextInt();

        return procuraCodLivro(codigo);
    }

    private static String procuraCodLivro(int codigo) {
        StringBuilder stringBuilder = new StringBuilder();
        String titulo = null;
        double valorTotal = 0;

        for (Livro livro : livrosCadastrados) {
            if (livro.getCodigo() == codigo) {
                stringBuilder.append(">>>>> Cod#").append(livro.getCodigo()).append("\n");
                stringBuilder.append("Título/Editora: ").append(livro.getTitulo()).append("/").append(livro.getEditora()).append("\n");
                stringBuilder.append("Categoria: ").append(livro.getCategoria()).append("\n");
                stringBuilder.append("Ano: ").append(livro.getAno()).append("\n");
                titulo = livro.getTitulo();
                break;
            }
        }
        if (titulo == null) {
            return "Código não encontrado";
        } else {
            for (Filial filial : listaDeFiliais) {
                Livro livro = filial.buscaPorTitulo(titulo);
                if (livro != null) {
                    stringBuilder.append("Valor: R$").append(String.format("%3.2f", livro.getValor())).append(" >>> ")
                            .append("Filial: ").append(filial.getNome()).append(", estoque: ").append(livro.getQtd()).append(" unidades")
                            .append("\n");
                    ;
                    valorTotal += livro.getValorTotal();
                }
            }
            stringBuilder.append("Valor total em estoque: R$").append(String.format("%.2f", valorTotal));
        }
        return stringBuilder.toString();
    }

    public static Filial escolherFilial() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("-----------Filiais Registradas-----------");
        for (Filial filial : listaDeFiliais) {
            System.out.println(filial.getCodigo() + " - " + filial.getNome());
        }
        System.out.println("-----------------------------------------");
        System.out.print("Digite o código da Filial (apenas números): ");
        String codigo = entrada.next();
        if ((codigo.length() == 1)) {
            codigo = "#FL0" + codigo;
        } else {
            codigo = "#FL" + codigo;
        }


        return escolherFilial(codigo);
    }

    public static Filial escolherFilial(String codigo) {
        for (Filial filial : listaDeFiliais) {
            if (filial.getCodigo().equals(codigo)) return filial;
        }

        return null;
    }
    public static List<Filial> getListaDeFiliais(){
        return listaDeFiliais;
    }

}
