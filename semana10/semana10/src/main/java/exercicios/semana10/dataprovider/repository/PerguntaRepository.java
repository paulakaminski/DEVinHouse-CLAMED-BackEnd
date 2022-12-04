package exercicios.semana10.dataprovider.repository;

import exercicios.semana10.dataprovider.entity.PerguntaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerguntaRepository extends JpaRepository<PerguntaEntity, Long> {

    public List<PerguntaEntity> findPerguntaEntitiesByAssuntoEntity_Id(Long id);

}
