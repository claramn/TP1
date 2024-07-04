package tp1.exceptions;

public class GameModelException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GameModelException(String message) {
        super(message);
    }
	
	public GameModelException() {
    }
	
	public GameModelException(String message, Throwable cause) {
		super(message, cause);
	}

	public GameModelException(Throwable cause) {
		super(cause);
	}
	
	GameModelException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
