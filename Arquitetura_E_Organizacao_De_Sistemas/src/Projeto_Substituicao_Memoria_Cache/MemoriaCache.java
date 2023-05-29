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
    private List<Integer> aux ;
    private int auxTrocaFIFO;

    public MemoriaCache() {
        this.misses = 0;
        this.hits = 0;
        this.tamanho = 0;
        this.cache = new char[4];
        this.aux = Arrays.asList(1,2,3,4);
        this.auxTrocaFIFO = 0;
    }
    public void limpar(){
        for (char data:cache) {
            data = '\0';
        }
        tamanho = 0;
        misses = 0;
        hits = 0;
        aux.clear();
    }
    private int getAuxTrocaFIFO(){
        if (auxTrocaFIFO == 3){
            auxTrocaFIFO = 0;
            return 3;
        }
        return auxTrocaFIFO++;
    }
    private boolean isCheio(){
        return tamanho == cache.length;
    }
    private boolean contem(char requisicao){
        if (tamanho == 0){
            misses++;
            return false;
        }
        for (int i = 0; i < tamanho;i++){
            if (requisicao == cache[i]){
                hits++;
                return true;
            }
        }
        return false;
    }
    public void LFU(){

    }
    public void FIFO(char requisicao){
        if (!contem(requisicao)) {
            if (isCheio()){
                //Simular requisicao para memória pricipal
                cache[getAuxTrocaFIFO()] = MemoriaPrincipal.getMemoriaPrincipal(requisicao);
            }else{
                cache[tamanho++]= requisicao;
            }
        }
    }
    public void LRU(){

    }


}
