package Prova_Prog_II;

import java.util.Scanner;

public class Pessoa {
    protected String nomeCompleto;
    protected String telefone;

    public Pessoa(String nomeCompleto, String telefone) {
        this.nomeCompleto = nomeCompleto;
        this.telefone = telefone;
    }
    public void alteraContatos(){
        Scanner entrada = new Scanner(System.in);
        String telNovo;

        System.out.print("Digite um novo telefone para contato: ");
        telNovo = entrada.next();

        alteraContatos(telNovo);
    }
    public void alteraContatos(String telNovo){
        this.telefone = telNovo;
    }
    public void info(){
        System.out.println("\n-------Dados Pessoa------");
        System.out.println("Nome completo: " + nomeCompleto);
        System.out.println("Contato: " + telefone);
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getTelefone() {
        return telefone;
    }
}
