package ArvoreBusca;

import java.util.Comparator;

import commons.Position;
import commons.PositionList;
import exceptions.InvalidEntryException;
import exceptions.InvalidKeyException;
import exceptions.InvalidPositionException;
import tad_arvore_binaria.LinkedBinaryTree;
import ListaNodos.NodePositionList;

//Implementa��o de um dicion�rio com uma �rvore bin�ria de pesquisa 
public class BinarySearchTree<K, V> extends LinkedBinaryTree<Entry<K, V>> implements Map<K, V> {
	protected Comparator<K> C; // comparador
	protected Position<Entry<K, V>> actionPos; // pai do nodo inserido ou removido
	protected int numEntries = 0; // n�mero de elementos
	//Cria uma BinarySearchTreeMap com um comparador padr�o.
	public BinarySearchTree() {
	C = new DefaultComparator<K>();
	addRoot(null);
	}
	//Classe aninhada para as entradas conscientes de localiza��o da �rvore bin�ria de pesquisa.
	protected static class BSTEntry<K, V> implements Entry<K, V> {
	protected K key;
	protected V value;
	protected Position<Entry<K, V>> pos;
	BSTEntry() { } /* construtor padr�o */
	BSTEntry(K k, V v, Position<Entry<K, V>> p) { key = k; value = v; pos = p; }
	public K getKey() { return key; }
	public V getValue() { return value; }
	public Position<Entry<K, V>> position() { return pos; }
	}

	// Retorna a chave do elemento de um dado nodo da �rvore.
	protected K key(Position<Entry<K, V>> position) { return position.element().getKey(); }
	// Retorna o valor do elemento de um dado nodo da �rvore.
	protected V value(Position<Entry<K, V>> position) { return position.element().getValue(); }
	// Retorna o elemento de um dado nodo da �rvore.
	protected Entry<K, V> entry(Position<Entry<K, V>> position) { return position.element(); }
	// Substitui um elemento por um novo elemento (e inicializa a localiza��o do elementos)
	protected V replaceEntry(Position<Entry<K, V>> pos, Entry<K, V> ent) {
	((BSTEntry<K, V>) ent).pos = pos;
	return replace(pos, ent).getValue();
	}
	// Verifica se uma determinada chave � v�lida.
	protected void checkKey(K key) throws InvalidKeyException {
	if (key == null) // um teste simples
	throw new InvalidKeyException("chave nula");
	}
	// Verifica se um determinado elemento � v�lido.
	protected void checkEntry(Entry<K, V> ent) throws InvalidEntryException {
	if (ent == null || !(ent instanceof BSTEntry)) throw new InvalidEntryException("elemento inv�lido");
	}
	// M�todo auxiliar para inserir um elemento em um nodo externo
	protected Entry<K, V> insertAtExternal(Position<Entry<K, V>> v, Entry<K, V> e) {
	expandExternal(v, null, null);
	replace(v, e);
	numEntries++;
	return e;
	}
	// M�todo auxiliar para remover um nodo externo e seu pai
	protected void removeExternal(Position<Entry<K, V>> v) {
	removeAboveExternal(v);
	numEntries--;
	}

	// M�todo auxiliar usado para pesquisar, inserir e remover.
	protected Position<Entry<K, V>> treeSearch(K key, Position<Entry<K, V>> pos) {
	if (isExternal(pos)) return pos; // chave n�o encontrada; retorna o nodo externo
	else {
	K curKey = key(pos);
	int comp = C.compare(key, curKey);
	if (comp < 0) return treeSearch(key, left(pos)); // pesquisa na sub�rvore � esquerda
	else if (comp > 0) return treeSearch(key, right(pos)); // pesquisa na sub�rvore � direita
	return pos; // retorna o nodo interno onde a chave foi encontrada
	}
	}
	// m�todos do TAD
	public int size() { return numEntries; }
	public boolean isEmpty() { return size() == 0; }
	public V get(K key) throws InvalidKeyException {
	checkKey(key); // pode lan�ar uma exce��o InvalidKeyException
	Position<Entry<K, V>> curPos = treeSearch(key, root());
	actionPos = curPos; // nodo onde a pesquisa finalizou
	if (isInternal(curPos)) return value(curPos);
	return null;
	}
	public V put(K k, V x) throws InvalidKeyException {
	checkKey(k); // pode lan�ar uma exce��o InvalidKeyException
	Position<Entry<K, V>> insPos = treeSearch(k, root());
	BSTEntry<K, V> e = new BSTEntry<K, V>(k, x, insPos);
	actionPos = insPos; // nodo onde a entrada est� sendo inserida
	if (isExternal(insPos)) { // necessita de um nodo novo, a chave � nova
	insertAtExternal(insPos, e);
	return null;
	}
	return replaceEntry(insPos, e); // a chave j� existe
	}

	public V remove(K k) throws InvalidEntryException {
		checkKey(k); // pode lan�ar uma InvalidKeyException
		Position<Entry<K, V>> remPos = treeSearch(k, root());
		if (isExternal(remPos)) return null; // chave n�o encontrada
		Entry<K, V> toReturn = entry(remPos); // entrada existente
		if (isExternal(left(remPos))) remPos = left(remPos); // caso f�cil pela esquerda
		else if (isExternal(right(remPos))) remPos = right(remPos); // caso f�cil pela direita
		else { // a entrada est� em nodo com filho interno
		Position<Entry<K, V>> swapPos = remPos; // encontra o nodo para a entrada que est� sendo movida
		remPos = right(swapPos);
		do remPos = left(remPos); while (isInternal(remPos));
		replaceEntry(swapPos, (Entry<K, V>) parent(remPos).element());
		}
		actionPos = sibling(remPos); // irm�o da folha que est� sendo removida
		removeExternal(remPos);
		return toReturn.getValue();
	}
		
	// Expande um nodo externo num nodo interno com dois nodos filhos externos
	public void expandExternal(Position<Entry<K, V>> v, Entry<K, V> l, Entry<K, V> r) throws InvalidPositionException {
		if (!isExternal(v)) throw new InvalidPositionException("Node is not external");
		insertLeft(v, l);
		insertRight(v, r);
	}
	// Remove um nodo externo v e troca seu pai com o irm�o de v
	public void removeAboveExternal(Position<Entry<K, V>> v) throws InvalidPositionException {
		if (!isExternal(v)) throw new InvalidPositionException("Node is not external");
		if (isRoot(v)) remove(v);
		else {
		Position<Entry<K, V>> u = parent(v);
		remove(v);
		remove(u);
	}
	}

	// Retorna uma cole��o iterable contendo todas as chaves da �rvore
	public Iterable<K> keySet() {
		@SuppressWarnings("unchecked")
		PositionList<K> keys = (PositionList<K>) new NodePositionList<K>();
		Iterable<Position<Entry<K, V>>> positer = positionsInorder();
		for (Position<Entry<K, V>> cur : positer) if (isInternal(cur)) keys.addLast(key(cur));
		return keys;
	}
	// Retorna uma cole��o iterable contendo todos os valores da �rvore
	public Iterable<V> values() {
		@SuppressWarnings("unchecked")
		PositionList<V> vals = (PositionList<V>) new NodePositionList<V>();
		Iterable<Position<Entry<K, V>>> positer = positionsInorder();
		for (Position<Entry<K, V>> cur : positer) if (isInternal(cur)) vals.addLast(value(cur));
		return vals;
	}
	// Retorna uma cole��o iter�vel com todas as entradas da �rvore
	public Iterable<Entry<K, V>> entrySet() {
		@SuppressWarnings("unchecked")
		PositionList<Entry<K, V>> entries = (PositionList<Entry<K, V>>) new NodePositionList<Entry<K, V>>();
		Iterable<Position<Entry<K, V>>> positer = positionsInorder();
		for (Position<Entry<K, V>> cur : positer) if (isInternal(cur)) entries.addLast(cur.element());
		return entries;
	}
	
	// Exibe a express�o parentizada da �rvore
	public String printExpression(Position<Entry<K, V>> v) {
		String s = "";
		if (isInternal(v)) s += "(";
		if (hasLeft(v)) s += printExpression(left(v));
		if (v.element()!=null) s += v.element().getKey().toString();
		if (hasRight(v)) s += printExpression(right(v));
		if (isInternal(v)) s += ")";
		return s;
	}
}
