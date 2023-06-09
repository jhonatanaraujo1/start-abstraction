package common.exception;

public class PredicateParserException extends RuntimeException {

  public PredicateParserException(String message) {
    super(message);
  }

  public PredicateParserException(Throwable cause) {
    super(cause);
  }
}
