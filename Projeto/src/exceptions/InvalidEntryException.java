package exceptions;
@SuppressWarnings("serial")
public class InvalidEntryException extends RuntimeException {
/* Exceção lançada se a lista estiver vazia e tentar, por 
 * exemplo, obter o primeiro elemento da lista usando o método 
 * first. */
	public InvalidEntryException(String err) { 
		super(err); 
	}
}
