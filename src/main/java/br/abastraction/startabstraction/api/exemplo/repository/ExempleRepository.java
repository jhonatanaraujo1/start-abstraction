package br.abastraction.startabstraction.api.exemplo.repository;

import br.abastraction.startabstraction.api.exemplo.entity.ExempleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExempleRepository extends JpaRepository<ExempleEntity, Integer> {
}
