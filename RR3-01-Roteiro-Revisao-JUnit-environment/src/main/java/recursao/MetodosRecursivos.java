package recursao;

public class MetodosRecursivos {

	public int calcularSomaArray(int[] array, int tamanho){
		int result = 0;
		if(tamanho == 0){

		} // caso base, vetor vazio.
		else{

			result = array[tamanho-1] + calcularSomaArray(array, tamanho - 1); // chamada recursiva.
		}
		return result;
	}
	public long calcularFatorial(int n) {
		long result = 1;
		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR E IMPRIMIR
		// O FATORIAL DO PARAMETRO
		// DE ACORDO COM O QUE FOI MOSTRADO NO EXERCCICIO. OBSERVE QUE SENDO O
		// METODO
		// RECURSIVO, O FATORIAL DOS NUMEROS ANTERIORES TAMBEM VAO SER IMPRESSOS

		if (n == 0) {
			// caso base: nao faz nada
		} else {
			result = n * calcularFatorial(n - 1);
		}
		System.out.println(n + "! = " + result);
		return result;
	}

	public int calcularFibonacci(int n) {
		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR E IMPRIMIR
		// O N-ESIMO TERMO
		// DA SEQUENCIA DE FIBONACCI, QUE TEM A SEGUINTE LEI DE FORMACAO: O
		// PRIMEIRO E SEGUNDO NUMEROS
		// DA SEQUENCIA SÃO 1. A PARTIR DO TERCEIRO TERMO, CADA TERMO DA
		// SEQUENCIA É DADO
		// PELA SOMA DOS OUTROS DOIS ANTERIORES. OBSERVE QUE SENDO O METODO
		// RECURSIVO, O FIBONACCI DOS NUMEROS ANTERIORES TAMBEM VAO SER
		// IMPRESSOS
		int result = 1;
		if (n == 1 || n == 2) {
			// caso base: nao faz nada
		} else {
			result = calcularFibonacci(n - 1) + calcularFibonacci(n - 2);
		}

		return result;

	}

	public int countNotNull(Object[] array) {
		int result = 0;
		result = countNotNull(array, 0);
		// TODO IMPLEMENTE AQUI O CODIGO QUE CONTA (USANDO RECURSAO) A
		// QUANTIDADE DE ELEMENTOS NAO NULOS
		// DE UM ARRAY DE OBJETOS RECEBIDO COMO PARAMETRO
		return result;
	}

	private int countNotNull(Object[] array, int indexFrom) {
		int result = 0;
		
		if (array[indexFrom] != null) {
			result++;
		}
		
		if (indexFrom != array.length - 1) { // caso base: atingir o ultimo elemento do array
			result = result + countNotNull(array, indexFrom+1);
		}
		return result;
	}

	public long potenciaDe2(int expoente) {
		// TODO IMPLEMENTE (USANDO RECURSAO) O CODIGO PARA PRODUZIR A N-ESIMA
		// POTENCIA
		// DE 2
		long result = 1;
		if (expoente == 0) {
			// caso base: nao faz nada. ADMININDO QUE expoente EH UM NATURAL!!!
		} else {
			result = 2 * potenciaDe2(expoente - 1);
		}
		return result;
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		// TODO IMPLEMENTE SEU CODIGO (USANDO RECURSAO) DE ENCONTRAR O n-ESIMO
		// TERMO
		// DA PROGRESSAO ARITMETICA, DADO O TERMO INICIAL E A RAZAO
		// VOCE NAO PODE USAR A FORMULA QUE CALCULA O N-ESIMO TERMO. DEVE USAR RECURSAO
		double result = termoInicial;
		if (n == 1) {
			// caso base: nao faz nada
		} else {
			result = progressaoAritmetica(termoInicial, razao, n - 1) + razao;
		}
		return result;
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		// TODO IMPLEMENTE SEU CODIGO (USANDO RECURSAO) DE ENCONTRAR O n-ESIMO
		// TERMO
		// DA PROGRESSAO GEOMETRICA, DADO O TERMO INICIAL E A RAZAO
		// VOCE NAO PODE USAR A FORMULA QUE CALCULA O N-ESIMO TERMO. DEVE USAR RECURSAO
		double result = termoInicial;
		if (n == 1) {
			// caso base: nao faz nada
		} else {
			result = progressaoAritmetica(termoInicial, razao, n - 1) * razao;
		}
		return result;
	}
	
	
}
