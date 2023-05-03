import Ex4_Livraria.Categoria;
import Ex4_Livraria.Livro;

public class Main {
    public static void main(String[] args) {
        for (Categoria categoria: Categoria.values()){
            System.out.println(categoria.ordinal() + " - " + categoria);
        }
        int indice = 32;
        Categoria categoria = Categoria.values()[indice];
        System.out.println(categoria);
        System.out.println(Categoria.values().length);
    }
}