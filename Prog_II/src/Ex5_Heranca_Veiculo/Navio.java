package Ex5_Heranca_Veiculo;

public class Navio extends VeiculoMaritimo {
    private String nome;

    public Navio(String fabricante, String modelo, String pais, double posicaoX,
                 double posicaoY, double valor, int passageiro, String codigo,
                 String empresa, String nome) {
        super(fabricante, modelo, pais, posicaoX, posicaoY, valor, passageiro, codigo, empresa);
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public String toString() {
        return "\n" + super.toString() +
                "Nome= " + nome + "\n";
    }

}
