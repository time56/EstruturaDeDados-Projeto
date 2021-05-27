package FilaPrioridades;

@SuppressWarnings("serial")
public class EmptyPriorityQueueException extends RuntimeException {
	public EmptyPriorityQueueException(String err) {
		super(err);
	}
}
