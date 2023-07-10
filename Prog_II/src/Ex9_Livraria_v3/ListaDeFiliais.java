package Ex9_Livraria_v3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaDeFiliais {
    private static List<Filial> listaDeFiliais = new ArrayList<>();
    private static List<Livro> livrosCadastrados = new ArrayList<>();


    public static void cadastrarFilial(Filial filial) {
        listaDeFiliais.add(filial);
    }

    public static void cadastrarLivro(Livro livro) {
        if (!livrosCadastrados.contains(livro)) livrosCadastrados.add(livro);
    }

    public static void procuraCodLivro() {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite o código do livro (apenas números): ");
        int codigo = entrada.nextInt();

        procuraCodLivro(codigo);
    }

    private static String procuraCodLivro(int codigo) {
        StringBuilder stringBuilder = new StringBuilder();
        String titulo = null;
        double valorTotal = 0;

        for(Livro livro:livrosCadastrados){
            if (livro.getCodigo() == codigo){
                stringBuilder.append(">>>>> Cod#").append(livro.getCodigo()).append("\n");
                stringBuilder.append("Título/Editora: ").append(livro.getTitulo()).append("/").append(livro.getEditora()).append("\n");
                stringBuilder.append("Categoria: ").append(livro.getCategoria()).append("\n");
                stringBuilder.append("Ano: ").append(livro.getAno()).append("\n");
                titulo = livro.getTitulo();
                System.out.println();
                break;
            }
        }
        if (titulo == null) {
            return "Código não encontrado";
        }else{
            for (Filial filial:listaDeFiliais){
                Livro livro = filial.buscaPorTitulo(titulo);
                if (livro != null){
                    stringBuilder.append("Valor: R$").append(String.format("%.2f",livro.getValor())).append(" >>> ")
                            .append("Filial: ").append(filial.getNome()).append(", estoque: ").append(livro.getQtd()).append(" unidades")
                            .append("\n");;
                    valorTotal += livro.getValorTotal();
                }
            }
            stringBuilder.append("Valor total em estoque: R$").append(String.format("%.2f",valorTotal));
        }
        return stringBuilder.toString();
    }

}
