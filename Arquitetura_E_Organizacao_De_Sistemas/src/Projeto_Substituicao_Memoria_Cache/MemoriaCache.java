package Projeto_Substituicao_Memoria_Cache;

public class MemoriaCache {
    private int misses;
    private int hits;
    private int tamanho;
    private char[] cache;

    public MemoriaCache() {
        this.misses = 0;
        this.hits = 0;
        this.tamanho = 0;
        this.cache = null;
    }
    public void limpar(){
        cache = null;
    }
}
