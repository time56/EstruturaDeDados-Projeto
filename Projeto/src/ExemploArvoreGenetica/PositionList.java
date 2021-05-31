package ExemploArvoreGenetica;

import java.util.Iterator;

public class PositionList<E> implements Iterable<E> {

	int size() {
		return 0;
	}

	boolean isEmpty() {
		return false;
	}

	Position<E> first() {
		return null;
	}

	Position<E> last() {
		return null;
	}

	Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		return null;
	}

	Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException {


		return p;
	}

	void addFirst(E e) {
	}

	void addLast(E e) {

	}

	void addAfter(Position<E> p, E e) throws InvalidPositionException {

	}

	void addBefore(Position<E> p, E e) throws InvalidPositionException {

	}

	E remove(Position<E> p) throws InvalidPositionException {
		return null;
	}

	E set(Position<E> p, E e) throws InvalidPositionException {
		return null;
	}

	public Iterator<E> iterator() {
		return null;
	}

}