package Projeto_Substituicao_Memoria_Cache;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream arquivo = new FileInputStream("src/teste.txt")
            Scanner entrada = new Scanner(arquivo);
            char vetor[];
            String linha;
            while (entrada.hasNextLine()) {
                linha = entrada.nextLine();
                System.out.println(linha);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
