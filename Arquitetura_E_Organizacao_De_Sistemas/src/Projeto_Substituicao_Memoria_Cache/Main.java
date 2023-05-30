package Projeto_Substituicao_Memoria_Cache;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLOutput;

public class Main {
    static MemoriaCache cache = new MemoriaCache();
    public static void main(String[] args) {
        StringBuilder resultado = new StringBuilder();
        String arquivo = "teste.txt";
        String arquivoSaida = "Resultados.txt";
        String texto = Arquivo.leitor(arquivo);
        String[] linhas = texto.split("\n");

        if (texto.isEmpty()) {
            System.out.println("Arquivo vazio");
            System.exit(0);
        }
        char[] requisicao1 = linhas[0].toCharArray();
        char[] requisicao2 = linhas[1].toCharArray();
        char[] requisicao3 = linhas[2].toCharArray();

        resultado.append("============ 1° Lista de Requisições ============").append("\n\n");
        resultado.append(juntarTextos(requisicao1));

        cache.limpar();

        resultado.append("\n============ 2° Lista de Requisições ============").append("\n\n");
        resultado.append(juntarTextos(requisicao2));

        cache.limpar();

        resultado.append("\n============ 3° Lista de Requisições ============").append("\n\n");
        resultado.append(juntarTextos(requisicao3));

        cache.limpar();

        System.out.println(resultado);
        Arquivo.escritor(arquivoSaida, resultado);
    }
    public static String juntarTextos(char[] requisicoes){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        for(char requisicao: requisicoes){
            stringBuilder.append(cache.FIFO(requisicao)).append("\n");
        }

        return stringBuilder.toString();

    }
}
