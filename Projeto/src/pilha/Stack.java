package pilha;

import exceptions.EmptyStackException;

/* Interface para uma pilha: uma cole��o de objetos
 * que s�o inseridos e removidos de acordo com o princ�pio de o �ltimo que entra � o 
 * primeiro que sai. Esta interface inclui os principais m�todos do Java.util.Stack
 * 
 * @author Roberto Tamassia
 * @author Michael Goodrich
 * @see EmptyStackException */
public interface Stack<E> {
	// Retorna o n�mero de elementos na pilha.
	public int size();
	
	// @return True se a pilha � vazia, False em caso contr�rio.
	public boolean isEmpty();
	
	// @return o elemento que est� no topo da pilha.
	// @exception EmptyStackException se a pilha estiver vazia.
	public E top() throws EmptyStackException;
	
	// @param elemento a ser inserido
	public void push(E element);
	
	// @return elemento removido.
	// @exception EmptyStackException se a pilha estiver vazia.
	public E pop() throws EmptyStackException;
}
