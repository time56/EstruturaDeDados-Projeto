package exceptions;
@SuppressWarnings("serial")
public class InvalidEntryException extends RuntimeException {
/* Exce��o lan�ada se a lista estiver vazia e tentar, por 
 * exemplo, obter o primeiro elemento da lista usando o m�todo 
 * first. */
	public InvalidEntryException(String err) { 
		super(err); 
	}
}
