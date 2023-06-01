package Projeto_Substituicao_Memoria_Cache;

import java.util.Arrays;

public class MemoriaCache {
    private int misses;
    private int hits;
    private int tamanho;
    private char[] cache;
    private int[] auxLRU;
    private int[] auxLFU;

    private int auxTroca;

    public MemoriaCache() {
        this.misses = 0;
        this.hits = 0;
        this.tamanho = 0;
        this.cache = new char[]{' ', ' ', ' ', ' '};
        this.auxLRU = new int[]{0, 0, 0, 0};
        this.auxLRU = new int[]{0, 0, 0, 0};
        this.auxTroca = 0;
    }

    public void limpar() {
        for (int i = 0; i < cache.length; i++) {
            cache[i] = ' ';
            auxLRU[i] = 0;
            auxLFU[i] = 0;
        }
        tamanho = 0;
        misses = 0;
        hits = 0;
        auxTroca = 0;
    }


    private boolean isCheio() {
        return tamanho == cache.length;
    }

    private int procurar(char requisicao) {
        if (tamanho == 0) {
            misses++;
            return -1;
        }
        for (int i = 0; i < tamanho; i++) {
            if (requisicao == cache[i]) {
                hits++;
                return i;
            }
        }
        misses++;
        return -1;
    }

    public String FIFO(char requisicao) {
        int indice = procurar(requisicao);
        boolean contem = indice != -1;
        if (!contem) {
            if (isCheio()) {
                //Simular requisicao para memória pricipal
                cache[contadorFIFO()] = MemoriaPrincipal.getMemoriaPrincipal(requisicao);
                return resumo(requisicao);
            } else {
                //Simular requisicao para memória pricipal
                cache[tamanho++] = MemoriaPrincipal.getMemoriaPrincipal(requisicao);
                return resumo(requisicao);
            }
        }
        return resumo(requisicao);
    }

    private int contadorFIFO() {
        if (auxTroca == 3) {
            auxTroca = 0;
            return 3;
        }
        return auxTroca++;
    }

    public String LRU(char requisicao) {
        int indice = procurar(requisicao);
        boolean contem = indice != -1;
        if (!contem) {
            if (isCheio()) {
                indice = requisicaoMaisAntiga();
                //Simular requisicao para memória pricipal
                cache[indice] = MemoriaPrincipal.getMemoriaPrincipal(requisicao);
                auxLRU[indice] = ++auxTroca;
                return resumo(requisicao);
            } else {
                //Simular requisicao para memória pricipal
                cache[tamanho] = MemoriaPrincipal.getMemoriaPrincipal(requisicao);
                //inserir ordem de entrada na lista aux
                auxLRU[tamanho++] = ++auxTroca;
                return resumo(requisicao);
            }
        }
        auxLRU[indice] = ++auxTroca;

        return resumo(requisicao);
    }

    public int requisicaoMaisAntiga() {
        int menor = Integer.MAX_VALUE;
        int indice = 0;
        for (int i = 0; i < auxLRU.length; i++) {
            if (menor > auxLRU[i]) {
                menor = auxLRU[i];
                indice = i;
            }
        }
        return indice;
    }

    public String LFU(char requisicao) {
        int indice = procurar(requisicao);
        boolean contem = indice != -1;
        if (!contem) {
            if (isCheio()) {
                indice = indiceMenosFrequente();
                //Simular requisicao para memória pricipal
                cache[indice] = MemoriaPrincipal.getMemoriaPrincipal(requisicao);
                auxLFU[indice] = 1;
                auxLRU[indice] = ++auxTroca; //auxiliar para decidir troca após empate entre as frequências
                return resumo(requisicao);
            } else {
                //Simular requisicao para memória pricipal
                cache[tamanho] = MemoriaPrincipal.getMemoriaPrincipal(requisicao);
                auxLFU[tamanho]++;
                auxLRU[tamanho++] = ++auxTroca; //auxiliar para decidir troca após empate entre as frequências
                return resumo(requisicao);
            }
        }
        auxLFU[indice]++;
        auxLRU[indice] = ++auxTroca; //auxiliar para decidir troca após empate entre as frequências
        return resumo(requisicao);
    }

    public int indiceMenosFrequente() {
        int menor = Integer.MAX_VALUE;
        int indice = 0;
        for (int i = 0; i < auxLFU.length; i++) {
            if (menor > auxLFU[i]){
                menor = auxLFU[i];
                indice = i;
            }
        }
        return indice;
    }

//    public int indiceDaRequisicaoEncontrada(char requisicao) {
//        for (int i = 0; i < tamanho; i++) {
//            if (requisicao == cache[i]) {
//                return i;
//            }
//        }
//        return 0;
//    }

    public String resumo(char requisicao) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(Arrays.toString(cache)).append(" <- ").append(requisicao)
                .append(" | Misses: ").append(misses)
                .append(" | Hits: ").append(hits);

        return stringBuilder.toString();
    }

    public int getMisses() {
        return misses;
    }

    public int getHits() {
        return hits;
    }

    public String informarEficiencia() {
        return String.format("%.2f", ((double) getHits() / (getHits() + getMisses())) * 100) + "%";
    }

    @Override
    public String toString() {
        return Arrays.toString(cache);
    }
}
