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

    private boolean buscaRemover(int valor, No noAtual, boolean diminuiu) {
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
        } else if (noAtual.getValor() == valor) {
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
        if (noAtual.getEsquerda() == null) {
            noAtual = noAtual.getDireita();
            diminuiu = true;
        } else if (noAtual.getDireita() == null) {
            noAtual = noAtual.getEsquerda();
            diminuiu = true;
        } else {
            int valor = getFolha(noAtual);
            noAtual.setValor(valor);
            buscaRemover(valor, noAtual.getDireita(), diminuiu);
            if (diminuiu) noAtual.setFatorBalanceamento(noAtual.getFatorBalanceamento() - 1);
        }
    }

    public int getFolha(No noAux) {
        noAux = noAux.getDireita();
        while (noAux.getEsquerda() != null) {
            noAux = noAux.getEsquerda();
        }
        return noAux.getValor();
    }

    public boolean contem(int valor) {
        No noAtual = raiz;
        while (noAtual != null) {
            if (valor < noAtual.getValor()) {
                noAtual = noAtual.getEsquerda();
            } else if (valor > noAtual.getValor()) {
                noAtual = noAtual.getDireita();
            } else if (valor == noAtual.getValor()) {
                return true;
            }
        }
        return false;
    }


    private String imprimirPreOrdem(No noAtual) {
        StringBuilder stringBuilder = new StringBuilder();
        if (noAtual != null) {
            stringBuilder.append(noAtual.getValor()).append(" ");
            stringBuilder.append(imprimirPreOrdem(noAtual.getEsquerda()));
            stringBuilder.append(imprimirPreOrdem(noAtual.getDireita()));
        }
        return stringBuilder.toString();
    }

    public String imprimirPosOrdem(No noAtual) {
        StringBuilder stringBuilder = new StringBuilder();
        if (noAtual != null) {
            stringBuilder.append(imprimirPreOrdem(noAtual.getEsquerda()));
            stringBuilder.append(imprimirPreOrdem(noAtual.getDireita()));
            stringBuilder.append(noAtual.getValor()).append(" ");
        }
        return stringBuilder.toString();
    }

    public String imprimirEmOrdem(No noAtual) {
        StringBuilder stringBuilder = new StringBuilder();
        if (noAtual != null) {
            stringBuilder.append(imprimirPreOrdem(noAtual.getEsquerda()));
            stringBuilder.append(noAtual.getValor()).append(" ");
            stringBuilder.append(imprimirPreOrdem(noAtual.getDireita()));
        }
        return stringBuilder.toString();
    }

    private void rotacaoDireita(No noAtual) {
        No noAux = noAtual.getEsquerda();
        noAtual.setEsquerda(noAux.getDireita());
        noAux.setDireita(noAtual);
        noAtual = noAux;
    }

    private void rotacaoEsquerda(No noAtual) {
        No noAux = noAtual.getDireita();
        noAtual.setDireita(noAux.getEsquerda());
        noAux.setEsquerda(noAtual);
        noAtual = noAux;
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
