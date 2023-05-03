package Ex4_Livraria;

public class Livro {
    private String titulo;
    private int codigo;
    private String editora;
    private Categoria categoria;

    public Livro(String titulo, int codigo, String editora, Categoria categoria) {
        this.titulo = titulo;
        this.codigo = codigo;
        this.editora = editora;
        this.categoria = categoria;
    }
}
