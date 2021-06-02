package exceptions;

@SuppressWarnings("serial")
public class NoSuchElementException extends RuntimeException{

	public NoSuchElementException(String err) {
		super(err);
	}
}