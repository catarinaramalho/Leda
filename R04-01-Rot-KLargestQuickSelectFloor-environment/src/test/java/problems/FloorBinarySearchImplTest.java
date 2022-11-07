package problems;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class FloorBinarySearchImplTest {
    private FloorBinarySearchImpl implementacao;
    private Integer[] array;
    private Integer[] arrayVazio;

    @Before
    public void setUp() {
        this.implementacao = new FloorBinarySearchImpl();
        this.array = new Integer[] { -3, 18, 4, 15, 11, 40, 45, 21, 13, 12 };
        this.arrayVazio = new Integer[] {};
    }

    // Casos Válidos
    @Test
    public void testProblems00() {
        assertEquals(this.implementacao.floor(this.array, -2), Integer.valueOf("-3"));
    }

    @Test
    public void testProblems01() {
        assertEquals(this.implementacao.floor(this.array, 21), (Integer) 21);
    }

    @Test
    public void testProblems02() {
        assertEquals(this.implementacao.floor(this.array, 22), (Integer) 21);
    }

    @Test
    public void testProblems03() {
        assertEquals(this.implementacao.floor(this.array, 14), (Integer) 13);
    }
    // Casos Inválidos

    // Quando o elemento passado é null
    @Test
    public void testProblems04() {
        assertEquals(this.implementacao.floor(this.array, null), null);
    }

    // Quando o array passado é null
    @Test
    public void testProblems05() {
        assertEquals(this.implementacao.floor(null, 2), null);
    }

    // Quando o array é vazio
    @Test
    public void testProblems06() {
        assertEquals(this.implementacao.floor(this.arrayVazio, 2), null);
    }

    // Quando não tem um elemento menor que o passado no parâmetro, no array
    @Test
    public void testProblems07() {
        assertEquals(this.implementacao.floor(this.array, -4), null);
    }

}
