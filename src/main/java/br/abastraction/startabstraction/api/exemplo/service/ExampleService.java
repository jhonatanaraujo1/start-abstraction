package br.abastraction.startabstraction.api.exemplo.service;

import br.abastraction.startabstraction.api.exemplo.controller.domain.ExempleResponse;
import br.abastraction.startabstraction.api.exemplo.controller.domain.ExempleSaveRequest;
import br.abastraction.startabstraction.api.exemplo.controller.domain.ExempleUpdateRequest;
import br.abastraction.startabstraction.api.exemplo.service.mapper.ExempleMapper;
import br.abastraction.startabstraction.api.exemplo.entity.ExempleEntity;
import br.abastraction.startabstraction.api.exemplo.repository.ExempleRepository;
import common.support.AbstractCrudService;
import common.support.CrudMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ExampleService extends AbstractCrudService<
        ExempleEntity, Integer, ExempleSaveRequest, ExempleUpdateRequest, ExempleResponse> {

  private final ExempleRepository repository;

  private final ExempleMapper mapper;

  @Override
  public CrudMapper<ExempleEntity, ExempleSaveRequest, ExempleUpdateRequest, ExempleResponse> getMapper() {
    return mapper;
  }
  @Override
  public JpaRepository<ExempleEntity, Integer> getRepository() {
    return repository;
  }

  @Override
  public String getEntityName() {
    return "Exemple Entity Name";
  }
}
