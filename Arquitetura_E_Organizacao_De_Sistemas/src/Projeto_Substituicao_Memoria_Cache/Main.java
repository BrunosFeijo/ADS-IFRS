package Projeto_Substituicao_Memoria_Cache;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
//        String arquivo = "teste.txt";
//        String texto = Arquivo.leitor(arquivo);
//        String[] linhas = texto.split("\n");
//
//        if (texto.isEmpty()) {
//            System.out.println("Arquivo vazio");
//            System.exit(0);
//        }
//        char[] requisicao1 = linhas[0].toCharArray();
//        char[] requisicao2 = linhas[1].toCharArray();
//        char[] requisicao3 = linhas[2].toCharArray();
//
//
//        System.out.println(requisicao1);
//        System.out.println(requisicao2);
//        System.out.println(requisicao3);

        MemoriaCache cache = new MemoriaCache();

        System.out.println(cache);
        cache.FIFO('A');
        System.out.println(cache);
        cache.FIFO('B');
        System.out.println(cache);
        cache.FIFO('D');
        System.out.println(cache);
        cache.FIFO('C');
        System.out.println(cache);
        cache.FIFO('C');
        System.out.println(cache);
        cache.FIFO('F');
        System.out.println(cache);
        cache.FIFO('D');
        System.out.println(cache);
        cache.FIFO('E');
        System.out.println(cache);
    }
}
