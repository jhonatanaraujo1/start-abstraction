package br.abastraction.startabstraction.api.exemplo.controller.domain;

import lombok.Data;
import org.jetbrains.annotations.NotNull;


@Data
public class ExempleUpdateRequest {

  private Integer id;

  @NotNull
  private String descExample;
}
