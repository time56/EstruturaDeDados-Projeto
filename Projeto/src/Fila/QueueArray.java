package Fila;

public class QueueArray<E> implements Queue<E> {
	private int size;
	private int f;
	private int r;
	private E[] arranjo; 
		
	
	@SuppressWarnings("unchecked")
	public QueueArray(int size) {
		this.f = 0;
		this.r = 0;
		this.size = size;
		arranjo = (E[]) new Object[size];
	}
	
	public int size() {
		return (size - f + r) % size;
	}

	public boolean isEmpty() {
		return (f == r);
	}

	public E front() throws EmptyQueueException {
		if(isEmpty()) { 
			throw new EmptyQueueException("Queue is empty."); 
		}
		return arranjo[f];
	}

	public void enqueue(E element) throws FullQueueException {	
		if (size() == this.size - 1) {
			throw new FullQueueException("Queue is full.");
		}
		arranjo[r] = element;
		r = (r + 1) % size;
	}

	public E dequeue() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException("Queue is empty.");
		}
		E temp = arranjo[f];
		arranjo[f] = null;
		f = (f + 1) % size; 
		return temp;
	}
	
	public String toString() {
		String s;
		s = "[";
		if (size() > 0) s += arranjo[f];
		if (size() > 1) {
			for (int i = 1; i < size(); i++) {
				s += ", " + arranjo[(f + i) % size];
			}
		}
		return s + "]";
	}

}
