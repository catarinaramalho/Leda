package recursao;

public class IntroducaoRecursao {
    public static void imprimeSequenciaRecursivo(int k){
        System.out.println(k);
        imprimeSequenciaRecursivo(k-1);
    }

    public static void imprimeSequenciaRecursivoFinito(int k){
        if( k >= 0) {
            System.out.println(k);
            imprimeSequenciaRecursivoFinito(k - 1);
        }
    }
    public static void imprimeSequenciaRecursivoFinito2(int k){
        if( k >= 0) {
            imprimeSequenciaRecursivoFinito2(k - 1);
            System.out.println(k);
        }
    }

    public static void imprimeSequencia(int k){
        imprimeSequenciaRecursaoIndireta(k);
    }

    private static void imprimeSequenciaRecursaoIndireta(int k){
        if( k >= 0) {
            System.out.println(k);
            imprimeSequenciaRecursaoIndireta(k-1);
            System.out.println("Final da chamada em k = " + k);
        }
    }

    public static void main(String[] args) {
        //IntroducaoRecursao.imprimeSequenciaRecursivo(10);
        //IntroducaoRecursao.imprimeSequenciaRecursivoFinito(10);
        //IntroducaoRecursao.imprimeSequenciaRecursivoFinito2(10);
        IntroducaoRecursao.imprimeSequencia(10);
    }
}
