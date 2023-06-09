package common.support;

import common.exception.NotFoundException;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @param <E> Entity
 * @param <I> Id
 */
@Getter
@Transactional(readOnly = true)
public abstract class AbstractCrudService<
        E extends BaseEntity<I>, I, S, U, R> implements CrudService<
        E, I, S, U, R> {

    @Override
    public R findById(I id) {
        return getMapper().toResponse(findEntityById(id));
    }

    public E findEntityById(I id){
        return getOne(getRepository().findById(id));
    }

    @Override
    public Page<R> list(Pageable page) {
        return getMapper().toResponsePage(getRepository().findAll(page));
    }

    @Override
    @Transactional
    public R save(S entity) {
        return getMapper().toResponse(getRepository().save(getMapper().toEntityToSave(entity)));
    }

    @Override
    @Transactional
    public R update(U entity) {
        return getMapper().toResponse(getRepository().save(getMapper().toEntityToUpdate(entity)));
    }

    @Override
    @Transactional
    public void deleteById(I id) {
        getRepository().delete(findEntityById(id));
    }

//  public ExportReportDto export(
//      final String filter,
//      final Sort sort,
//      final ReportLayoutEnum layout,
//      final ReportFormatEnum format) {
//    return reportService.generateExportCrudReport(
//        entityType, findAllBySpecification(filter, sort), layout, format);
//  }

    protected E getOne(final Optional<E> optional) {
        return optional.orElseThrow(() -> new NotFoundException(getEntityName()));
    }

    public abstract JpaRepository<E, I> getRepository();

    public abstract String getEntityName();
}
