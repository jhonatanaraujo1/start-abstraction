package common.support.enums;

import lombok.Getter;

import static java.lang.String.format;
import static org.springframework.http.MediaType.APPLICATION_PDF_VALUE;

@Getter
public enum ReportFormatEnum {
  PDF(APPLICATION_PDF_VALUE),
  CSV("text/csv");

  private final String mediaType;

  ReportFormatEnum(String mediaType) {
    this.mediaType = format("%s;charset=utf-8", mediaType);
  }
}
