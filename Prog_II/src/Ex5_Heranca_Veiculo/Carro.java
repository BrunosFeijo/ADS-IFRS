package Ex5_Heranca_Veiculo;

public class Carro extends VeiculoTerrestre{
    private double combustivel;
    private String classe;
    private double potencia;

    public Carro(String fabricante, String modelo, String pais, int posicaoX,
                 int posicaoY, double valor, int passageiro, String placa,
                 String dono, double combustivel, String classe, double potencia) {
        super(fabricante, modelo, pais, posicaoX, posicaoY, valor, passageiro, placa, dono);
        this.combustivel = combustivel;
        this.classe = classe;
        this.potencia = potencia;
    }

}
