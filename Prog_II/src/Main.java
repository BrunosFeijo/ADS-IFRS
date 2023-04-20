import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> nomes = new ArrayList<>();
        nomes.add("Bruno");
        nomes.add("Camila");
        nomes.add("Ana");

        System.out.println(nomes);
        System.out.println("Tamanho: " + nomes.size());

        nomes.remove(1);

        System.out.println(nomes);
        System.out.println("Tamanho: " + nomes.size());
    }
}