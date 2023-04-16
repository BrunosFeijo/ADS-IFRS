package Ex2_CriarClasses;

public class Livro {
    String titulo;
    String isbn;
    double valor;
    String autor;
    String editora;
    int estoque;

    public Livro(String titulo, String isbn, double valor, String autor, String editora, int estoque) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.valor = valor;
        this.autor = autor;
        this.editora = editora;
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' + "\n" +
                "isbn='" + isbn + '\'' + "\n" +
                "valor= R$ " + valor + "\n" +
                "autor='" + autor + '\'' + "\n" +
                "editora='" + editora + '\'' + "\n" +
                "estoque=" + estoque +
                '}';
    }
}
