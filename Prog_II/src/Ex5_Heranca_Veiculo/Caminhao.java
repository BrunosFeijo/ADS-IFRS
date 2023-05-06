package Ex5_Heranca_Veiculo;

public class Caminhao extends VeiculoTerrestre {
    private int eixos;
    private double peso;

    public Caminhao(String fabricante, String modelo, String pais, double posicaoX,
                    double posicaoY, double valor, int passageiro, String placa,
                    String dono, int eixos, double peso) {
        super(fabricante, modelo, pais, posicaoX, posicaoY, valor, passageiro, placa, dono);
        this.eixos = eixos;
        this.peso = peso;
    }

    public int getEixos() {
        return eixos;
    }

    public void setEixos(int eixos) {
        this.eixos = eixos;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void carga(double peso) {
        this.peso += peso;
    }

    public void descarga(double peso) {
        this.peso -= peso;
    }

    @Override
    public String toString() {
        return "\n" + super.toString() +
                "Eixos= " + eixos + "\n" +
                "Peso= " + peso + "kg\n";
    }
}
