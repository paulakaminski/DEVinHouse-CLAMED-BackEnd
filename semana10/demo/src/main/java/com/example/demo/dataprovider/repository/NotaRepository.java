package com.example.demo.dataprovider.repository;

import com.example.demo.dataprovider.entity.AnotacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepository extends JpaRepository<AnotacaoEntity, Long> {

}
