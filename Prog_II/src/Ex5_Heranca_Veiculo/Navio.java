package Ex5_Heranca_Veiculo;

public class Navio extends VeiculoMaritimo{
    private String nome;

    public Navio(String fabricante, String modelo, String pais, int posicaoX,
                 int posicaoY, double valor, int passageiro, String codigo,
                 String empresa, String nome) {
        super(fabricante, modelo, pais, posicaoX, posicaoY, valor, passageiro, codigo, empresa);
        this.nome = nome;
    }
}
