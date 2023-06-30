package Ex7_SistemaBancario;

public class ContaCorrente extends ContaBancaria {
    private final double taxasMensais = 5.25;

    public ContaCorrente(Pessoa titular, Banco banco, int nroConta, double saldo, String senha, double taxasMensais) {
        super(titular, banco, nroConta, saldo, senha);
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
