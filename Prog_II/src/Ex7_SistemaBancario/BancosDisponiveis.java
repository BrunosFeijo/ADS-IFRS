package Ex7_SistemaBancario;

import java.util.ArrayList;
import java.util.Scanner;

public class BancosDisponiveis {
    static ArrayList<Banco> listaBancos = new ArrayList<>();

    public static void adicionaBanco(Banco banco){
        listaBancos.add(banco);
    }

    public static Banco procuraBanco(){
        Scanner entrada = new Scanner(System.in);

        System.out.println("----------Bancos Disponíveis----------");
        for(Banco banco: listaBancos){
            System.out.println(banco.getNroBanco() + " - " + banco.getNome());
        }
        System.out.println("--------------------------------------");
        System.out.print("Digite o n° do Banco: ");

        return procuraBanco(entrada.nextInt());

    }
    public static Banco procuraBanco(int nroBanco){
        for(Banco banco: listaBancos){
            if (banco.getNroBanco() == nroBanco){
                return banco;
            }
        }
        return null;
    }
    public static Banco getBanco(int indice){
        return listaBancos.get(indice);
    }
    public static Pessoa procuraPessoa(){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite o CPF da pessoa procurada: ");
        int cpf = entrada.nextInt();

        return procuraPessoa(cpf);
    }
    public static Pessoa procuraPessoa(int cpf){
        for(Banco banco: listaBancos){
            for(ContaBancaria contaBancaria: banco.getContasBancarias()){
                if (contaBancaria.titular.getCpf().equals(String.valueOf(cpf))){
                    return contaBancaria.titular;
                }
            }
        }
        return null;
    }
    public static void novoMes(){
        for(Banco banco: listaBancos){
            for (ContaBancaria contaBancaria: banco.getContasBancarias()){
                if(contaBancaria.getClass().getSimpleName().equalsIgnoreCase("ContaCorrente")){
                    ContaCorrente corrente = (ContaCorrente)contaBancaria;
                    corrente.novoMes();
                }else {
                    ContaPoupanca poupanca = (ContaPoupanca) contaBancaria;
                    poupanca.novoMes();
                }
            }
        }
    }
    public static String listarContas(){
        StringBuilder stringBuilder = new StringBuilder("\n--------------Todas as Contas--------------\n");
        for (Banco banco: listaBancos){
            for (ContaBancaria contaBancaria:banco.getContasBancarias()){
                stringBuilder.append(contaBancaria).append("\n");
            }
        }

        return stringBuilder.toString();
    }

}
