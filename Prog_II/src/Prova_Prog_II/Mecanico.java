package Prova_Prog_II;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mecanico extends Pessoa{
    protected String especialidade;
    protected List<Servico> listaServicos;
    protected double salario;

    public Mecanico(String nomeCompleto, String telefone, String especialidade) {
        super(nomeCompleto,telefone);
        this.especialidade = especialidade;
        this.salario = 0;
        this.listaServicos = new ArrayList<>();
    }
    public void info(){
        calculaSalario();
        System.out.println("\n-----Dados do Mecânico-----");
        System.out.println("Nome completo: " + nomeCompleto);
        System.out.println("Contato.: " + telefone);
        System.out.println("Especialidade: " + especialidade);
        System.out.printf("Salário: R$%.2f\n", salario);
        if (!listaServicos.isEmpty()) {
            listarServicos();
        }else{
            System.out.println("Sem serviços alocados");
        }
    }
    public void listarServicos(){
        System.out.println("---Lista de Serviços---");
        for(Servico servico: listaServicos){
            System.out.println("ID: #" + servico.codigo);
            System.out.printf("Valor: R$%.2f\n", servico.valor);
            System.out.println("Carro: " + servico.carro.modelo + " / "
                    + servico.carro.ano + " / Prop: " + servico.carro.proprietario.nomeCompleto
                    + ", contato.: " + servico.carro.proprietario.telefone);
            System.out.println("Descricao do Serviço: " + servico.descricaoServico + "\n");
        }
    }
    public void limparListaServicos(){
        listaServicos.clear();
    }
    public void atribuirServico(Servico servico){
        listaServicos.add(servico);
    }
    public void alteraEspecialidade(){
        Scanner entrada = new Scanner(System.in);
        String especialidade;

        System.out.print("Digite uma nova especialidade: ");
        especialidade = entrada.nextLine();

        alteraEspecialidade(especialidade);
    }
    public void alteraEspecialidade(String novaEspecialidade){
        this.especialidade = novaEspecialidade;
    }
    public void calculaSalario(){
        double valorTotal = 0;
        for (Servico servico: listaServicos) valorTotal += servico.valor;

        this.salario = valorTotal;
    }

}

