package Ex7_SistemaBancario;

public class ContaPoupanca extends ContaBancaria {
    private double rendimento = 0.02;
    private int saquesMensais;

    public ContaPoupanca(Pessoa titular, Banco banco, String senha) {
        super(titular, banco, senha);
        this.saquesMensais = 3;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }

    public void novoMes() {
        System.out.println("Informe de rendimentos: +" + (saldo * rendimento));
        saldo += (saldo * rendimento);
        System.out.println("Novo Saldo: " + saldo);
        saquesMensais = 3;
    }

    public void saque() {
        if (saquesMensais != 0) {
            super.saque();
        } else {
            System.out.println("Excedeu o limites de saques neste mês");
        }
        saquesMensais -= 1;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("\n-------------------Conta Poupança------------------\n");
        stringBuilder.append("Banco: ").append(banco.getNome()).append("\n");
        stringBuilder.append("N° da Conta: ").append(String.format("%010d",nroConta)).append("\n");
        stringBuilder.append("Titular: ").append(titular.nome).append(" ").append(titular.sobrenome).append("\n");
        stringBuilder.append("Saldo: ").append(saldo).append("\n");
        stringBuilder.append("Taxa de Rendimento: ").append(rendimento).append("\n");
        stringBuilder.append("Saques disponíveis: ").append(saquesMensais).append("\n");

        return stringBuilder.toString();
    }
}
