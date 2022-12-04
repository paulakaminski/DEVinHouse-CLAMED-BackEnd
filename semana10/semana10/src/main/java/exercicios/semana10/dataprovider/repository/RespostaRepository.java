package exercicios.semana10.dataprovider.repository;

import exercicios.semana10.dataprovider.entity.RespostaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespostaRepository extends JpaRepository<RespostaEntity, Long> {

    List<RespostaEntity> findRespostaEntitiesByPerguntaEntity_Id(Long id);

}
