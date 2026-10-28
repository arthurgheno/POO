public class BuscaEOrdenacao {

    public class VerificaOrdenacao{
        public static boolean estaOrdenado(int []v){
            boolean crescente = true;
            boolean decrescente = true;

            for(int i =0;i<v.length - 1;i++){
                if(v[i] > v[i+1]){
                    crescente = false;
                }
                if(v[i] < v[i+1]){
                    decrescente = false;
                }
                if(!crescente && !decrescente){
                    return false;
                }
            }
            return true;
        }
    }

    public class BuscaBinaria {
        public static boolean pertence(int[] v, int x) {
            int inicio = 0;
            int fim = v.length - 1;

            while (inicio <= fim) {
                int meio = inicio + (fim - inicio) / 2;
                if (v[meio] == x) {
                    return true;
                } else if (v[meio] < x) {
                    inicio = meio + 1;   // descarta a metade esquerda
                } else {
                    fim = meio - 1;      // descarta a metade direita
                }
            }

            return false;
        }
    }

    
}
