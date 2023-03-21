package Ex1_RevisaoMenu;

public class Aluno {
    private String nome[];
    private double nota[];
    private int tamanho;

    public Aluno() {
        this.nome = new String[10];
        this.nota = new double[10];
        this.tamanho = 0;
    }

    public void cadastro(String nome, double nota) {
        if (nota < 0 || nota > 10) throw new IllegalArgumentException("Nota inválida. Digite um número de 0 a 10");

        verificarCapacidadeVetor();

        this.nome[tamanho] = nome;
        this.nota[tamanho] = nota;
        tamanho++;

        System.out.println("Aluno adicionado! \n");
    }

    public void informacoes() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println("Matrícula: " + i +
                    "\nNome: " + nome[i] +
                    "\nNota: " + nota[i]);
            System.out.println();
        }
    }

    public void modificarNota(double nota, int matricula) {
        if (matricula < 0 || matricula >= tamanho) throw new IllegalArgumentException("Matricula não encontrada");
        this.nota[matricula] = nota;

        System.out.println("Nota modificada para " + nota);
    }

    public void media() {
        double total = 0;

        for (int i = 0; i < tamanho; i++) {
            total += nota[i];
        }

        System.out.println("A média dos " + tamanho + " alunos é " + total / tamanho);
    }

    public void verificarCapacidadeVetor() {
        if (nome.length == tamanho) {
            String novoNome[] = new String[tamanho * 2];
            double novoNota[] = new double[tamanho * 2];

            for (int i = 0; i < tamanho; i++) {
                novoNome[i] = nome[i];
                novoNota[i] = nota[i];
            }

            nome = novoNome;
            nota = novoNota;
        }
    }
}

