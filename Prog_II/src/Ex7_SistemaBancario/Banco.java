package Ex7_SistemaBancario;

import java.util.ArrayList;

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

    public void infoContas() {
        System.out.println(contasBancarias);
    }

    public int criarConta(ContaBancaria contaBancaria) {
        contasBancarias.add(contaBancaria);
        contaBancaria.titular.adicionarContaBancaria(contaBancaria);

        return ++numeroDeContas;
    }

    public void fecharConta(ContaBancaria contaBancaria) {
        if (contemConta(contaBancaria)) {
            contasBancarias.remove(contaBancaria);
            contaBancaria.titular.removerContaBancaria(contaBancaria);
            System.out.println("Conta fechada!");
        } else {
            System.out.println("Conta Bancária não encontrada!");
        }
    }

    private boolean contemConta(ContaBancaria contaBancaria) {
        return contasBancarias.contains(contaBancaria);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("-----Banco-----");
        stringBuilder.append("Nome: ").append(nome).append("\n");
        stringBuilder.append("CNPJ: ").append(cnpj).append("\n");
        stringBuilder.append("N°: ").append(nroBanco).append("\n");
        stringBuilder.append(contasBancarias);
        return stringBuilder.toString();
    }
}
