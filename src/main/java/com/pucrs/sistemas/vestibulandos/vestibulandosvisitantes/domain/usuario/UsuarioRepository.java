package com.pucrs.sistemas.vestibulandos.vestibulandosvisitantes.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<usuario, Long> {
    usuario findByEmail(String login);

}
