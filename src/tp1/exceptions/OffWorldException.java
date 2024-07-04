package tp1.exceptions;

public class OffWorldException extends GameModelException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OffWorldException(String message) {
		super(message);
	}

	public OffWorldException() {
	}

	public OffWorldException(Throwable cause) {
		super(cause);
	}

	public OffWorldException(String message, Throwable cause) {
		super(message, cause);
	}

	OffWorldException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
