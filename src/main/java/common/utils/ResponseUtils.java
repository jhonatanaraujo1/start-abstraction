package common.utils;

import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

@NoArgsConstructor(access = PRIVATE)
public class ResponseUtils {
  public static final String NAME_FILE_DOWNLOAD = "attachment;filename=%s";

  public static ResponseEntity<byte[]> responseEntityBytes(
      final String fileName, final String tipoConteudo, final byte[] arquivo) {
    return ResponseEntity.ok()
        .header(ACCESS_CONTROL_EXPOSE_HEADERS, CONTENT_DISPOSITION)
        .header(CONTENT_DISPOSITION, fileName)
        .header(CONTENT_TYPE, tipoConteudo)
        .contentLength(arquivo.length)
        .body(arquivo);
  }
}
