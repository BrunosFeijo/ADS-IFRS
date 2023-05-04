package Ex5_Heranca_Veiculo;

public class Aviao extends VeiculoAereo{
    public Aviao(String fabricante, String modelo, String pais, int posicaoX,
                 int posicaoY, double valor, int passageiro, String codigo,
                 int posicaoZ, String empresa) {
        super(fabricante, modelo, pais, posicaoX, posicaoY, valor, passageiro, codigo, posicaoZ, empresa);
    }
}
