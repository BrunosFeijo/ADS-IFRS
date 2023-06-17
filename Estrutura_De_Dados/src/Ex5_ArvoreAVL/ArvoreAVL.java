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

    public boolean remover(int valor) {
        boolean diminuiu = false;
        return buscaRemover(valor, raiz, diminuiu);
    }

    public boolean buscaRemover(int valor, No noAtual, boolean diminuiu) {
        if (noAtual.getValor() > valor) {
            buscaRemover(valor, noAtual.getEsquerda(), diminuiu);
            if (diminuiu) {
                noAtual.setFatorBalanceamento(noAtual.getFatorBalanceamento() + 1);
            }
        } else if (noAtual.getValor() < valor) {
            buscaRemover(valor, noAtual.getDireita(), diminuiu);
            if (diminuiu) {
                noAtual.setFatorBalanceamento(noAtual.getFatorBalanceamento() - 1);
            }
        } else if(noAtual.getValor() == valor){
            removerNo(noAtual, diminuiu);
            return true;
        }
        if (noAtual != null) {
            defineRotacao(noAtual);
            if (diminuiu && noAtual.getFatorBalanceamento() != 0) diminuiu = false;
        }
        return false;
    }

    public void removerNo(No noAtual, boolean diminuiu) {
        No noAux = noAtual;
        if (noAtual.getEsquerda() == null){
            noAtual = noAtual.getDireita();
            diminuiu = true;
        }else if(noAtual.getDireita() == null){
            noAtual = noAtual.getEsquerda();
            diminuiu = true;
        }else {
            
        }
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
