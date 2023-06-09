package common.exception;

public class ExportException extends RuntimeException {

  public ExportException(Throwable cause) {
    super(cause);
  }

  public ExportException(String message) {
    super(message);
  }
}
