package common.support;

import org.mapstruct.Mapper;
import org.springframework.transaction.annotation.Transactional;


/**
 * @param <E> Entity
 * @param <S> SaveRequest
 * @param <U> UpdateRequest
 * @param <R> Response
 */
@Mapper
@Transactional(readOnly = true)
public abstract class AbstractCrudMapper<E, S, U, R> implements CrudMapper<E, S, U, R> {

}
