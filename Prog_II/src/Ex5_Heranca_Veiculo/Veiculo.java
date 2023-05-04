package Ex5_Heranca_Veiculo;

public class Veiculo {
    private String fabricante;
    private String modelo;
    private String pais;
    private int posicaoX;
    private int posicaoY;
    private double valor;
    private int passageiro;

    public Veiculo(String fabricante, String modelo, String pais,
                   int posicaoX, int posicaoY, double valor, int passageiro) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.pais = pais;
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        this.valor = valor;
        this.passageiro = passageiro;
    }
    public void deslocamento(){
        posicaoX++;
        posicaoY++;
    }
}
