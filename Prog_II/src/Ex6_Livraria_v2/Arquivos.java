package Ex6_Livraria_v2;

import java.io.*;

public class Arquivos {
    public static String leitor(String caminho){
        String texto = "";

        try {
            FileReader arquivo = new FileReader(caminho);
            BufferedReader lerArquivo = new BufferedReader(arquivo);
            String linha;
            try {
                linha = lerArquivo.readLine();
                while (linha != null) {
                    texto += linha + "\n";
                    linha = lerArquivo.readLine();
                }
                arquivo.close();
                return texto;
            } catch (IOException ex) {
                System.out.println("Erro: não foi possível ler arquivo!");
                return "";
            }
        }catch (FileNotFoundException ex){
            System.out.println("Erro: Arquivo não encontrado!");
            return "";
        }
    }
    public static boolean escritor(String caminho, String texto){
        try{
            FileWriter arquivo = new FileWriter(caminho);
            PrintWriter alterarArquivo = new PrintWriter(arquivo);
            alterarArquivo.println(texto);
            alterarArquivo.close();
            return true;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
