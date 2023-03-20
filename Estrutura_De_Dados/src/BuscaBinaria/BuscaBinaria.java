package BuscaBinaria;

public class BuscaBinaria {

    public static int buscaBinaria(int[] array, int chave) {
        int inicio = 0;
        int fim = array.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (array[meio] == chave) {
                return meio;
            } else if (array[meio] < chave) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1; // chave não encontrada
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 6, 8, 10, 12, 14};
        int chave = 8;

        int indice = buscaBinaria(array, chave);

        if (indice == -1) {
            System.out.println("Chave não encontrada");
        } else {
            System.out.println("Chave encontrada no índice " + indice);
        }
    }
}
