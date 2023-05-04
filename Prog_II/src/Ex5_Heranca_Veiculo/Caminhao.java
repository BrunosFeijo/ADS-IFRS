package Ex5_Heranca_Veiculo;

public class Caminhao extends VeiculoTerrestre{
    private int eixos;
    private double peso;

    public Caminhao(String fabricante, String modelo, String pais, int posicaoX,
                    int posicaoY, double valor, int passageiro, String placa,
                    String dono, int eixos, double peso) {
        super(fabricante, modelo, pais, posicaoX, posicaoY, valor, passageiro, placa, dono);
        this.eixos = eixos;
        this.peso = peso;
    }
    public void carga(double peso){
            this.peso += peso;
    }
    public void descarga(double peso){
        this.peso -= peso;
    }
}
