package common.support;

import org.springframework.data.domain.Page;

/**
 * @param <E> Entity
 * @param <S> SaveRequest
 * @param <U> UpdateRequest
 * @param <R> Response
 */
public interface CrudMapper<E, S, U, R> {

  Page<R> toResponsePage(Page<E> entityPage);

  R toResponse(E entidade);

  E toEntityToSave(S saveRequest);

  E toEntityToUpdate(U updateRequest);
}
