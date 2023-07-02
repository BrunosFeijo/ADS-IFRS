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

    private ArrayList<ContaBancaria> getContasBancarias() {
        return contasBancarias;
    }

    public void infoContas() {
        System.out.println(getContasBancarias());
    }

    public int criarConta(ContaBancaria contaBancaria) {
        contasBancarias.add(contaBancaria);

        return ++numeroDeContas;
    }

    public void fecharConta(ContaBancaria contaBancaria) {
        if (contemConta(contaBancaria)) {
            contasBancarias.remove(contaBancaria);
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
        return "Banco{" +
                "nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", nroBanco=" + nroBanco +
                ", contasBancarias=" + contasBancarias +
                '}';
    }
}