package tp1.exceptions;

public class LaserInFlightException extends GameModelException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LaserInFlightException(String message) {
		super(message);
	}

	public LaserInFlightException() {
	}

	public LaserInFlightException(Throwable cause) {
		super(cause);
	}

	public LaserInFlightException(String message, Throwable cause) {
		super(message, cause);
	}

	LaserInFlightException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
