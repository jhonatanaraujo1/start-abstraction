package common.exception;

import static common.exception.MensagemEnum.ERR00002;

public class NotFoundException extends BusinessException {

  public NotFoundException(MensagemEnum codigoErro, Object... params) {
    super(codigoErro, params);
  }

  public NotFoundException(Object... params) {
    super(ERR00002, params);
  }
}
