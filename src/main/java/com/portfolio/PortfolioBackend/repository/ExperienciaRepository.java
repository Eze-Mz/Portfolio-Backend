package com.portfolio.PortfolioBackend.repository;

import com.portfolio.PortfolioBackend.model.Experiencia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Long> {
    // el guión bajo no lo tiene en cuenta
    List<Experiencia> findByUsuarioId(Long usuarioId);

    List<Experiencia> findByUsuarioEmail(String user_email);
}
