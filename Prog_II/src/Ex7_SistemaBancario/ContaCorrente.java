package Ex7_SistemaBancario;

public class ContaCorrente extends ContaBancaria {
    private double taxasMensais = 0.52;

    public ContaCorrente(Pessoa titular, Banco banco, String senha) {
        super(titular, banco, senha);
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
        StringBuilder stringBuilder = new StringBuilder("-------------------Conta Corrente------------------\n");
        stringBuilder.append("Banco: ").append(banco.getNome()).append("\n");
        stringBuilder.append(String.format("Número da conta: %010d", nroConta)).append("\n");
        stringBuilder.append("Titular: ").append(titular.nome).append(" ").append(titular.sobrenome).append("\n");
        stringBuilder.append("Saldo: R$").append(saldo).append("\n");
        stringBuilder.append("Taxas mensais: ").append(taxasMensais).append("\n");
        return stringBuilder.toString();
    }
}
