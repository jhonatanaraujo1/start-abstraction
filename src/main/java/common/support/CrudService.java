package common.support;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @param <E> Entity
 * @param <I> Id
 * @param <S> SaveRequest
 * @param <U> UpdateRequest
 * @param <R> Response
 */
public interface CrudService<
        E, I, S, U, R> {
    CrudMapper<E, S, U, R> getMapper();

    R findById(I id);

    Page<R> list(Pageable page);

    R save(S entity);

    R update(U entity);

    void deleteById(I id);

}
