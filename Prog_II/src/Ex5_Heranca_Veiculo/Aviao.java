package Ex5_Heranca_Veiculo;

public class Aviao extends VeiculoAereo {
    private int velocidadeMaxima;

    public Aviao(String fabricante, String modelo, String pais, double posicaoX,
                 double posicaoY, double valor, int passageiro, String codigo,
                 double posicaoZ, String empresa, int acentos) {
        super(fabricante, modelo, pais, posicaoX, posicaoY, valor, passageiro, codigo, posicaoZ, empresa);
        this.velocidadeMaxima = acentos;
    }

    public int getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(int velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }

    @Override
    public String toString() {
        return "\n" + super.toString() + "Velocidade Máxima= " + velocidadeMaxima + "km/h\n";
    }
}
