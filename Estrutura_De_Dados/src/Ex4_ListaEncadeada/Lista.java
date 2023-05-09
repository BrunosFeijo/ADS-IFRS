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
                inicio = novoNo;
                
            }
        }
}
