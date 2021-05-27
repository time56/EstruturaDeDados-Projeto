package FilaPrioridades;
import java.util.Comparator;

public class SortedListPriorityQueue<K, V> implements PriorityQueue<K, V> {
	protected PositionList<Entry<K, V>> entries;
	protected Comparator<K> compa;
	protected Position<Entry<K, V>> actionPos; // variable used by subclasses
	
	// Classe Entradas interna
	protected static class MyEntry<K, V> implements Entry<K, V> {
		protected K k;
		protected V v;
		protected MyEntry(K key, V value) {
			k = key;
			v = value;
		}
		
		// Methods of the Entry interface
		public K getKey() {return k;} ;
		public V getValue() {return v; }
	
		// Sobrescreve toString, �til para depura��o
		public String toString() { return "(" + k + "," + v + ")"; }
	}
	
	// Cria a fila de prioridades com o comparador padr�o
	public SortedListPriorityQueue() {
		entries = new NodePositionList<Entry<K, V>>();
		compa = new DefaultComparator<K>();
	}
	
	// Cria a fila de prioridades com um comparador informado
	public SortedListPriorityQueue(Comparator<K> comp) {
		entries = new NodePositionList<Entry<K, V>>();
		compa = comp;
	}
	
	// Cria a fila de prioridade com um comparador informado e lista.
	// Assume-se que a lista � ordenada em ordem n�o-decrescente
	public SortedListPriorityQueue(PositionList<Entry<K, V>> list, Comparator<K> comp) {
		entries = list;
		compa = comp;
	}
	
	// Configura o comparador para a fila de prioridade.
	// * @throws IllegalStateException se fila de prioridade estiver vazia
	public void setComparator(Comparator<K> comp) throws IllegalStateException {
		// s� � permitido se a fila de prioridade estiver vazia
		if (!isEmpty()) throw new IllegalStateException("Priority queue is not empty");
		compa = comp;
	}
	
	// Retorna o n�mero de elementos da fila de prioridade
	public int size() {
		return entries.size();
	}
	
	// Retorna se a fila de prioridade est� vazia.
	public boolean isEmpty() {
		return entries.isEmpty();
	}
	
	// Retorna mas n�o remove uma entrada com a chave m�nima.
	public Entry<K, V> min() throws EmptyPriorityQueueException {
		if (entries.isEmpty()) throw new EmptyPriorityQueueException("Priority queue is empty");
		else return entries.first().element();
	}
	
	// Insere um par chave-valor e retorna a entrada criada.
	public Entry<K, V> insert(K k, V v) throws InvalidKeyException {
		checkKey(k); // auxiliary key-checking method (could throw exception)
		Entry<K, V> entry = new MyEntry<K, V>(k, v);
		insertEntry(entry); // auxiliary insertion method
		return entry;
	}
	
	// M�todo auxiliar usado para inser��o.
	protected void insertEntry(Entry<K, V> e) {
		if (entries.isEmpty()) {
			entries.addFirst(e); // insere na lista vazia
			actionPos = entries.first(); // posi��o da inser��o
		} else if(compa.compare(e.getKey(), entries.last().element().getKey()) > 0) {
			entries.addLast(e); // Insere no final da lista	
			actionPos = entries.last(); // Posi��o de inser��o
		} else {
			Position<Entry<K, V>> curr = entries.first();
			while (compa.compare(e.getKey(), curr.element().getKey()) > 0) {
				curr = entries.next(curr); // avan�a para encontrar a posi��o de inser��o
			}
			entries.addBefore(curr, e);
			actionPos = entries.prev(curr); // posi��o de inser��o
		}
	}
	
	// Remove e retorna uma entrada com a menor chave.
	public Entry<K, V> removeMin() throws EmptyPriorityQueueException {
		if (entries.isEmpty()) throw new EmptyPriorityQueueException("Priority queue is empty");
		else return entries.remove(entries.first());
	}
	
	// Determina se a chave � v�lida.
	protected boolean checkKey(K key) throws InvalidKeyException {
		boolean result;
		try { // verifica se a chave pode ser comparada
				result = (compa.compare(key, key) == 0);
		} catch (ClassCastException e) {
			throw new InvalidKeyException("key cannot be compared");
		}
		return result;
	}
	
	// Sobrescreve toString, �til para depura��o
	public String toString() {
		return entries.toString();
	}
}
