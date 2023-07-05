package Prova_Prog_II;

import java.util.Scanner;

public class Servico {
    public int codigo;
    public double valor;
    public Mecanico mecanicoResponsavel;
    public Carro carro;
    public String descricaoServico;

    public Servico(int codigo, Mecanico mecanicoResponsavel,
                   Carro carro) {
        this.codigo = codigo;
        this.mecanicoResponsavel = mecanicoResponsavel;
        mecanicoResponsavel.atribuirServico(this);
        this.carro = carro;
        this.descricaoServico = "Esperando avaliação";
    }

    public void info() {
        System.out.println("\n-----Dados do Servico-----");
        System.out.println("ID: #" + codigo);
        System.out.printf("Valor: R$%.2f\n", valor);
        System.out.println("Carro: " + carro.modelo
                + " / " + carro.ano
                + " / Prop: " + carro.proprietario.nomeCompleto
                + ", contato.: " + carro.proprietario.telefone);
        System.out.println("Mecânico Responsável: " + mecanicoResponsavel.nomeCompleto);
        System.out.println("Descricao do Serviço: " + descricaoServico + "\n");
    }

    public void atualizaServico() {
        Scanner entrada = new Scanner(System.in);
        String descricao;
        double valor;

        System.out.print("Digite a descrição do serviço: ");
        descricao = entrada.nextLine();

        System.out.print("Digite o valor do servico: ");
        valor = entrada.nextDouble();

        atualizaServico(valor, descricao);
    }

    public void atualizaServico(double valor, String novaDescricao) {
        this.valor = valor;
        this.descricaoServico = novaDescricao;

        carro.alteraObservacoes("Última visita ao mecânico[" + novaDescricao + "]");
    }
}
