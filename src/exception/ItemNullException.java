package exception;

public class ItemNullException extends Exception {
	public ItemNullException() {
		super("L'Item n'est pas cree");
	}
}
