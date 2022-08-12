package com.portfolio.PortfolioBackend.repository;

import com.portfolio.PortfolioBackend.model.Educacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Long> {
    List<Educacion> findByUsuarioId(Long usuarioId);

    List<Educacion> findByUsuarioEmail(String user_email);
}
