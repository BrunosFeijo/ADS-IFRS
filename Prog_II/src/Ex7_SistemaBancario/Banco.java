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
    
}
