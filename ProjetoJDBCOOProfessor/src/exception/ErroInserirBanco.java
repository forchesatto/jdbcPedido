package exception;

public class ErroInserirBanco extends Exception {

	private static final long serialVersionUID = 2173945334030239919L;

	public ErroInserirBanco(String message) {
		super(message);
	}
}
