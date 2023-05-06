package Ex5_Heranca_Veiculo;

public class VeiculoMaritimo extends Veiculo {
    private String codigo;
    private String empresa;

    public VeiculoMaritimo(String fabricante, String modelo, String pais,
                           double posicaoX, double posicaoY, double valor,
                           int passageiro, String codigo, String empresa) {
        super(fabricante, modelo, pais, posicaoX, posicaoY, valor, passageiro);
        this.codigo = codigo;
        this.empresa = empresa;
    }
    public void compra(){

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "\n" + super.toString() +
                "Codigo= " + codigo + "\n" +
                "Empresa= " + empresa + "\n";
    }
}
