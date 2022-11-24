//exercicio 03
//Efetue a criação do repositório da entidade de Pessoas e adicione-o no service de Pessoas para utilizarmos nos
// próximos exercícios.

package tech.semana09.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.semana09.entity.PessoaEntity;

import java.util.List;


@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {
    List<PessoaEntity> findByStatus(Boolean status);
}
