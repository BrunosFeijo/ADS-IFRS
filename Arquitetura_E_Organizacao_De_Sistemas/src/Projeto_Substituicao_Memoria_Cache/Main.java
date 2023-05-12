package Projeto_Substituicao_Memoria_Cache;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        try {
            File arquivo = new File("src/Projeto_Substituicao_Memoria_Cache/teste.txt");
            Path pasta = arquivo.toPath();
            String[] vetor;
            String linha = Files.readString(pasta);
            while (linha != null) {
                System.out.println(linha);
                vetor = linha.split(",");
                linha = Files.readString(pasta);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
