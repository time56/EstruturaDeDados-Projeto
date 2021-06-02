package exceptions;

@SuppressWarnings("serial")
public class FullPriorityQueueException extends RuntimeException{

	public FullPriorityQueueException(String err) {
		super(err);
	}
}