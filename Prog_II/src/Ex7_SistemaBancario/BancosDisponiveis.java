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
        for(Banco banco: listaBancos){
            System.out.println(banco.getNroBanco() + " - " + banco.getNome());
        }
        System.out.println("-----------------------------------");
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

}
