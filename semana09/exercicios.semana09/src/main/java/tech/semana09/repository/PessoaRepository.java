package tech.semana09.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.semana09.entity.PessoaEntity;

import java.util.List;


@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {
    List<PessoaEntity> findByStatus(Boolean status);
}
