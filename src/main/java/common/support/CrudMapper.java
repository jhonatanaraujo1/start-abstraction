package common.support;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

/**
 * @param <E> Entity
 * @param <S> SaveRequest
 * @param <U> UpdateRequest
 * @param <R> Response
 */
@Mapper(componentModel = "spring")
public interface CrudMapper<E, S, U, R> {

  Page<R> toResponsePage(Page<E> entityPage);

  R toResponse(E entidade);

  E toEntityToSave(S saveRequest);

  E toEntityToUpdate(U updateRequest);
}
