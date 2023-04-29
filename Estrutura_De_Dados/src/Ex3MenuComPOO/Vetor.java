package Ex3MenuComPOO;

public class Vetor {
    private int[] vetor;
    private int tamanho;

    Vetor(){
        vetor = new int[10];
        tamanho = 0;
    }
    Vetor(int qtd){
        vetor = new int[qtd];
        tamanho = 0;
    }

    public void preencherVetor(){

    }
    public void preencherVetorOrdenado(){
        preencherVetor();

    }
    public void inserirValor(int valor){

    }
    public void inserirValor(int valor, int posicao){

    }
    public int informarValorNaPosicao(){

        return 0;
    }
    public int getTamanho(){
        return tamanho;
    }
    public int getTamanhoMaximo(){
        return vetor.length;
    }
    



}
