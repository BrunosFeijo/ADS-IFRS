package Projeto_Substituicao_Memoria_Cache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IllegalFormatCodePointException;
import java.util.List;

public class MemoriaCache {
    private int misses;
    private int hits;
    private int tamanho;
    private char[] cache;
    private List<Integer> aux;
    private int auxTrocaFIFO;

    public MemoriaCache() {
        this.misses = 0;
        this.hits = 0;
        this.tamanho = 0;
        this.cache = new char[]{' ', ' ', ' ', ' '};
        this.aux = Arrays.asList(1, 2, 3, 4);
        this.auxTrocaFIFO = 0;
    }

    public void limpar() {
        for (int i = 0; i < cache.length; i++) {
            cache[i] = ' ';
        }
        tamanho = 0;
        misses = 0;
        hits = 0;

        if (aux.isEmpty()) aux.clear();
    }

    private int getAuxTrocaFIFO() {
        if (auxTrocaFIFO == 3) {
            auxTrocaFIFO = 0;
            return 3;
        }
        return auxTrocaFIFO++;
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
                cache[getAuxTrocaFIFO()] = MemoriaPrincipal.getMemoriaPrincipal(requisicao);
                return resumo(requisicao);
            } else {
                cache[tamanho++] = requisicao;
                return resumo(requisicao);
            }
        }
        return resumo(requisicao);
    }

    public void LRU() {

    }

    public String resumo(char requisicao) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(Arrays.toString(cache)).append(" <- ").append(requisicao)
                .append(" | Misses: ").append(misses)
                .append(" | Hits: ").append(hits);

        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return Arrays.toString(cache);
    }
}
