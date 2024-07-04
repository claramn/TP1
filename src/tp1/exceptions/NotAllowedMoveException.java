package tp1.exceptions;

public class NotAllowedMoveException extends GameModelException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotAllowedMoveException(String message) {
		super(message);
	}

	public NotAllowedMoveException() {
	}

	public NotAllowedMoveException(Throwable cause) {
		super(cause);
	}

	public NotAllowedMoveException(String message, Throwable cause) {
		super(message, cause);
	}

	NotAllowedMoveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
