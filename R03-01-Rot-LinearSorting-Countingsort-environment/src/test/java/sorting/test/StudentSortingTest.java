package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.linearSorting.CountingSort;
import sorting.linearSorting.ExtendedCountingSort;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {

		this.implementation = new CountingSort();
		this.implementation = new ExtendedCountingSort();
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if (array.length > 0) {
			copy1 = Arrays.copyOf(array, array.length);
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */
	// Teste de vetores
	@Test
	public void testSort06() {
		Integer[] vetor = new Integer[] { 4, 7, 5, 8 };
		genericTest(vetor);
	}

	@Test
	public void testSort07() {
		Integer[] vetor = new Integer[] { 7, 2, 1, 3 };
		genericTest(vetor);
	}

	// Teste com array já ordenado
	@Test
	public void testSort08() {
		Integer[] vetor = new Integer[] { 1, 2, 3, 5 };
		genericTest(vetor);
	}

	// Teste com um elemento
	@Test
	public void testSort09() {
		Integer[] vetor = new Integer[] { 4 };
		genericTest(vetor);
	}

	//
	// Teste com o último não ordenado
	@Test
	public void testSort10() {
		Integer[] vetor = new Integer[] { 1, 2, 3, 5, 0 };
		genericTest(vetor);
	}

	// Considerando Números Negativos
	@Test
	public void testSort11() {
		ExtendedCountingSort ec = new ExtendedCountingSort();
		Integer[] array = new Integer[] { 10, 18, -4, 15, 11, 40 };
		ec.sort(array, 0, 5);
		Assert.assertArrayEquals(array, new Integer[] { -4, 10, 11, 15, 18, 40 });
	}

	@Test
	public void testSort12() {
		ExtendedCountingSort ec = new ExtendedCountingSort();
		Integer[] array = new Integer[] { -3, -2, -4, -5 };
		ec.sort(array, 0, 3);
		Assert.assertArrayEquals(array, new Integer[] { -5, -4, -3, -2 });
	}

	// Testando Intervalos Iguais
	@Test
	public void testSort13() {
		Integer[] array = new Integer[] { 10, 18, 4, 15, 11, 40, 45, 21, 13, 12 };
		this.implementation.sort(array, 3, 3);
		Assert.assertArrayEquals(array, new Integer[] { 10, 18, 4, 15, 11, 40, 45, 21, 13, 12 });
	}

	// Testando Index da Esquerda > Index da Direita
	@Test
	public void testSort14() {
		Integer[] array = new Integer[] { 10, 18, 4, 15, 11, 40, 45, 21, 13, 12 };
		this.implementation.sort(array, 4, 2);
		Assert.assertArrayEquals(array, new Integer[] { 10, 18, 4, 15, 11, 40, 45, 21, 13, 12 });
	}

	// Testando Index da Esquerda < 0
	@Test
	public void testSort15() {
		Integer[] array = new Integer[] { 10, 18, 4, 15, 11, 40, 45, 21, 13, 12 };
		this.implementation.sort(array, -1, 0);
		Assert.assertArrayEquals(array, new Integer[] { 10, 18, 4, 15, 11, 40, 45, 21, 13, 12 });
		;
	}

	// Testando Index da Direita = Tamanho do vetor
	@Test
	public void testSort16() {
		Integer[] array = new Integer[] { 10, 18, 4, 15, 11, 40, 45, 21, 13, 12 };
		this.implementation.sort(array, 1, 10);
		Assert.assertArrayEquals(array, new Integer[] { 10, 18, 4, 15, 11, 40, 45, 21, 13, 12 });
		;
	}

	// Testando Index da Direita > Tamanho do vetor
	@Test
	public void testSort17() {
		Integer[] array = new Integer[] { 10, 18, 4, 15, 11, 40, 45, 21, 13, 12 };
		this.implementation.sort(array, 1, 11);
		Assert.assertArrayEquals(array, new Integer[] { 10, 18, 4, 15, 11, 40, 45, 21, 13, 12 });
		;
	}

	// Testando Array Null
	@Test
	public void testSort18() {
		Integer[] array = null;
		this.implementation.sort(array, 0, 1);
		Assert.assertArrayEquals(array, null);
	}

}