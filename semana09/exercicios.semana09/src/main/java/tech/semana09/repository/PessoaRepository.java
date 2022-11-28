//exercicio 03
//Efetue a criação do repositório da entidade de Pessoas e adicione-o no service de Pessoas para utilizarmos nos
// próximos exercícios.

//exercicio 10
//Crie um método no repository que receberá uma string chamada filter. Esse método deverá buscar via JQPL ou Native
// Query as pessoas que tenham aquela string como parte do nome ou e-mail. Assim como nos exercícios anteriores, crie
// uma rota no controller, chama o service que irá buscar no repository esse método.

package tech.semana09.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.semana09.entity.PessoaEntity;

import java.util.List;


@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {
    List<PessoaEntity> findByStatus(Boolean status);

    @Query(value = "select * from pessoas \n" +
            "where name like %:filter% \n" +
            "or email like %:filter%", nativeQuery = true)
    List<PessoaEntity> filterByNameOrEmail(String filter);
}
