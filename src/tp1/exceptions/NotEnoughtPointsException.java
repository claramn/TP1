package tp1.exceptions;

public class NotEnoughtPointsException extends GameModelException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotEnoughtPointsException(String message) {
		super(message);
	}

	public NotEnoughtPointsException() {
	}

	public NotEnoughtPointsException(Throwable cause) {
		super(cause);
	}

	public NotEnoughtPointsException(String message, Throwable cause) {
		super(message, cause);
	}

	NotEnoughtPointsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
