package com.pucrs.sistemas.vestibulandos.vestibulandosvisitantes.domain.provas.prova;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvaRepository extends JpaRepository<Prova, Long> {
}
