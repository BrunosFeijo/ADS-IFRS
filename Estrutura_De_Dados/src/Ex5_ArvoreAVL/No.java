package Ex5_ArvoreAVL;

public class No {
    private int valor;
    private No direita;
    private No esquerda;
    private int fatorBalanceamento;

    public No(){

    }
    public No(int valor){
        this.valor = valor;
        direita = null;
        esquerda = null;
        fatorBalanceamento = 0;
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
}
