package Projeto_Substituicao_Memoria_Cache;

import java.util.Arrays;

public class MemoriaCache {
    private int misses;
    private int hits;
    private int tamanho;
    private char[] cache;
    private int[] aux;
    private int auxTroca;

    public MemoriaCache() {
        this.misses = 0;
        this.hits = 0;
        this.tamanho = 0;
        this.cache = new char[]{' ', ' ', ' ', ' '};
        this.aux = new int[]{0, 0, 0, 0};
        this.auxTroca = 0;
    }

    public void limpar() {
        for (int i = 0; i < cache.length; i++) {
            cache[i] = ' ';
            aux[i] = 0;
        }
        tamanho = 0;
        misses = 0;
        hits = 0;
        auxTroca = 0;
    }

    private int contadorFIFO() {
        if (auxTroca == 3) {
            auxTroca = 0;
            return 3;
        }
        return auxTroca++;
    }

    private boolean isCheio() {
        return tamanho == cache.length;
    }

    private boolean contem(char requisicao) {
        if (tamanho == 0) {
            misses++;
            return false;
        }
        for (int i = 0; i < tamanho; i++) {
            if (requisicao == cache[i]) {
                hits++;
                return true;
            }
        }
        misses++;
        return false;
    }

    public void LFU() {

    }

    public String FIFO(char requisicao) {
        if (!contem(requisicao)) {
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

    public String LRU(char requisicao) {
        int indice = requisicaoMaisAntiga();
        if (!contem(requisicao)) {
            if (isCheio()) {
                //Simular requisicao para memória pricipal
                cache[indice] = MemoriaPrincipal.getMemoriaPrincipal(requisicao);
                aux[indice] = ++auxTroca;
                return resumo(requisicao);
            } else {
                //Simular requisicao para memória pricipal
                cache[tamanho] = MemoriaPrincipal.getMemoriaPrincipal(requisicao);
                //inserir ordem de entrada na lista aux
                aux[tamanho++] = ++auxTroca;
                return resumo(requisicao);
            }
        }
        aux[indiceDaRequisicaoEncontrada(requisicao)] = ++auxTroca;

        return resumo(requisicao);
    }

    public int requisicaoMaisAntiga() {
        int menor = Integer.MAX_VALUE;
        int indice = 0;
        for (int i = 0; i < aux.length; i++) {
            if (menor > aux[i]) {
                menor = aux[i];
                indice = i;
            }
        }
        return indice;
    }
    public int indiceDaRequisicaoEncontrada(char requisicao){
        for (int i = 0; i < tamanho; i++) {
            if (requisicao == cache[i]) {
                return i;
            }
        }
        return 0;
    }

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
