package tp1.exceptions;

public class NoShockWaveException extends GameModelException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoShockWaveException(String message) {
		super(message);
	}

	public NoShockWaveException() {
	}

	public NoShockWaveException(Throwable cause) {
		super(cause);
	}

	public NoShockWaveException(String message, Throwable cause) {
		super(message, cause);
	}

	NoShockWaveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
