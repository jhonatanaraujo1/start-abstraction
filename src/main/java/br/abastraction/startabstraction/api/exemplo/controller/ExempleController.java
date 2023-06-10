package br.abastraction.startabstraction.api.exemplo.controller;

import br.abastraction.startabstraction.api.exemplo.entity.ExempleEntity;
import br.abastraction.startabstraction.api.exemplo.controller.domain.ExempleUpdateRequest;
import br.abastraction.startabstraction.api.exemplo.controller.domain.ExempleResponse;
import br.abastraction.startabstraction.api.exemplo.controller.domain.ExempleSaveRequest;
import br.abastraction.startabstraction.api.exemplo.service.ExampleService;
import common.support.AbstractCrudController;
import common.support.AbstractCrudService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api")
@Api("API example using abstraction")
@Validated
public class ExempleController
    extends AbstractCrudController<
        ExempleEntity, Integer, ExempleSaveRequest, ExempleUpdateRequest, ExempleResponse> {

  private final ExampleService service;

  @Override
  public AbstractCrudService<
          ExempleEntity, Integer, ExempleSaveRequest, ExempleUpdateRequest, ExempleResponse> getService() {
    return service;
  }
}
