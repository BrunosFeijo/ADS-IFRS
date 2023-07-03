package Ex7_SistemaBancario;

import java.util.Scanner;

abstract class ContaBancaria {
    protected Pessoa titular;
    protected Banco banco;
    protected int nroConta;
    protected double saldo;
    protected String senha;

    public ContaBancaria(Pessoa titular, Banco banco, String senha) {
        this.titular = titular;
        this.banco = banco;
        this.nroConta = banco.criarConta(this);
        this.saldo = 0;
        this.senha = senha;
    }

    public boolean VerificaSenha(int senha) {
        return senha == Integer.parseInt(this.senha);
    }

    public boolean VerificaSenha() {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite a senha da conta: ");
        int senha = entrada.nextInt();
        return VerificaSenha(senha);
    }

    public void saque() {
        for (int i = 0; i < 3; i++) {
            if (VerificaSenha()) {
                Scanner entrada = new Scanner(System.in);
                System.out.print("Digite o valor que deseja sacar: R$");
                saque(entrada.nextInt());
                i = 3;
            } else {
                System.out.println("Senha incorreta");
                if (i == 2) System.out.println("Operação Cancelada!");
            }
        }
    }

    public boolean saque(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
            return true;
        } else {
            System.out.println("Saldo insuficiente");
            return false;
        }
    }

    public void deposito() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe o valor a ser depositado: R$");
        deposito(entrada.nextDouble());
    }

    public void deposito(double valor) {
        this.saldo += valor;
    }

    public void transferir() {
        transferir(BancosDisponiveis.procuraBanco());
    }

    public void transferir(Banco banco) {
        if (banco != null) {
            Scanner entrada = new Scanner(System.in);
            ContaBancaria contaBancaria;
            int nroConta;
            int valor;

            System.out.print("Para qual conta deseja tranferir? ");
            nroConta = entrada.nextInt();

            contaBancaria = banco.contemNroConta(nroConta);
            if (contaBancaria != null){
                for (int i = 0; i < 3; i++) {
                    if (VerificaSenha()) {
                        System.out.print("Digite o valor que deseja transferir: R$");
                        valor = entrada.nextInt();
                        if (saque(valor)){
                            contaBancaria.deposito(valor);
                            //banco.getContasBancarias().set(banco.getContasBancarias().indexOf(contaBancaria),contaBancaria);
                        }
                    } else {
                        System.out.println("Senha incorreta");
                        if (i == 2) System.out.println("Operação Cancelada!");
                    }
                }
            }else {
                System.out.println("Conta inválida!");
            }
        } else {
            System.out.println("Banco inválido");
        }
    }
}
