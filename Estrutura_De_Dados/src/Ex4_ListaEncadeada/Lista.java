package Ex4_ListaEncadeada;

public class Lista {
    protected No inicio;
    protected No fim;
    protected int tamanho;

        public Lista(){
            inicio = null;
            fim = null;
            tamanho = 0;
        }
        public boolean isVazio(){
            return tamanho == 0;
        }
        protected void adicionarNoInicio(int valor){
            No novoNo = new No(valor);
            if (isVazio()){
                inicio = fim = novoNo;
            }else{
                novoNo.setValor(valor);
                novoNo.setAnterior(null); // apenas para tornar explícito
                novoNo.setProximo(inicio);
                inicio.setAnterior(novoNo);
                inicio = novoNo;
            }
            tamanho++;
        }
        public int espiarTopo(){
            if (isVazio())throws IllegalArgumentException("dfsf");
            return fim.getValor();
        }
        public int espiarInicio(){
            if (isVazio()) return -1;
            return inicio.getValor();
        }

    @Override
    public String toString() {
            if (isVazio()) return "[]";

            StringBuilder stringBuilder = new StringBuilder("[");
            No no = inicio;

            for (int i = 0; i < tamanho -1;i++){
                stringBuilder.append(no.getValor()).append(",");
                no = no.getProximo();
            }

            stringBuilder.append(no.getValor()).append("]");

        return stringBuilder.toString();
    }
}
