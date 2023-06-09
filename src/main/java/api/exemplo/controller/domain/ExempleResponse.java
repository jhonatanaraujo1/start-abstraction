package api.exemplo.controller.domain;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;


@Getter
@Setter
public class ExempleResponse {

  private Integer id;

  @NotNull
  private String descExemplo;
}
