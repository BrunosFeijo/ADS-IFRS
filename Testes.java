public class Testes {
    public static void main(String[] args) {
        int vetor[][][] = new int[4][5][5];

        System.out.println(vetor.length);

        for (int i = 0; i < vetor.length; i++) {
            for (int j = 0; j < vetor.length; j++) {
                for (int k = 0; k < vetor.length; k++) {
                    vetor[i][j][k] = k;
                }
            }
        }
        for (int i = 0; i < vetor.length; i++) {
            for (int j = 0; j < vetor.length; j++) {
                for (int k = 0; k < vetor.length; k++) {
                    System.out.print("[" + vetor[i][j][k] + "]");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
