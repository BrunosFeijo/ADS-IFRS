package Ex5_Heranca_Veiculo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Veiculo> lista = new ArrayList<>();
        lista.add(new Moto("Harley-Davidson", "Iron 883", "Estados Unidos",
                15.7, 30.0, 45000.0, 1, "GHI-9012",
                "Maria da Silva", 883));
        lista.add(new Caminhao("Volvo", "FH540", "Suécia", 25.2, 40.8,
                350000.0, 2, "DEF-5678", "José da Silva", 3, 30000.0));
        lista.add(new Carro("Fiat", "Uno", "Brasil", 10.5, 20.0,
                25000.0, 5, "ABC-1234", "João da Silva", "Flex",
                "Popular", 75));
        lista.add(new Aviao("Boeing", "747", "Estados Unidos", 100.0, 150.0, 200000000.0, 416, "JKL-3456", "Antônio da Silva", 913.0
        ));

        System.out.println(lista);

    }
}
