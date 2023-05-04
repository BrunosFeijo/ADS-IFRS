package Ex5_Heranca_Veiculo;

public class Submarino extends VeiculoMaritimo{
    private int posixaoZ;
    private double profundidadeMaxima;

    public Submarino(String fabricante, String modelo, String pais, int posicaoX,
                     int posicaoY, double valor, int passageiro, String codigo,
                     String empresa, int posixaoZ, double profundidadeMaxima) {
        super(fabricante, modelo, pais, posicaoX, posicaoY, valor, passageiro, codigo, empresa);
        this.posixaoZ = posixaoZ;
        this.profundidadeMaxima = profundidadeMaxima;
    }

    @Override
    public void deslocamento() {
        super.deslocamento();
        posixaoZ++;
    }
}
