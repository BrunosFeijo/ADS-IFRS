package Exercicios;

public class TesteQuick {
    public static void quicksort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quicksort(array, low, pivotIndex - 1);
            quicksort(array, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Escolhe o último elemento como pivô
        int i = low - 1; // Índice do menor elemento

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                // Troca os elementos array[i] e array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Troca o pivô (array[high]) com o elemento na posição correta (array[i+1])
        int temp = array[i + 1];
        array[i + 1] = pivot;
        array[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] array = { 9, 7, 5, 11, 12, 2, 14, 3, 10, 6 };
        int n = array.length;

        System.out.println("Array original:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        quicksort(array, 0, n - 1);

        System.out.println("\nArray ordenado:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
