package Projeto_Substituicao_Memoria_Cache;

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
        String texto = Registrador.requisitar(arquivo);
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
        resultado.append(juntarTextosFIFO(requisicao1)).append("\n");
        resultado.append("Eficiência: ").append(cache.informarEficiencia()).append("%").append("\n");
        System.out.println();
        cache.limpar();

        resultado.append("\n============ 2° Lista de Requisições - FIFO ============").append("\n");
        resultado.append(juntarTextosFIFO(requisicao2)).append("\n");
        resultado.append("Eficiência: ").append(cache.informarEficiencia()).append("%").append("\n");
        cache.limpar();

        resultado.append("\n============ 3° Lista de Requisições - FIFO ============").append("\n");
        resultado.append(juntarTextosFIFO(requisicao3)).append("\n");
        resultado.append("Eficiência: ").append(cache.informarEficiencia()).append("%").append("\n");
        cache.limpar();

        System.out.println(resultado); //Acompanhar resultado no terminal
        Registrador.registrar(arquivoSaida, resultado); // Gerar arquivo de texto com resultados

        //LRU
        resultado.append("\n============ 1° Lista de Requisições - LRU ============").append("\n");
        resultado.append(juntarTextosLRU(requisicao1)).append("\n");
        resultado.append("Eficiência: ").append(cache.informarEficiencia()).append("%").append("\n");
        System.out.println();
        cache.limpar();

        resultado.append("\n============ 2° Lista de Requisições - LRU ============").append("\n");
        resultado.append(juntarTextosLRU(requisicao2)).append("\n");
        resultado.append("Eficiência: ").append(cache.informarEficiencia()).append("%").append("\n");
        cache.limpar();

        resultado.append("\n============ 3° Lista de Requisições - LRU ============").append("\n");
        resultado.append(juntarTextosLRU(requisicao3)).append("\n");
        resultado.append("Eficiência: ").append(cache.informarEficiencia()).append("%").append("\n");
        cache.limpar();

        //LFU
        resultado.append("\n============ 1° Lista de Requisições - LFU ============").append("\n");
        resultado.append(juntarTextosLFU(requisicao1)).append("\n");
        resultado.append("Eficiência: ").append(cache.informarEficiencia()).append("%").append("\n");
        System.out.println();
        cache.limpar();

        resultado.append("\n============ 2° Lista de Requisições - LFU ============").append("\n");
        resultado.append(juntarTextosLFU(requisicao2)).append("\n");
        resultado.append("Eficiência: ").append(cache.informarEficiencia()).append("%").append("\n");
        cache.limpar();

        resultado.append("\n============ 3° Lista de Requisições - LFU ============").append("\n");
        resultado.append(juntarTextosLFU(requisicao3)).append("\n");
        resultado.append("Eficiência: ").append(cache.informarEficiencia()).append("%").append("\n");
        cache.limpar();

        System.out.println(resultado); //Acompanhar resultado no terminal
        Registrador.registrar(arquivoSaida, resultado); // Gerar arquivo de texto com resultados
    }

    public static String juntarTextosFIFO(char[] requisicoes) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        for (char requisicao : requisicoes) {
            stringBuilder.append(cache.FIFO(requisicao)).append("\n");
        }
        return stringBuilder.toString();
    }
    public static String juntarTextosLRU(char[] requisicoes) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        for (char requisicao : requisicoes) {
            stringBuilder.append(cache.LRU(requisicao)).append("\n");
        }
        return stringBuilder.toString();
    }
    public static String juntarTextosLFU(char[] requisicoes) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        for (char requisicao : requisicoes) {
            stringBuilder.append(cache.LFU(requisicao)).append("\n");
        }
        return stringBuilder.toString();
    }

}
