package Ex6_ArvoreB;

public class Pagina {
        int[] chaves;
        int tamanho;
        Pagina[] filhos;
        boolean isFolha;

        public Pagina(boolean isFolha) {
            this.chaves = new int[4]; // Máximo de 4 chaves por nó
            this.tamanho = 0;
            this.filhos = new Pagina[5]; // Máximo de 5 filhos por nó
            this.isFolha = isFolha;
        }

}
