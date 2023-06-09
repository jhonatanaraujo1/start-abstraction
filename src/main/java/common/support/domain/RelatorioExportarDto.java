package common.support.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RelatorioExportarDto {

  private byte[] arquivo;
  private String nomeArquivo;
  private String tipoConteudo;
}
