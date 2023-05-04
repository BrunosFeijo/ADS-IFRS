package Ex5_Heranca_Veiculo;

public class VeiculoAereo extends Veiculo{
    private String codigo;
    private int posicaoZ;
    private String empresa;

    public VeiculoAereo(String fabricante, String modelo, String pais,
                        int posicaoX, int posicaoY, double valor,
                        int passageiro, String codigo, int posicaoZ, String empresa) {
        super(fabricante, modelo, pais, posicaoX, posicaoY, valor, passageiro);
        this.codigo = codigo;
        this.posicaoZ = posicaoZ;
        this.empresa = empresa;
    }

    @Override
    public void deslocamento() {
        super.deslocamento();
        posicaoZ++;
    }
    public void compra(){

    }
}
