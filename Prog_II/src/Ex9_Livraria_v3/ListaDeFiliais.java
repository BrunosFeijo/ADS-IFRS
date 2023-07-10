package Ex9_Livraria_v3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaDeFiliais {
    private static List<Livraria> listaDeFiliais = new ArrayList<>();
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
        String codigo = entrada.next();

        procuraCodLivro(codigo);
    }

    private static void procuraCodLivro(String codigo) {

    }

}
