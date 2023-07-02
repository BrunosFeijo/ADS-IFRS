package Ex7_SistemaBancario;

public class ContaCorrente extends ContaBancaria {
    private double taxasMensais = 0.52;

    public ContaCorrente(Pessoa titular, Banco banco, double saldo, String senha, double taxasMensais) {
        super(titular, banco, saldo, senha);
    }

    public void novoMes() {
        if (saldo >= taxasMensais){
            saldo -= taxasMensais;
        }else{
            saldo = 0;
        }
        System.out.println("Cobrada a taxa mensal da conta: R$" + taxasMensais);
        System.out.println("Novo Saldo: R$" + saldo);
    }

    public void setTaxasMensais(double taxasMensais) {
        this.taxasMensais = taxasMensais;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        //System.out.println("Banco: " + Banco.nome);
        //System.out.println("Número da conta: " + NroConta);
        //System.out.println("Titular: " + titular.nome + " " + titular.sobrenome);
        stringBuilder.append("Saldo: R$").append(saldo).append("\n");
        stringBuilder.append("Taxas mensais: ").append(taxasMensais).append("\n");
        return stringBuilder.toString();
    }
}
