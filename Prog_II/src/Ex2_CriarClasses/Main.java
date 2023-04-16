package Ex2_CriarClasses;

public class Main {
    public static void main(String[] args) {
        Empresa empresa1 = new Empresa("Empresa 1", "01.234.567/0001-89", "Rua A, Bairro X, Cidade Alta", "Papelaria");
        Empresa empresa2 = new Empresa("Empresa 2", "01.234.567/0001-89", "Rua B, Bairro Y, Cidade Media", "Restaurante");
        Empresa empresa3 = new Empresa("Empresa 3", "01.234.567/0001-89", "Rua C, Bairro Z, Cidade Baixa", "Farmácia");

        Remedio remedio1 = new Remedio("Dipirona", "Vermelha", 10.0, "EMS", 30);
        Remedio remedio2 = new Remedio("Amoxicilina", "Vermelha", 15.0, "Aché", 15);
        Remedio remedio3 = new Remedio("Diazepam", "Preta", 20.0, "Medley", 40);

        Funcionario funcionario1 = new Funcionario("Bruno", " Feijó", "012.345.678-99", 2500.0, "Aux Adm");
        Funcionario funcionario2 = new Funcionario("Thais", " Maciel", "012.345.678-99", 3200.0, "Consultor");
        Funcionario funcionario3 = new Funcionario("Leonardo", " Brum", "012.345.678-99", 5000.0, "Analista II");

        Livro livro1 = new Livro("Cem Anos de Solidão", "9788535914849", 45.5, "Gabriel García Márquez", "Editora Record", 7);
        Livro livro2 = new Livro("Gabriel García Márquez", "9788533613676", 62.9, "J.R.R. Tolkien", "Editora Martins Fontes", 11);
        Livro livro3 = new Livro("A Garota que Você Deixou Para Trás", "9788581051092", 39.9, "Jojo Moyes", "Intrínseca", 3);

        System.out.println(empresa1 + "\n");
        System.out.println(empresa2 + "\n");
        System.out.println(empresa3 + "\n");

        System.out.println(remedio1 + "\n");
        System.out.println(remedio2 + "\n");
        System.out.println(remedio3 + "\n");

        System.out.println(funcionario1 + "\n");
        System.out.println(funcionario2 + "\n");
        System.out.println(funcionario3 + "\n");

        System.out.println(livro1 + "\n");
        System.out.println(livro2 + "\n");
        System.out.println(livro3);
    }
}
