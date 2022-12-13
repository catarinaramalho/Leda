package adt.heap;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Test;

import adt.heap.extended.FloorCeilHeapImpl;

public class FloorCeiTest {

	Comparator<Integer> comparator = new ComparatorMaxHeap<Integer>();
	HeapImpl<Integer> heap = new HeapImpl<Integer>(comparator);
	FloorCeilHeapImpl floorceil = new FloorCeilHeapImpl(comparator);
	Integer[] array = new Integer[] {8, 12, -2, 7, 8, -5, 14, 3, -10, 0};
	
	
	
	@Test
	public void test01() {		
		assertEquals(floorceil.floor(array, 30).intValue(), 14);
	}
	
	@Test
	public void test02() {
		assertEquals(floorceil.floor(array, 0).intValue(), 0);
	}
	
	@Test
	public void test03() {
		assertEquals(floorceil.floor(array, -3).intValue(), -5);
	}
	
	@Test
	public void test04() {
		assertEquals(floorceil.floor(array, -10).intValue(), -10);
	}
	
	@Test
	public void test05() {
		assertNull(floorceil.floor(array, -11));
	}
	
	@Test
	public void test06() {
		assertNull(floorceil.floor(new Integer[] {}, -11));
	}
	@Test
	public void test07() {
		assertEquals(floorceil.floor(new Integer[] {-1}, -1).intValue(), -1);
	}
	
	@Test
	public void test08() {
		assertNull(floorceil.floor(new Integer[] {-1}, -11));
	}
	
	@Test
	public void test09() {
		assertNull(floorceil.ceil(new Integer[] {}, -11));
	}
	
	@Test
	public void test10() {		
		assertNull(floorceil.ceil(array, 30));
	}
	
	@Test
	public void test11() {
		assertEquals(floorceil.ceil(array, 0).intValue(), 0);
	}
	
	@Test
	public void test12() {
		assertEquals(floorceil.ceil(array, -3).intValue(), -2);
	}
	
	@Test
	public void test13() {
		assertEquals(floorceil.ceil(array, -10).intValue(), -10);
	}
	
	@Test
	public void test14() {
		assertEquals(floorceil.ceil(array, -11).intValue(), -10);
	}
	
	
}

