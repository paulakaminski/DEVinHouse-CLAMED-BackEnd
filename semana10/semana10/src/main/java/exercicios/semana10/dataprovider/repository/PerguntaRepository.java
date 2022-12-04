package exercicios.semana10.dataprovider.repository;

import exercicios.semana10.dataprovider.entity.PerguntaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerguntaRepository extends JpaRepository<PerguntaEntity, Long> {

    List<PerguntaEntity> findPerguntaEntitiesByAssuntoEntity_Id(Long id);

    @Query("SELECT a FROM PerguntaEntity a WHERE a.assuntoEntity.id = :id")
    List<PerguntaEntity> findAllByAssuntoId(@Param("id") Long id);
}
