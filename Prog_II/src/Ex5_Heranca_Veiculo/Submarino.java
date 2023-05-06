package Ex5_Heranca_Veiculo;

public class Submarino extends VeiculoMaritimo{
    private int posixaoZ;
    private double profundidadeMaxima;

    public Submarino(String fabricante, String modelo, String pais, double posicaoX,
                     double posicaoY, double valor, int passageiro, String codigo,
                     String empresa, int posixaoZ, double profundidadeMaxima) {
        super(fabricante, modelo, pais, posicaoX, posicaoY, valor, passageiro, codigo, empresa);
        this.posixaoZ = posixaoZ;
        this.profundidadeMaxima = profundidadeMaxima;
    }

    public int getPosixaoZ() {
        return posixaoZ;
    }

    public void setPosixaoZ(int posixaoZ) {
        this.posixaoZ = posixaoZ;
    }

    public double getProfundidadeMaxima() {
        return profundidadeMaxima;
    }

    public void setProfundidadeMaxima(double profundidadeMaxima) {
        this.profundidadeMaxima = profundidadeMaxima;
    }

    @Override
    public void deslocamento() {
        super.deslocamento();
        posixaoZ++;
    }

    @Override
    public String toString() {
        return "\n" + super.toString() +
                "Posixao Z= " + posixaoZ + "\n" +
                "Profundidade Maxima= " + profundidadeMaxima +"\n";
    }
}
