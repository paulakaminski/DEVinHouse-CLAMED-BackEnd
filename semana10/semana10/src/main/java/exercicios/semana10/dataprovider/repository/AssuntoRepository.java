package exercicios.semana10.dataprovider.repository;

import exercicios.semana10.dataprovider.entity.AssuntoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssuntoRepository extends JpaRepository<AssuntoEntity, Long> {
}
