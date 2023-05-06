package Ex5_Heranca_Veiculo;

public class Moto extends VeiculoTerrestre {
    private int cilindradas;

    public Moto(String fabricante, String modelo, String pais, double posicaoX, double posicaoY,
                double valor, int passageiro, String placa, String dono, int cilindradas) {
        super(fabricante, modelo, pais, posicaoX, posicaoY, valor, passageiro, placa, dono);
        this.cilindradas = cilindradas;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    @Override
    public String toString() {
        return "\n" + super.toString() +
                "Cilindradas=" + cilindradas + "\n";
    }
}
