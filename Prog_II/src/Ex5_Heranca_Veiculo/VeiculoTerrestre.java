package Ex5_Heranca_Veiculo;

public class VeiculoTerrestre extends Veiculo {
    private String placa;
    private String dono;

    public VeiculoTerrestre(String fabricante, String modelo, String pais,
                            double posicaoX, double posicaoY, double valor,
                            int passageiro, String placa, String dono) {
        super(fabricante, modelo, pais, posicaoX, posicaoY, valor, passageiro);
        this.placa = placa;
        this.dono = dono;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getDono() {
        return dono;
    }
    public void setDono(String dono) {
        this.dono = dono;
    }
    public void emplacamento(String placa) {
        this.placa = placa;
    }
    public void compra() {
    }
    @Override
    public String toString() {
        return "\n" + super.toString() +
                "Placa= " + placa + "\n" +
                "Dono= " + dono + "\n";
    }
}
