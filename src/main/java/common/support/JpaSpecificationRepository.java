package common.support;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface JpaSpecificationRepository<E extends BaseEntity<I>, I>
    extends JpaRepository<E, I>, JpaSpecificationExecutor<E> {}
