package com.gabriel.aviaoempresa.repository;

import com.gabriel.aviaoempresa.model.Aviao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AviaoRepository extends JpaRepository<Aviao, Long> {
}
