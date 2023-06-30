package Ex7_SistemaBancario;

public class ContaPoupanca extends ContaBancaria {
    private final double rendimento = 0.02;
    private int saquesMensais;

    public ContaPoupanca(Pessoa titular, Banco banco, int nroConta, double saldo,
                         String senha, double rendimento, int saquesMensais) {
        super(titular, banco, nroConta, saldo, senha);
        this.saquesMensais = 3;
    }

    public void novoMes(){
        System.out.println("Informe de rendimentos: +" + (saldo*rendimento));
        saldo += (saldo*rendimento);
        System.out.println("Novo Saldo: " + saldo);
        saquesMensais = 3;
    }

    public void saque(){
        if (saquesMensais != 0){
            super.saque();
        }else{
            System.out.println("Excedeu o limites de saques neste mês");
        }
        saquesMensais -= 1;
    }


    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "rendimento=" + rendimento +
                ", saquesMensais=" + saquesMensais +
                ", titular=" + titular +
                ", banco=" + banco +
                ", nroConta=" + nroConta +
                ", saldo=" + saldo +
                ", senha='" + senha + '\'' +
                '}';
    }
}
