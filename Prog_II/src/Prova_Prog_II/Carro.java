package Prova_Prog_II;

public class Carro {
    protected String modelo;
    protected int ano;
    protected Pessoa proprietario;
    protected String observacoes;

    public Carro(String modelo, int ano, Pessoa proprietario) {
        this.modelo = modelo;
        this.ano = ano;
        this.proprietario = proprietario;
        this.observacoes = "Novo!! Cheirando a plástico!!";
    }
    public void alteraObservacoes(String observacoes){
        this.observacoes = observacoes;
    }
    public void info(){
        System.out.println("\n-----Dados do Carro-----");
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("Proprietario: " + proprietario.nomeCompleto
                + ", contato.: " + proprietario.telefone);
        System.out.println("Observações: " + observacoes);
    }


}
