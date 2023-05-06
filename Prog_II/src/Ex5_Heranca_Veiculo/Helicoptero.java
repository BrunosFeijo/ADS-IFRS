package Ex5_Heranca_Veiculo;

public class Helicoptero extends VeiculoAereo{
    private int rotores;

    public Helicoptero(String fabricante, String modelo, String pais,
                       double posicaoX, double posicaoY, double valor, int passageiro,
                       String codigo, double posicaoZ, String empresa, int rotores) {
        super(fabricante, modelo, pais, posicaoX, posicaoY, valor, passageiro, codigo, posicaoZ, empresa);
        this.rotores = rotores;
    }

    public int getRotores() {
        return rotores;
    }

    public void setRotores(int rotores) {
        this.rotores = rotores;
    }

    @Override
    public String toString() {
        return "\n" + super.toString() +
                "Rotores= " + rotores + "\n";
    }
}
