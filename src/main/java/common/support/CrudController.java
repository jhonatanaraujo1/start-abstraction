package common.support;

import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @param <E> Entity
 * @param <I> Id
 * @param <S> SaveRequest
 * @param <U> UpdateRequest
 * @param <R> Response
 */
public interface CrudController<
    E extends BaseEntity<I>, I, S, U, R> {

  @ApiOperation( "Find by Id")
  R findById(@PathVariable("id") I id);

  @ApiOperation("List pageable")
  Page<R> list(
      @PageableDefault Pageable pagina);

//  @ApiOperation("Exportar relatório")
//  ResponseEntity<byte[]> exportar(
  //      @RequestParam(value = "filter", required = false) String filter,
//      @SortDefault Sort sort,
//      @NotNull @RequestParam(value = "layout") RelatorioLayoutEnum layout,
//      @NotNull @RequestParam(value = "format") RelatorioFormatoEnum format);

  @ApiOperation( "Create")
  ResponseEntity<R> save( @RequestBody S saveRequest);

  @ApiOperation("update")
  ResponseEntity<R> update( @RequestBody U updateRequest);

  @ApiOperation( "Delete by Id")
  ResponseEntity<Void> deleteById(@PathVariable("id") I id);

  AbstractCrudService< E , I, S, U, R>  getService();
}
