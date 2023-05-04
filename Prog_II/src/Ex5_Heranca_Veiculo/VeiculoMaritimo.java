package Ex5_Heranca_Veiculo;

public class VeiculoMaritimo extends Veiculo {
    private String codigo;
    private String empresa;

    public VeiculoMaritimo(String fabricante, String modelo, String pais,
                           int posicaoX, int posicaoY, double valor,
                           int passageiro, String codigo, String empresa) {
        super(fabricante, modelo, pais, posicaoX, posicaoY, valor, passageiro);
        this.codigo = codigo;
        this.empresa = empresa;
    }
    public void compra(){

    }
}
