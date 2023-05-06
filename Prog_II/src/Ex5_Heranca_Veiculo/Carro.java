package Ex5_Heranca_Veiculo;

public class Carro extends VeiculoTerrestre{
    private String combustivel;
    private String classe;
    private double potencia;

    public Carro(String fabricante, String modelo, String pais, double posicaoX,
                 double posicaoY, double valor, int passageiro, String placa,
                 String dono, String combustivel, String classe, double potencia) {
        super(fabricante, modelo, pais, posicaoX, posicaoY, valor, passageiro, placa, dono);
        this.combustivel = combustivel;
        this.classe = classe;
        this.potencia = potencia;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return "\n" + super.toString() +
                "Combustivel= " + combustivel + "\n" +
                "Classe= " + classe + "\n" +
                "Potencia= " + potencia + "\n";
    }
}
