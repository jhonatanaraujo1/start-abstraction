package common.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

  private final MensagemEnum codigoErro;
  private final TypeMessage typeMessage;
  private final transient Object[] params;

  public BusinessException(String message) {
    this(message, (Object[]) null);
  }

  public BusinessException(String message, TypeMessage typeMessage) {
    this(message, typeMessage, (Object[]) null);
  }

  public BusinessException(String message, Object... params) {
    this(message, TypeMessage.ERROR, params);
  }

  public BusinessException(String message, TypeMessage typeMessage, Object... params) {
    super(message);
    this.codigoErro = null;
    this.typeMessage = typeMessage;
    this.params = params;
  }

  public BusinessException(MensagemEnum codigoErro) {
    this(codigoErro, (TypeMessage) null);
  }

  public BusinessException(MensagemEnum codigoErro, TypeMessage typeMessage) {
    this(codigoErro, typeMessage, (Object[]) null);
  }

  public BusinessException(MensagemEnum codigoErro, Object... params) {
    this(codigoErro, TypeMessage.ERROR, params);
  }

  public BusinessException(MensagemEnum codigoErro, TypeMessage typeMessage, Object... params) {
    super(codigoErro.name());
    this.codigoErro = codigoErro;
    this.typeMessage = typeMessage;
    this.params = params;
  }

  public BusinessException(Throwable causa, MensagemEnum codigoErro) {
    this(causa, codigoErro, (TypeMessage) null);
  }

  public BusinessException(Throwable causa, MensagemEnum codigoErro, TypeMessage typeMessage) {
    this(causa, codigoErro, typeMessage, (Object[]) null);
  }

  public BusinessException(Throwable causa, MensagemEnum codigoErro, Object... params) {
    this(causa, codigoErro, TypeMessage.ERROR, params);
  }

  public BusinessException(
          Throwable causa, MensagemEnum codigoErro, TypeMessage typeMessage, Object... params) {
    super(causa);
    this.codigoErro = codigoErro;
    this.typeMessage = typeMessage;
    this.params = params;
  }
}
