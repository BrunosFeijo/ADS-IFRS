package Ex5_Heranca_Veiculo;

public class VeiculoTerrestre extends Veiculo{
    private String placa;
    private String dono;

    public VeiculoTerrestre(String fabricante, String modelo, String pais,
                            int posicaoX, int posicaoY, double valor,
                            int passageiro, String placa, String dono) {
        super(fabricante, modelo, pais, posicaoX, posicaoY, valor, passageiro);
        this.placa = placa;
        this.dono = dono;
    }
    public void emplacamento(String placa){
        this.placa = placa;
    }
    public void compra(){

    }
}
