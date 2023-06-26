package Ex5_ArvoreAVL;

public class ArvoreAVL {
    private No raiz;

    public ArvoreAVL() {
        raiz = null;
    }

    public void limparArvore() {
        raiz = null;
    }

    public No getRaiz() {
        return raiz;
    }

    public boolean isVazio() {
        return raiz == null;
    }

    public boolean adicionar(int valor) {
        if (!contem(valor)){
            adicionarVerificandoBalanceamento(valor, raiz);
            return true;
        }
        return false;
    }

    private No adicionarVerificandoBalanceamento(int valor, No noAtual) {
        if (isVazio()) {
            raiz = new No(valor);
        } else {
            noAtual.setCresceu(false);
            if (valor < noAtual.getValor()) {
                if (noAtual.getEsquerda() == null) {
                    noAtual.setEsquerda(new No(valor));
                    noAtual.setCresceu(true);
                } else {
                    noAtual.setEsquerda(adicionarVerificandoBalanceamento(valor, noAtual.getEsquerda()));
                }
                if (noAtual.isCresceu() || noAtual.getEsquerda().isCresceu()) {
                    noAtual.setFatorBalanceamento(noAtual.getFatorBalanceamento() - 1);
                    noAtual.setCresceu(true);
                }
            } else if (valor > noAtual.getValor()) {
                if (noAtual.getDireita() == null) {
                    noAtual.setDireita(new No(valor));
                    noAtual.setCresceu(true);
                    ;
                } else {
                    noAtual.setDireita(adicionarVerificandoBalanceamento(valor, noAtual.getDireita()));
                }
                if (noAtual.isCresceu() || noAtual.getDireita().isCresceu()) {
                    noAtual.setFatorBalanceamento(noAtual.getFatorBalanceamento() + 1);
                    noAtual.setCresceu(true);
                }
            }
            if (noAtual.getFatorBalanceamento() == 2 || noAtual.getFatorBalanceamento() == -2) {
                noAtual = defineRotacao(noAtual);
                noAtual.setCresceu(false);
            }
            return noAtual;
        }
        return noAtual;
    }

    public boolean remover(int valor) {
        if (contem(valor)) {
            buscaRemover(valor, raiz);
            return true;
        }
        return false;
    }

    private No buscaRemover(int valor, No noAtual) {
        noAtual.setDiminuiu(false);
        if (valor < noAtual.getValor()) {//menor
            noAtual.setEsquerda(buscaRemover(valor, noAtual.getEsquerda()));
            if (noAtual.getEsquerda() == null) {
                noAtual.setFatorBalanceamento(noAtual.getFatorBalanceamento() + 1);
                noAtual.setDiminuiu(true);
            }else if(noAtual.getEsquerda().isDiminuiu() && noAtual.getEsquerda().getFatorBalanceamento() == 0){
                noAtual.setFatorBalanceamento(noAtual.getFatorBalanceamento() + 1);
                noAtual.setDiminuiu(true);
            }
        } else if (valor > noAtual.getValor()) {//maior
            noAtual.setDireita(buscaRemover(valor, noAtual.getDireita()));
            if (noAtual.getDireita() == null) {
                noAtual.setFatorBalanceamento(noAtual.getFatorBalanceamento() - 1);
                noAtual.setDiminuiu(true);
            }else if(noAtual.getDireita().isDiminuiu() && noAtual.getDireita().getFatorBalanceamento() == 0){
                noAtual.setFatorBalanceamento(noAtual.getFatorBalanceamento() - 1);
                noAtual.setDiminuiu(true);
            }
        } else if (noAtual.getValor() == valor) {//explícito
            noAtual = removerNo(noAtual);
            return noAtual;
        }
        if (noAtual.getFatorBalanceamento() == 2 || noAtual.getFatorBalanceamento() == -2) {
            noAtual = defineRotacao(noAtual);
            noAtual.setDiminuiu(true);
        }
        return noAtual;
    }

    private No removerNo(No noAtual) {
        if (noAtual.getEsquerda() == null && noAtual.getDireita() == null) { // ambos filhos nulos
            if (noAtual.equals(raiz)){
                raiz = null;
            }
            return null;
        } else if (noAtual.getEsquerda() == null) { // filho da esquerda nulo
            No noFilho = noAtual.getDireita();
            noFilho.setDiminuiu(true);
            return noFilho;
        } else if ((noAtual.getDireita() == null)) { // filho da direita nulo
            No noFilho = noAtual.getEsquerda();
            noFilho.setDiminuiu(true);
            return noFilho;
        } else { // sem filhos nulos
            int valor = getFolha(noAtual);
            noAtual.setValor(valor);
            noAtual.setDireita(buscaRemover(valor, noAtual.getDireita()));
            if (noAtual.getDireita() == null){
                noAtual.setFatorBalanceamento(noAtual.getFatorBalanceamento() - 1);
                noAtual.setDiminuiu(true);
            }else if(noAtual.getDireita().isDiminuiu() && noAtual.getDireita().getFatorBalanceamento() == 0){
                noAtual.setFatorBalanceamento(noAtual.getFatorBalanceamento() - 1);
                noAtual.setDiminuiu(true);
            }
        }
        return noAtual;
    }

    private int getFolha(No noAtual) {
        noAtual = noAtual.getDireita();
        while (noAtual.getEsquerda() != null) {
            noAtual = noAtual.getEsquerda();
        }
        return noAtual.getValor();
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


    public String imprimirPreOrdem(No noAtual) {
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
            stringBuilder.append(imprimirPosOrdem(noAtual.getEsquerda()));
            stringBuilder.append(imprimirPosOrdem(noAtual.getDireita()));
            stringBuilder.append(noAtual.getValor()).append(" ");
        }
        return stringBuilder.toString();
    }

    public String imprimirEmOrdem(No noAtual) {
        StringBuilder stringBuilder = new StringBuilder();
        if (noAtual != null) {
            stringBuilder.append(imprimirEmOrdem(noAtual.getEsquerda()));
            stringBuilder.append(noAtual.getValor()).append(" ");
            stringBuilder.append(imprimirEmOrdem(noAtual.getDireita()));
        }
        return stringBuilder.toString();
    }

    private String imprimirArvoreDePastas(No noAtual, String identacao, boolean ultimo) {
        StringBuilder stringBuilder = new StringBuilder();
        if (noAtual != null) {
            stringBuilder.append(identacao);
            if (!ultimo) {
                stringBuilder.append("|-");
                identacao += "|   ";
            } else {
                stringBuilder.append("|_");
                identacao += "   ";
            }
            stringBuilder.append(noAtual.getValor()).append("\n");
            stringBuilder.append(imprimirArvoreDePastas(noAtual.getEsquerda(), identacao, false));
            stringBuilder.append(imprimirArvoreDePastas(noAtual.getDireita(), identacao, true));
        }
        return stringBuilder.toString();
    }

    private void rotacaoDireita(No noAtual) {
        No noAux = noAtual.getEsquerda();
        noAtual.setEsquerda(noAux.getDireita());
        noAux.setDireita(noAtual);

        if (raiz.getValor() == noAtual.getValor()) {
            raiz = noAux;
        }
    }

    private void rotacaoEsquerda(No noAtual) {
        No noAux = noAtual.getDireita();
        noAtual.setDireita(noAux.getEsquerda());
        noAux.setEsquerda(noAtual);

        if (raiz.getValor() == noAtual.getValor()) {
            raiz = noAux;
        }
    }

    private No rotacaoDireitaEsquerda(No noAtual) {
        No noFilho = noAtual.getDireita();
        No noNeto = noFilho.getEsquerda();
        noAtual.setDireita(noNeto);
        rotacaoDireita(noFilho);
        rotacaoEsquerda(noAtual);

        return noNeto;
    }


    private No rotacaoEsquerdaDireita(No noAtual) {
        No noFilho = noAtual.getEsquerda();
        No noNeto = noFilho.getDireita();
        noAtual.setEsquerda(noNeto);
        rotacaoEsquerda(noFilho);
        rotacaoDireita(noAtual);

        return noNeto;
    }

    private No defineRotacao(No noAtual) {
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
                return rotacaoEsquerdaDireita(noAtual);
            }
            return noFilho;
        } else if (noAtual.getFatorBalanceamento() == 2) {
            noFilho = noAtual.getDireita();
            if (noFilho.getFatorBalanceamento() == 1) { // filho com um a mais na direita
                noAtual.setFatorBalanceamento(0);
                noFilho.setFatorBalanceamento(0);
                rotacaoEsquerda(noAtual);
            } else if (noFilho.getFatorBalanceamento() == 0) { // filho com dois netos
                noAtual.setFatorBalanceamento(1);
                noFilho.setFatorBalanceamento(-1);
                rotacaoEsquerda(noAtual);
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
                return rotacaoDireitaEsquerda(noAtual);
            }
            return noFilho;
        }
        return null;
    }

    @Override
    public String toString() {
        return imprimirArvoreDePastas(raiz, "", true);
    }
}
