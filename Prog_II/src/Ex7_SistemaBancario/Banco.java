package Ex7_SistemaBancario;

import java.util.ArrayList;

public class Banco {
    private String nome;
    private String cnpj;
    private int nroBanco;
    private ArrayList<ContaBancaria> contasBancarias;

    public Banco(String nome, String cnpj, int nroBanco,
                 ArrayList<ContaBancaria> contasBancarias) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.nroBanco = nroBanco;
        this.contasBancarias = contasBancarias;
    }
    public void infoContas(){

    }
    public void criarConta(ContaBancaria contaBancaria){
        contasBancarias.add(contaBancaria);
    }
    public void fecharConta(ContaBancaria contaBancaria){
        if (contemConta(contaBancaria)){
            contasBancarias.remove(contaBancaria);
            System.out.println("Conta fechada!");
        }else {
            System.out.println("Conta Bancária não encontrada!");
        }
    }
    private boolean contemConta(ContaBancaria contaBancaria){
        return contasBancarias.contains(contaBancaria);
    }
}
