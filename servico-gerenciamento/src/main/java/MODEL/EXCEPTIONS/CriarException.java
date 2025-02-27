package MODEL.EXCEPTIONS;

public class CriarException extends RuntimeException {

    public CriarException(String message) {
        super(message);
    }

    public CriarException(String message, Throwable cause) {
        super(message, cause);
    }

    public CriarException() {
    }

    public CriarException(Throwable cause) {
        super(cause);
    }

    public CriarException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
