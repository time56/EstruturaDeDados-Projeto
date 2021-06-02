package tad_arvore_binaria;
import java.util.ArrayList;
import java.util.Iterator;
import exceptions.BoundaryViolationException;
import exceptions.EmptyTreeException;
import exceptions.InvalidPositionException;
import commons.Position;
import ListaNodos.NodePositionList;
import commons.PositionList;

//Uma implementa��o veloz da interface CompleteBinaryTree usando um vetor. Dentro do vetor, existe um elemento null
//no rank 0, a raiz no rank 1 e o resto da �rvore est� contida como segue. Se n tem rank i, ent�o o filho esquerdo
//de n ter� rank 2*i, e o filho direito de n ter� rank 2 * i + 1. Percorrer o conte�do do vetor em ordem crescente 
//de classifica��o resulta em uma travessia de ordem de n�vel;
	
public class ArrayListCompleteBinaryTree<E> implements CompleteBinaryTree<E> {
	protected ArrayList<BTPos<E>> T; // Lista indexada das posi��es da �rvore
	// Classe aninhada para um �ndice para um nodo de �rvore bin�ria
	// completa baseado em lista.
	protected static class BTPos<E> implements Position<E> {
		E element; // elemento armazenado nessa posi��o
		int index; // �ndice desta posi��o na lista de array
		
		public BTPos(E elt, int i) {
			element = elt;
			index = i;
		}
		
		public E element() {
			return element;
		}
		
		public int index() {
			return index;
		}
		
		public E setElement(E elt) {
			E temp = element;
			element = elt;
			return temp;
		}
		
		public String toString() {
			return ("[" + element + "," + index + "]");
		}
	}
	
	public ArrayListCompleteBinaryTree() {
		T = new ArrayList<BTPos<E>>();
		T.add(null); // a localiza��o em rank 0 � considerada vazia
	}
	
	// Retorna o n�mero de nodos da �rvore bin�ria
	public int size() {
		return T.size() - 1;
	}
	
	// Retorna se a arvore est� vazia.
	public boolean isEmpty() {
		return (size() == 0);
	}
	
	// Retorna se v � um nodo interno 
	public boolean isInternal(Position<E> v) throws InvalidPositionException {
		return hasLeft(v); // Se v tiver um filho esquerdo, ele ser� interno.
	}
	
	// Retorna se v � um nodo externo
	public boolean isExternal(Position<E> v) throws InvalidPositionException {
		return !isInternal(v);
	}
	
	// Determina se uma dada posi��o � um nodo v�lido
	protected BTPos<E> checkPosition(Position<E> v) throws InvalidPositionException {
		if (v == null || !(v instanceof BTPos)) throw new InvalidPositionException("Position is invalid");
		return (BTPos<E>) v;	
	}

	// Retorna se v � raiz
	public boolean isRoot(Position<E> v) throws InvalidPositionException {
		BTPos<E> vv = checkPosition(v);
		return vv.index() == 1;
	}
	
	// Retorna se v tem um filho esquerdo
	public boolean hasLeft(Position<E> v) throws InvalidPositionException {
		BTPos<E> vv = checkPosition(v);
		return 2 * vv.index() <= size();
	}
	
	// Retorna se v tem um filho direito
	public boolean hasRight(Position<E> v) throws InvalidPositionException {
		BTPos<E> vv = checkPosition(v);
		return 2 * vv.index() + 1 <= size(); 
	}
	
	// Returns the root	of the tree
	public Position<E> root() throws EmptyTreeException {
		if (isEmpty()) throw new EmptyTreeException("Tree is empty");
		return T.get(1);
	}
	
	// Retorna o filho esquerdo de v
	public Position<E> left(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
		if (!hasLeft(v)) throw new BoundaryViolationException("No left child");
		BTPos<E> vv = checkPosition(v);
		return T.get(2 * vv.index());
	}	
	
	// Retorna o filho direito de v
	public Position<E> right(Position<E> v) throws InvalidPositionException {
		if (!hasRight(v)) throw new BoundaryViolationException("No right child");
		BTPos<E> vv = checkPosition(v);
		return T.get(2 * vv.index() + 1);
	}
	
	// Retorna o pai de v
	public Position<E> parent(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
		if (isRoot(v)) throw new BoundaryViolationException("No parent");
		BTPos<E> vv = checkPosition(v);
		return T.get(vv.index() / 2);
	}
	
	// Retorna a cole��o iter�vel de filhos de v
	public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException {
		PositionList<Position<E>> children = (PositionList<Position<E>>) new NodePositionList<Position<E>>();
		if (hasLeft(v)) children.addLast(left(v));
		if (hasRight(v)) children.addLast(right(v));
		return children;
	}
	
	// Retorna a cole��o iter�vel de todos os nodos da �rvore
	public Iterable<Position<E>> positions() {
		ArrayList<Position<E>> P = new ArrayList<Position<E>>();
		Iterator<BTPos<E>> iter = T.iterator();
		iter.next(); // Pula a primeira posi��o
		while (iter.hasNext()) P.add(iter.next());
		return P;
	}
	
	// Troca o elemento de v
	public E replace(Position<E> v, E o) throws InvalidPositionException {
		BTPos<E> vv = checkPosition(v);
		return vv.setElement(o);
	}
	
	// Adiciona um elemento exatamente ap�s o �ltimo nodo
	public Position<E> add(E e) {
		int i = size() + 1;
		BTPos<E> p = new BTPos<E>(e, i);
		T.add(i, p);
		return p;
	}

	// Remove e retorna o elemento no do �ltimo nodo
	public E remove() throws EmptyTreeException {
		if (isEmpty()) throw new EmptyTreeException("Tree is empty");
		return T.remove(size()).element();
	}
	
	// M�todos adicionais
	// Retorna o irm�o de v
	public Position<E> sibling(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
		try {
			Position<E> p = parent(v);
			Position<E> lc = left(p);
			if (v == lc) return right(p);
			else return lc;
		} catch (BoundaryViolationException e) {
			throw new BoundaryViolationException("Node has no sibling");
		}
	}
	
	// Troca os elementos de dois nodos
	public void swapElements(Position<E> v, Position<E> w) throws InvalidPositionException {
		BTPos<E> vv = checkPosition(v);
		BTPos<E> ww = checkPosition(w);
		E temp = vv.element();
		vv.setElement(ww.element());
		ww.setElement(temp);
	}
	
	// Retorna um iterator dos elementos armazenados em todos os nodos da �rvore
	public Iterator<E> iterator() {
		ArrayList<E> list = new ArrayList<E>();
		Iterator<BTPos<E>> iter = T.iterator();
		iter.next();
		while (iter.hasNext()) list.add(iter.next().element());
		return list.iterator();
	}
	
	// Retorna uma string representando esta �rvore bin�ria completa
	public String toString() {
		return T.toString();
	}
}

