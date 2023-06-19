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
        adicionarVerificandoBalanceamento(valor, raiz);
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

    private void removerNo(No noAtual, boolean diminuiu) {
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

    private int getFolha(No noAux) {
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
        No noAux = noAtual.getDireita();
        rotacaoDireita(noAux);
        rotacaoEsquerda(noAtual);
    }

    private void rotacaoEsquerdaDireita(No noAtual) {
        No noAux = noAtual.getEsquerda();
        rotacaoEsquerda(noAux);
        rotacaoDireita(noAtual);
    }

    private void defineRotacao(No noAtual) {
        No noFilho;
        No noAux; // em caso de rotação dupla

        if (noAtual.getFatorBalanceamento() == -2) { // dois a mais na esquerda
            noFilho = noAtual.getEsquerda();
            if (noFilho.getFatorBalanceamento() == -1) { // filho com um a mais na esquerda
                noAtual.setFatorBalanceamento(0);
                noFilho.setFatorBalanceamento(0);
                rotacaoDireita(noAtual);
            } else if (noFilho.getFatorBalanceamento() == 0) { // filho com dois netos
                noAtual.setFatorBalanceamento(-1);
                noFilho.setFatorBalanceamento(1);
                rotacaoDireita(noAtual);
            } else if (noFilho.getFatorBalanceamento() == 1) {// filho com um a mais na direita // rotação dupla
                noAux = noFilho.getDireita();
                if (noAux.getFatorBalanceamento() == 0) { // neto sem filhos
                    noAtual.setFatorBalanceamento(0);
                    noFilho.setFatorBalanceamento(0);
                } else if (noAux.getFatorBalanceamento() == 1) { // neto com um filho a direita
                    noAtual.setFatorBalanceamento(0);
                    noFilho.setFatorBalanceamento(-1);
                } else if (noAux.getFatorBalanceamento() == -1) { // neto com um filho a esquerda
                    noAtual.setFatorBalanceamento(1);
                    noFilho.setFatorBalanceamento(0);
                }
                noAux.setFatorBalanceamento(0);
                rotacaoEsquerdaDireita(noAtual);
            }

        } else if (noAtual.getFatorBalanceamento() == 2) {
            noFilho = noAtual.getDireita();
            if (noFilho.getFatorBalanceamento() == 1) { // filho com um a mais na direita
                noAtual.setFatorBalanceamento(0);
                noFilho.setFatorBalanceamento(0);
                rotacaoDireita(noAtual);
            } else if (noFilho.getFatorBalanceamento() == 0) { // filho com dois netos
                noAtual.setFatorBalanceamento(1);
                noFilho.setFatorBalanceamento(-1);
                rotacaoDireita(noAtual);
            } else if (noFilho.getFatorBalanceamento() == -1) {// filho com um a mais na esquerda // rotação dupla
                noAux = noFilho.getEsquerda();
                if (noAux.getFatorBalanceamento() == 0) { // neto sem filhos
                    noAtual.setFatorBalanceamento(0);
                    noFilho.setFatorBalanceamento(0);
                } else if (noAux.getFatorBalanceamento() == 1) { // neto com um filho a direita
                    noAtual.setFatorBalanceamento(-1);
                    noFilho.setFatorBalanceamento(0);
                } else if (noAux.getFatorBalanceamento() == -1) { // neto com um filho a esquerda
                    noAtual.setFatorBalanceamento(0);
                    noFilho.setFatorBalanceamento(1);
                }
                noAux.setFatorBalanceamento(0);
                rotacaoDireitaEsquerda(noAtual);
            }
        }

    }

    private void adicionarVerificandoBalanceamento(int valor, No noAtual) {
        if (isVazio()) {
            raiz = new No(valor);
        } else {
            if (valor < noAtual.getValor()) {
                if (noAtual.getEsquerda() == null) {
                    noAtual.setEsquerda(new No(valor));
                    noAtual.setFatorBalanceamento(noAtual.getFatorBalanceamento() - 1);
                } else {
                    adicionarVerificandoBalanceamento(valor, noAtual.getEsquerda());
                }
            } else {
                if (noAtual.getDireita() == null) {
                    noAtual.setDireita(new No(valor));
                    noAtual.setFatorBalanceamento(noAtual.getFatorBalanceamento() + 1);
                } else {
                    adicionarVerificandoBalanceamento(valor, noAtual.getDireita());
                }
            }
            defineRotacao(noAtual);
        }
    }
}
