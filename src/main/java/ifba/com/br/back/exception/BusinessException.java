package ifba.com.br.back.exception;

public class BusinessException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private String message;

  public BusinessException(String message) {
    super(message);
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
