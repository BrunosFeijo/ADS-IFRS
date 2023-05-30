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
        //Criar texto para gerar arquivo no final
        StringBuilder resultado = new StringBuilder();
        //Nome do arquivo com as requisições
        String arquivo = "Requisições.txt";
        //Nome do arquivo de saída
        String arquivoSaida = "Resultados.txt";
        //Ler arquivo com as requisições
        String texto = Arquivo.leitor(arquivo);
        //Separar grupo de requisições por linha
        String[] linhas = texto.split("\n");

        if (texto.isEmpty()) {
            System.out.println("Arquivo vazio");
            System.exit(0);
        }
        //Atribuir linhas de requisições a seus vetores
        char[] requisicao1 = linhas[0].toCharArray();
        char[] requisicao2 = linhas[1].toCharArray();
        char[] requisicao3 = linhas[2].toCharArray();

        //FIFO
        resultado.append("============ 1° Lista de Requisições - FIFO ============").append("\n");
        resultado.append(juntarTextos(requisicao1)).append("\n");
        resultado.append("Eficiência: ").append(cache.informarEficiencia()).append("%").append("\n");
        System.out.println();
        cache.limpar();

        resultado.append("\n============ 2° Lista de Requisições - FIFO ============").append("\n");
        resultado.append(juntarTextos(requisicao2)).append("\n");
        resultado.append("Eficiência: ").append(cache.informarEficiencia()).append("%").append("\n");
        cache.limpar();

        resultado.append("\n============ 3° Lista de Requisições - FIFO ============").append("\n");
        resultado.append(juntarTextos(requisicao3)).append("\n");
        resultado.append("Eficiência: ").append(cache.informarEficiencia()).append("%").append("\n");
        cache.limpar();

        System.out.println(resultado); //Acompanhar resultado no terminal
        Arquivo.escritor(arquivoSaida, resultado); // Gerar arquivo de texto com resultados
    }

    public static String juntarTextos(char[] requisicoes) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        for (char requisicao : requisicoes) {
            stringBuilder.append(cache.FIFO(requisicao)).append("\n");
        }
        return stringBuilder.toString();
    }

}
