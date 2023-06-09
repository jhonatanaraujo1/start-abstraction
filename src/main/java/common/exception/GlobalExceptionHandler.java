package common.exception;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.PostConstruct;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import static common.exception.MensagemEnum.ERR00001;
import static java.lang.String.format;
import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.apache.commons.lang3.StringUtils.EMPTY;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

  private static final String ARQUIVO_MENSAGENS = "mensagens.properties";
  private static final String ERRO_BEAN_VALIDATION_PATTERN = "%s %s";

  private Properties properties;
  private String msgErroPadrao;

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(BusinessException.class)
  public List<MensagemResponse> handleBusinessException(final BusinessException e) {
    log.error("Exceção de negócio capturada", e);
    return List.of(toResponse(e));
  }



  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(DataIntegrityViolationException.class)
  public List<MensagemResponse> handleDataIntegrityViolationException(
      final DataIntegrityViolationException e) {
    log.error("Exceção de integridade capturada", e);

    String mensagem = msgErroPadrao;
    int qtdeMax = 20;
    int qtdeAtual = 0;
    Throwable throwable = e;

    while (nonNull(throwable.getCause()) && (++qtdeAtual <= qtdeMax)) {
      throwable = throwable.getCause();
    }
    return List.of(new MensagemResponse(TypeMessage.ERROR, mensagem));
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(Exception.class)
  public List<MensagemResponse> handleException(final Exception e) {
    log.error("Exceção capturada", e);
    return List.of(new MensagemResponse(TypeMessage.ERROR, msgErroPadrao));
  }

  private MensagemResponse toResponse(final BusinessException e) {

    final TypeMessage typeMessage =
        Optional.ofNullable(e.getTypeMessage()).orElse(TypeMessage.ERROR);

    String mensagem =
        Optional.ofNullable(e.getCodigoErro())
            .map(Enum::name)
            .map(properties::getProperty)
            .orElse(Optional.ofNullable(e.getMessage()).orElse(msgErroPadrao));

    if (ArrayUtils.isNotEmpty(e.getParams())) {
      mensagem = MessageFormat.format(mensagem, e.getParams());
    }

    return new MensagemResponse(typeMessage, mensagem);
  }

  private String getMensagem(final MensagemEnum mensagemEnum, final Object... parametros) {
    String mensagem = properties.getProperty(mensagemEnum.name());
    if (ArrayUtils.isNotEmpty(parametros)) {
      mensagem = MessageFormat.format(mensagem, parametros);
    }
    return mensagem;
  }


  @PostConstruct
  public void onLoad() throws IOException {
    try (InputStream is = this.getClass().getClassLoader().getResourceAsStream(ARQUIVO_MENSAGENS)) {
      this.properties = new Properties();
      this.properties.load(is);
      this.msgErroPadrao = properties.getProperty(ERR00001.name());
    }
  }
}
