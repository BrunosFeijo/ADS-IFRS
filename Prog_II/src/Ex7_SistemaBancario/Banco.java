package Ex7_SistemaBancario;

import java.util.ArrayList;
import java.util.Scanner;

public class Banco {
    private String nome;
    private String cnpj;
    private int nroBanco;
    private ArrayList<ContaBancaria> contasBancarias;
    private int numeroDeContas;

    public Banco(String nome, String cnpj, int nroBanco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.nroBanco = nroBanco;
        this.contasBancarias = new ArrayList<>();
        this.numeroDeContas = 0;
        BancosDisponiveis.adicionaBanco(this);
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public int getNroBanco() {
        return nroBanco;
    }

    public ArrayList<ContaBancaria> getContasBancarias() {
        return contasBancarias;
    }

    public void infoContas() {
        System.out.println(contasBancarias);
    }

    public int criarConta(ContaBancaria contaBancaria) {
        contasBancarias.add(contaBancaria);
        contaBancaria.titular.adicionarContaBancaria(contaBancaria);

        return ++numeroDeContas;
    }

    public void fecharConta(ContaBancaria contaBancaria) {
        contasBancarias.remove(contaBancaria);
        contaBancaria.titular.removerContaBancaria(contaBancaria);
        System.out.println("Conta fechada!");
    }

    private boolean contemConta(ContaBancaria contaBancaria) {
        return contasBancarias.contains(contaBancaria);
    }

    public ContaBancaria procuraConta(){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite o número da conta procurada: ");
        int nroConta = entrada.nextInt();

        return procuraConta(nroConta);
    }
    public ContaBancaria procuraConta(int nroConta) {
        for (ContaBancaria conta : contasBancarias) {
            if (conta.nroConta == nroConta) {
                 return conta;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("-----Banco-----\n");
        stringBuilder.append("Nome: ").append(nome).append("\n");
        stringBuilder.append("CNPJ: ").append(cnpj).append("\n");
        stringBuilder.append("N°: ").append(nroBanco).append("\n");
        stringBuilder.append(contasBancarias);
        return stringBuilder.toString();
    }
}
