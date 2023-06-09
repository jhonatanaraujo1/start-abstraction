package api.exemplo.repository;

import api.exemplo.entity.ExempleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExempleRepository extends JpaRepository<ExempleEntity, Integer> {
}
