package tp1.exceptions;

public class InitializationException extends GameModelException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InitializationException(String message) {
		super(message);
	}

	public InitializationException() {
	}
	
	public InitializationException(Throwable cause) {
		super(cause);
	}
	
	public InitializationException(String message, Throwable cause) {
		super(message, cause);
	}
	
	InitializationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}