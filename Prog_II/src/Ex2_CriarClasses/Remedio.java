package Ex2_CriarClasses;

public class Remedio {
    String nome;
    String tarja;
    double valor;
    String laboratorio;
    int estoque;

    public Remedio(String nome, String tarja, double valor, String laboratorio, int estoque) {
        this.nome = nome;
        this.tarja = tarja;
        this.valor = valor;
        this.laboratorio = laboratorio;
        this.estoque = estoque;
    }

    public void novoValor(double valor){
        this.valor = valor;
    }
    public void novoEstoque(int estoque){
        this.estoque = estoque;
    }
    public void incrementaEstoque(int estoque){
        this.estoque += estoque;
    }
    public void decrementaEstoque(int estoque){
        this.estoque -= estoque;
    }

    @Override
    public String toString() {
        return "Remedio{" +
                "nome='" + nome + '\'' + "\n" +
                "tarja='" + tarja + '\'' + "\n" +
                "valor= R$ " + valor + "\n" +
                "laboratorio='" + laboratorio + '\'' + "\n" +
                "estoque=" + estoque +
                '}';
    }
}

