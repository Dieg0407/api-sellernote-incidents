package pe.external.sellercenter.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.external.sellercenter.domain.entity.IncidenceEntity;

public interface IIncidenceRepository extends JpaRepository<IncidenceEntity, Long> {
}
