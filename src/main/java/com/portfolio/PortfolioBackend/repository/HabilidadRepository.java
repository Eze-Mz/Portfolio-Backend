package com.portfolio.PortfolioBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.PortfolioBackend.model.Habilidad;

@Repository
public interface HabilidadRepository extends JpaRepository<Habilidad, Long> {
    List<Habilidad> findByUsuarioId(Long usuarioId);

    List<Habilidad> findByUsuarioEmail(String user_email);
}
