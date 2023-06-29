package Ex7_SistemaBancario;

import java.util.Scanner;

abstract class ContaBancaria {
    protected Pessoa titular;
    protected Banco banco;
    protected int NroConta;
    protected double saldo;
    protected String senha;

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
    public void saque(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("Saque realizado");
        } else {
            System.out.println("Saldo insuficiente");
        }
    }
    public void deposito(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe o valor a ser depositado: R$");
        deposito(entrada.nextDouble());
    }
    public void deposito(double valor){
        this.saldo += valor;
        System.out.println("Deposito realizado");
    }
    

}
