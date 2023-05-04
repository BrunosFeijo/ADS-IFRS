package Ex5_Heranca_Veiculo;

public class Helicoptero extends VeiculoAereo{
    private int rotores;

    public Helicoptero(String fabricante, String modelo, String pais,
                       int posicaoX, int posicaoY, double valor, int passageiro,
                       String codigo, int posicaoZ, String empresa, int rotores) {
        super(fabricante, modelo, pais, posicaoX, posicaoY, valor, passageiro, codigo, posicaoZ, empresa);
        this.rotores = rotores;
    }
}
