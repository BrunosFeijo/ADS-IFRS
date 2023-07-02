package Ex7_SistemaBancario;

import java.util.ArrayList;

public class Pessoa {
    public String nome;
    public String sobrenome;
    public int idade;
    private String cpf;
    private ArrayList<ContaBancaria> contasBancarias;

    public Pessoa(String nome, String sobrenome, int idade, String cpf,
                  ArrayList<ContaBancaria> contasBancarias) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.cpf = cpf;
        this.contasBancarias = contasBancarias;
        
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

    public void setContasBancarias(ContaBancaria contaBancaria) {
        this.contasBancarias.add(contaBancaria);
    }

    public void infoContas() {
        System.out.println(this.contasBancarias);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", idade=" + idade +
                ", cpf='" + cpf + '\'' +
                ", contasBancarias=" + contasBancarias +
                '}';
    }

}
