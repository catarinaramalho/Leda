package adt.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentQueueTest {

	public Queue<Integer> queue1;
	public Queue<Integer> queue2;
	public Queue<Integer> queue3;

	@Before
	public void setUp() throws QueueOverflowException {

		getImplementations();

		// Fila com 3 elementos não cheia.
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);

		// Fila com 2 elementos de tamanho 2. Fila cheia.
		queue2.enqueue(1);
		queue2.enqueue(2);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		// Queue
		queue1 = new QueueImpl<Integer>(4);
		queue2 = new QueueImpl<Integer>(2);
		queue3 = new QueueImpl<Integer>(2);
		// CircularQueue
		queue1 = new CircularQueue<Integer>(4);
		queue2 = new CircularQueue<Integer>(2);
		queue3 = new CircularQueue<Integer>(2);
		// QueueUsingStack
		queue1 = new QueueUsingStack<Integer>(4);
		queue2 = new QueueUsingStack<Integer>(2);
		queue3 = new QueueUsingStack<Integer>(2);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testHead() {
		assertEquals(new Integer(1), queue1.head());
	}

	@Test
	public void testHeadNull() {
		assertEquals(null, queue3.head());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(queue1.isEmpty());
		assertTrue(queue3.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(queue1.isFull());
	}

	@Test
	public void testEnqueue() {
		try {
			queue1.enqueue(new Integer(5));
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Teste Criado
	@Test
	public void testEnqueueNull() throws QueueOverflowException {
		queue1.enqueue(null);
		assertEquals(queue1.head(), new Integer(1));
	}

	// Teste Criado
	@Test
	public void testEnqueueCircular() throws QueueOverflowException, QueueUnderflowException {
		CircularQueue<Integer> queue = new CircularQueue<Integer>(4);
		queue.enqueue(new Integer(5));
		queue.enqueue(new Integer(4));
		queue.enqueue(new Integer(3));
		queue.enqueue(new Integer(2));
		assertEquals(new Integer(5), queue.dequeue());
		assertEquals(new Integer(4), queue.head());
		assertEquals(false, queue.isFull());
		queue.enqueue(new Integer(5));
		assertEquals(new Integer(4), queue.head());
		assertEquals(true, queue.isFull());

	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueComErro() throws QueueOverflowException {
		queue1.enqueue(new Integer(5)); // vai depender do tamanho que a fila
		queue1.enqueue(new Integer(6));// foi iniciada!!!
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(new Integer(1), queue1.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueUnderflowException.class)
	public void testDequeueComErro() throws QueueUnderflowException {
		assertEquals(new Integer(1), queue1.dequeue()); // vai depender do
		assertEquals(new Integer(2), queue1.dequeue()); // tamanho que a fial
		assertEquals(new Integer(3), queue1.dequeue()); // foi iniciada!!!
		assertEquals(new Integer(4), queue1.dequeue());
	}

}