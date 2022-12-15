package adt.heap;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Test;

import orderStatistic.OrderStatisticsHeapImpl;

public class OrderStatisticTest {

	Comparator<Integer> comparator = new ComparatorMaxHeap<Integer>();
	OrderStatisticsHeapImpl<Integer> heap = new OrderStatisticsHeapImpl<Integer>();
	Integer[] array = new Integer[] { 8, 12, -2, 7, 8, -5, 14, 3, -10, 0 };
	Integer[] array2 = new Integer[] { 12, 6, 10, 5 };

	@Test
	public void test01() {
		assertEquals(heap.getOrderStatistics(array, 3).intValue(), -2);
	}

	@Test
	public void test02() {
		assertEquals(heap.getOrderStatistics(array2, 1).intValue(), 5);
	}

	@Test
	public void test03() {
		assertEquals(heap.getOrderStatistics(array2, 2).intValue(), 6);
	}

	@Test
	public void test04() {
		assertEquals(heap.getOrderStatistics(array2, 3).intValue(), 10);
	}

	@Test
	public void test05() {
		assertEquals(heap.getOrderStatistics(array2, 4).intValue(), 12);
	}

	@Test
	public void test06() {
		assertNull(heap.getOrderStatistics(array2, 5));
	}

	@Test
	public void test07() {
		assertNull(heap.getOrderStatistics(array2, 0));
	}

	@Test
	public void test08() {
		assertEquals(heap.getOrderStatistics(new Integer[] { 12 }, 1).intValue(), 12);
	}

	@Test
	public void test09() {
		assertNull(heap.getOrderStatistics(new Integer[] {}, 0));
	}

}
