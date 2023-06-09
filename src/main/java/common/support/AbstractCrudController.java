package common.support;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @param <E> Entity
 * @param <I> Id
 * @param <S> SaveRequest
 * @param <U> UpdateRequest
 * @param <R> Response
 */
public abstract class AbstractCrudController<
        E extends BaseEntity<I>, I, S, U, R>
    implements CrudController<E, I, S, U, R> {

  @Override
  @GetMapping("{id}")
  public R findById(@PathVariable("id") final I id) {
    return getService().findById(id);
  }

  @GetMapping
  @Override
  public Page<R> list(
      @PageableDefault final Pageable pagina) {
    return getService().list(pagina);
  }

//  @Override
//  @GetMapping("export")
//  public ResponseEntity<byte[]> exportar(
//      @RequestParam(value = "filtro", required = false) final String filtro,
//      @SortDefault final Sort sort,
//      @NotNull @RequestParam(value = "layout") final RelatorioLayoutEnum layout,
//      @NotNull @RequestParam(value = "formato") final RelatorioFormatoEnum formato) {
//    return responseEntityBytes(getService().exportar(filtro, sort, layout, formato));
//  }

  @Override
  @PostMapping
  public ResponseEntity<R> save( @RequestBody final S saveRequest) {
    return ResponseEntity.created(null).body(getService().save(saveRequest));
  }

  @Override
  @PutMapping
  public ResponseEntity<R> update( @RequestBody final U updateRequest) {
    return ResponseEntity.created(null).body(getService().update(updateRequest));
  }

  @Override
  @DeleteMapping("{id}")
  public ResponseEntity<Void> deleteById(@PathVariable("id") final I id) {
    getService().deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
