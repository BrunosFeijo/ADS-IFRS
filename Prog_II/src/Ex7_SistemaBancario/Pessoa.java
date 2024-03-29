package Ex7_SistemaBancario;

import java.util.ArrayList;

public class Pessoa {
    public String nome;
    public String sobrenome;
    public int idade;
    private String cpf;
    private ArrayList<ContaBancaria> contasBancarias;

    public Pessoa(String nome, String sobrenome, int idade, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.cpf = cpf;
        this.contasBancarias = new ArrayList<>();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ArrayList<ContaBancaria> getContasBancarias() {
        return contasBancarias;
    }

    public void adicionarContaBancaria(ContaBancaria contaBancaria) {
        this.contasBancarias.add(contaBancaria);
    }

    public void removerContaBancaria(ContaBancaria contaBancaria) {this.contasBancarias.remove(contaBancaria);}

    public void infoContas() {
        System.out.println(this.contasBancarias);
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("------Cliente------\n");
        stringBuilder.append("Nome: ").append(nome).append(" ").append(sobrenome).append("\n");
        stringBuilder.append("Idade: ").append(idade).append("\n");
        stringBuilder.append("CPF: ").append(cpf).append("\n");
        stringBuilder.append(contasBancarias);
        return stringBuilder.toString();
    }

}
