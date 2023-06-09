package api.exemplo.controller.mapper;

import api.exemplo.controller.domain.ExempleUpdateRequest;
import api.exemplo.controller.domain.ExempleResponse;
import api.exemplo.controller.domain.ExempleSaveRequest;
import api.exemplo.entity.ExempleEntity;
import common.support.CrudMapper;
import org.mapstruct.Mapper;

@Mapper
public interface ExempleMapper
    extends CrudMapper<
        ExempleEntity, ExempleSaveRequest, ExempleUpdateRequest, ExempleResponse> {}
