import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;

public class Testes {
    public static void main(String[] args) {
        ArrayList<Pessoa> nomes = new ArrayList<>();
        Consumer<String> print = System.out::println;
        nomes.add(new Pessoa("Bruno"));
        nomes.add(new Pessoa("Victoria"));
        nomes.add(new Pessoa("Gabriel"));
        nomes.add(new Pessoa("Rafael"));

        nomes.stream().map(Pessoa::getNome).forEach(print);
    }
}

