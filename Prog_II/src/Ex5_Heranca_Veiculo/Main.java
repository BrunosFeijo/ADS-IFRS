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
        lista.add(new Aviao("Airbus", "A320", "França", 80.0, 120.0,
                100000000.0, 180, "AB1234", 35.5, "Latam", 870));
        lista.add(new Helicoptero("Robinson Helicopter Company", "R44 Raven II",
                "Estados Unidos", 60.0, 90.0, 500000.0, 4,
                "CD5678", 25.0, "UberCopter", 2));
        lista.add(new Navio("Mitsubishi Heavy Industries, Ltd.", "Diamond Princess",
                "Japão", 150.0, 220.0, 500000000.0, 2670,
                "DP9876", "Princess Cruises", "Diamond Princess"));
        lista.add(new Submarino("Naval Group", "Scorpène", "França", 230.0,
                150.0, 1000000000.0, 36, "SG1234", "Marinha do Brasil",
                200.0, 300.0));
        
        System.out.println(lista);

    }
}
