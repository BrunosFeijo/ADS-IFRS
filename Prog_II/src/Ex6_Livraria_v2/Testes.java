package Ex6_Livraria_v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Testes {
    public static void main(String[] args) {
        String arquivo = "teste.txt";
        String texto = Arquivos.leitor(arquivo);
//        if (texto.isEmpty()){
//            System.out.println("Arquivo vazio");
//        }else{
//            System.out.println(texto);
//        }
        String[] linhas = texto.split("\n");

        System.out.println(linhas[0]);


//        try (InputStream inputStream = Testes.class.getResourceAsStream(nomeArquivo)) {
//            if (inputStream != null) {
//                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
//                String linha;
//                while ((linha = reader.readLine()) != null) {
//                    System.out.println(linha);
//                }
//            } else {
//                System.out.println("Arquivo não encontrado: " + nomeArquivo);
//            }
//        } catch (IOException e) {
//            System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
//        }

    }
}
