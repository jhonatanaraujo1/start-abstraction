package br.abastraction.startabstraction.api.exemplo.service.mapper;

import br.abastraction.startabstraction.api.exemplo.controller.domain.ExempleResponse;
import br.abastraction.startabstraction.api.exemplo.entity.ExempleEntity;
import br.abastraction.startabstraction.api.exemplo.controller.domain.ExempleUpdateRequest;
import br.abastraction.startabstraction.api.exemplo.controller.domain.ExempleSaveRequest;
import common.support.CrudMapper;
import org.springframework.stereotype.Component;


@Component
public interface ExempleMapper
    extends CrudMapper<
        ExempleEntity, ExempleSaveRequest, ExempleUpdateRequest, ExempleResponse> {}
