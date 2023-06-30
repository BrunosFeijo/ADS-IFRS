package Ex5_ArvoreAVL;

public class No {
    private int valor;
    private No direita;
    private No esquerda;
    private int fatorBalanceamento;
    private boolean cresceu;
    private boolean diminuiu;

    public No(){

    }
    public No(int valor){
        this.valor = valor;
        direita = null;
        esquerda = null;
        fatorBalanceamento = 0;
        cresceu = false;
        diminuiu = false;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public int getFatorBalanceamento() {
        return fatorBalanceamento;
    }

    public void setFatorBalanceamento(int fatorBalanceamento) {
        this.fatorBalanceamento = fatorBalanceamento;
    }

    public boolean isCresceu() {
        return cresceu;
    }

    public void setCresceu(boolean cresceu) {
        this.cresceu = cresceu;
    }

    public boolean isDiminuiu() {
        return diminuiu;
    }

    public void setDiminuiu(boolean diminuiu) {
        this.diminuiu = diminuiu;
    }
}
