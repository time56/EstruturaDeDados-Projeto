package FilaPrioridades;

// Interface para o TAD fila de prioridade
public interface PriorityQueue<K, V> {
	// Retorna a quantidade de itens na fila de prioridade.
	public int size();
	
	// Retorna se a fila de prioridade est� vazia.
	public boolean isEmpty();
	
	// Retorna mas n�o remove uma entrada com chave m�nima.
	public Entry<K, V> min() throws EmptyPriorityQueueException;
	
	// Insere um par chave-valor e retorna a entrada criada
	public Entry<K, V> insert(K key, V value) throws InvalidKeyException;

	// Remove e retorna uma entrada com chave m�nima
	public Entry<K, V> removeMin() throws EmptyPriorityQueueException;
}
