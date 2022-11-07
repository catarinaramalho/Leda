package orderStatistic;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class KLargestOrderStatisticsImplTest {
    private KLargestOrderStatisticsImpl<Integer> implementacao;
    private Integer[] array;

    @Before
    public void setUp() {
        this.implementacao = new KLargestOrderStatisticsImpl<>();
        this.array = new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 };
    }

    // Testes do Método OrderStatistic
    // Testes de casos válidos
    @Test
    public void testOrderStatistics01() {
        assertEquals(this.implementacao.orderStatistics(this.array, 1), (Integer) 4);
    }

    @Test
    public void testOrderStatistics02() {
        assertEquals(this.implementacao.orderStatistics(this.array, 2), (Integer) 7);
    }

    @Test
    public void testOrderStatistics03() {
        assertEquals(this.implementacao.orderStatistics(this.array, 5), (Integer) 23);
    }

    // Teste com array nulo
    @Test
    public void testOrderStatistics04() {
        assertEquals(this.implementacao.orderStatistics(null, 5), null);
    }

    // Teste com k > tamanho do array
    @Test
    public void testOrderStatistics05() {
        assertEquals(this.implementacao.orderStatistics((this.array), 11), null);
    }

    // Teste com k < 0
    @Test
    public void testOrderStatistics06() {
        assertEquals(this.implementacao.orderStatistics((this.array), -1), null);
    }

    // Teste com array vazio
    @Test
    public void testOrderStatistics07() {
        assertEquals(this.implementacao.orderStatistics(new Integer[] {}, 5), null);
    }

    // Testes do método getKLargest

    // Testes de casos Válidos
    @Test
    public void testGetKLargest01() {
        assertArrayEquals(this.implementacao.getKLargest(this.array, 1), new Integer[] { 31 });
    }

    @Test
    public void testGetKLargest02() {
        assertArrayEquals(this.implementacao.getKLargest(this.array, 2), new Integer[] { 30, 31 });
    }

    // Teste com array nulo
    @Test
    public void testGetKLargest03() {
        assertArrayEquals(this.implementacao.getKLargest(null, 5), new Integer[] {});
    }

    // Teste com k > tamanho do array
    @Test
    public void testGetKLargest04() {
        assertArrayEquals(this.implementacao.getKLargest((this.array), 11), new Integer[] {});
    }

    // Teste com k < 0
    @Test
    public void testGetKLargest05() {
        assertArrayEquals(this.implementacao.getKLargest((this.array), -1), new Integer[] {});
    }

    // Teste com array vazio
    @Test
    public void testGetKLargest06() {
        assertArrayEquals(this.implementacao.getKLargest(new Integer[] {}, 5), new Integer[] {});
    }

}