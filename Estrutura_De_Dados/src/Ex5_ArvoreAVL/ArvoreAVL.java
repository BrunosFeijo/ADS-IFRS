package Ex5_ArvoreAVL;

public class ArvoreAVL {
    private No raiz;

    public ArvoreAVL() {
        raiz = null;
    }

    public void limparArvore() {

    }

    public No getRaiz() {
        return raiz;
    }

    public boolean isVazio() {
        return raiz == null;
    }

    public void adicionar(int valor) {
        boolean cresceu = false;
        adicionarVerificandoBalanceamento(valor, raiz, cresceu);
    }

    public void remover(int valor) {
    }

    public void buscaRemover(int valor, No noAtual, boolean diminuiu) {
    }

    public void deletarNo(No noAtual, boolean isDiminuiu) {
    }

    public void getFilho(int valor, No aux) {
    }

    public boolean buscar(int valor) {
        return true;
    }

    public String imprimirPreOrdem() {
        return null;
    }

    public String imprimirPosOrdem() {
        return null;
    }

    public String imprimirEmOrdem() {
        return null;
    }

    private void rotacaoDireita(No noAtual) {
    }

    private void rotacaoEsquerda(No noAtual) {
    }

    private void rotacaoDireitaEsquerda(No noAtual) {
    }

    private void rotacaoEsquerdaDireita(No noAtual) {
    }

    private void defineRotacao(No noAtual) {
    }

    private void adicionarVerificandoBalanceamento(int valor, No noAtual, boolean isCresceu) {
    }
}
