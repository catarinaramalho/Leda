package recursao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestarMetodosRecursivos {
	private int[] array;
	private int numero;
	private MetodosRecursivos metodos;
	@Before
	public void setUp() throws Exception {
		this.array = new int[]{3,5,9,8,7};
		this.numero = 4;
		this.metodos = new MetodosRecursivos();
	}

	@Test
	public void testCalcularSomaArray() {
		assertEquals(metodos.calcularSomaArray(this.array, this.array.length), 32);
	}

	@Test
	public void testCalcularFatorial() {
		assertEquals(metodos.calcularFatorial(this.numero), 24);
	}

	@Test
	public void testCalcularFatorialDeUm() {
		assertEquals(metodos.calcularFatorial(1), 1);
	}

	@Test
	public void testCalcularFatorialDeZero() {
		assertEquals(metodos.calcularFatorial(0), 1);
	}

	@Test
	public void testCountNotNull() {
		assertEquals(metodos.countNotNull(new Object[] {null,1,2,3}), 3);
	}

	@Test
	public void testPotenciaDe2() {
		assertEquals(metodos.potenciaDe2(this.numero), 16);
	}

	@Test
	public void testProgressaoAritimetica() {
		assertEquals(metodos.progressaoAritmetica(this.numero, 1, 3), 6,0);
	}

	@Test
	public void testProgressaoGeometrica() {
		assertEquals(metodos.progressaoGeometrica(this.numero, 2, 3), 16,0);
	}

}


