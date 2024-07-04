package tp1.exceptions;

public class CommandParseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommandParseException() {
		super();
	}

	public CommandParseException(String message) {
		super(message);
	}

	public CommandParseException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommandParseException(Throwable cause) {
		super(cause);
	}
	
	CommandParseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
