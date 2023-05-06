package Ex5_Heranca_Veiculo;

public class VeiculoAereo extends Veiculo {
    private String codigo;
    private double posicaoZ;
    private String empresa;

    public VeiculoAereo(String fabricante, String modelo, String pais,
                        double posicaoX, double posicaoY, double valor,
                        int passageiro, String codigo, double posicaoZ, String empresa) {
        super(fabricante, modelo, pais, posicaoX, posicaoY, valor, passageiro);
        this.codigo = codigo;
        this.posicaoZ = posicaoZ;
        this.empresa = empresa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPosicaoZ() {
        return posicaoZ;
    }

    public void setPosicaoZ(double posicaoZ) {
        this.posicaoZ = posicaoZ;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public void deslocamento() {
        super.deslocamento();
        posicaoZ++;
    }

    public void compra() {

    }

    @Override
    public String toString() {
        return "\n" + super.toString() +
                "Codigo= " + codigo + "\n" +
                "Posicao Z= " + posicaoZ + "\n" +
                "Empresa= " + empresa + "\n";
    }
}
