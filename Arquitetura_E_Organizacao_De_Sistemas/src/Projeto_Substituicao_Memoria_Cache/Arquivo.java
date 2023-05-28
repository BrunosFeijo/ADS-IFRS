package Projeto_Substituicao_Memoria_Cache;

import java.io.*;

public class Arquivo {
    public static String leitor(String caminho) {
        StringBuilder texto = null;

        try {
            FileReader arquivo = new FileReader(caminho);
            BufferedReader lerArquivo = new BufferedReader(arquivo);
            String linha;
            try {
                linha = lerArquivo.readLine();
                while (linha != null) {
                    texto.append(linha).append("\n");
                    linha = lerArquivo.readLine();
                }
                arquivo.close();
                return texto.toString();

            } catch (IOException e) {
                System.out.println("Erro: não foi possível ler arquivo");
                return "";
            }
        } catch (FileNotFoundException e) {
            System.out.println("Erro: arquivo não encontrado");
            return "";
        }
    }

    public static boolean escritor(String caminho, String texto) {
        try {
            FileWriter arquivo = new FileWriter(caminho);
            PrintWriter escreverArquivo = new PrintWriter(arquivo);
            escreverArquivo.println(texto);
            escreverArquivo.close();
            return true;
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado");
            return false;
        }
    }

}

