package Ex7_SistemaBancario;

import java.util.ArrayList;
import java.util.Scanner;

public class BancosDisponiveis {
    private ArrayList<Banco> listaBancos;

    public BancosDisponiveis() {
        this.listaBancos = new ArrayList<>();
    }
    public void adicionaBanco(Banco banco){
        listaBancos.add(banco);
    }
    public Banco procuraBanco(){
        Scanner entrada = new Scanner(System.in);
        for(Banco banco: listaBancos){
            System.out.println(banco.getNroBanco() + " - " + banco.getNome());
        }
        System.out.println("-----------------------------------");
        System.out.print("Digite o n° do Banco: ");

        return procuraBanco(entrada.nextInt());

    }
    public Banco procuraBanco(int nroBanco){

        for(Banco banco: listaBancos){
            if (banco.getNroBanco() == nroBanco){
                return banco;
            }
        }
        return null;
    }

}
