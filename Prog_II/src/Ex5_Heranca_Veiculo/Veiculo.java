package Ex5_Heranca_Veiculo;

public class Veiculo {
    protected String fabricante;
    protected String modelo;
    protected String pais;
    protected double posicaoX;
    protected double posicaoY;
    protected double valor;
    protected int passageiro;

    public Veiculo(String fabricante, String modelo, String pais,
                   double posicaoX, double posicaoY, double valor, int passageiro) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.pais = pais;
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        this.valor = valor;
        this.passageiro = passageiro;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getPosicaoX() {
        return posicaoX;
    }

    public void setPosicaoX(double posicaoX) {
        this.posicaoX = posicaoX;
    }

    public double getPosicaoY() {
        return posicaoY;
    }

    public void setPosicaoY(double posicaoY) {
        this.posicaoY = posicaoY;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(int passageiro) {
        this.passageiro = passageiro;
    }

    public void deslocamento() {
        posicaoX++;
        posicaoY++;
    }

    @Override
    public String toString() {
        return "Info: \n" +
                "Fabricante= " + fabricante + "\n" +
                "Modelo= " + modelo + "\n" +
                "País= " + pais + "\n" +
                "Posicao X= " + posicaoX + "\n" +
                "PosicaoY= " + posicaoY + "\n" +
                "Valor= " + valor + "\n" +
                "Acentos= " + passageiro + "\n";
    }
}
