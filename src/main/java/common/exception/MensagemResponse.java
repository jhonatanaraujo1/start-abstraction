package common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MensagemResponse {

  private final TypeMessage tipo;
  private final String mensagem;
}
