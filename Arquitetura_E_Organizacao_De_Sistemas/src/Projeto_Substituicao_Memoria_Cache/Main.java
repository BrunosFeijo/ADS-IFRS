package Projeto_Substituicao_Memoria_Cache;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        MemoriaCache cache = new MemoriaCache();

        String arquivo = "teste.txt";
        String texto = Arquivo.leitor(arquivo);
        String[] linhas = texto.split("\n");

        if (texto.isEmpty()) {
            System.out.println("Arquivo vazio");
            System.exit(0);
        }
        char[] requisicao1 = linhas[0].toCharArray();
        char[] requisicao2 = linhas[1].toCharArray();
        char[] requisicao3 = linhas[2].toCharArray();

        System.out.println("============ 1° Lista de Requisições ============");
        for(char requisicao: requisicao1){
            System.out.println(cache.FIFO(requisicao));
        }
        cache.limpar();
        System.out.println();
        System.out.println("============ 2° Lista de Requisições ============");
        for(char requisicao: requisicao2){
            System.out.println(cache.FIFO(requisicao));
        }
        cache.limpar();
        System.out.println();
        System.out.println("============ 3° Lista de Requisições ============");
        for(char requisicao: requisicao3){
            System.out.println(cache.FIFO(requisicao));
        }
    }
}
