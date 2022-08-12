package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.ExperienciaDTO;
import java.util.List;

public interface IExperienciaService {
    public ExperienciaDTO crearExperiencia(ExperienciaDTO expDto, Long user_id);

    public void borrarExperiencia(Long id);

    public List<ExperienciaDTO> obtenerExperienciaPorUsuarioId(Long userId);

    public List<ExperienciaDTO> obtenerExperienciaPorUsuarioEmail(String user_email);

    public ExperienciaDTO actualizarExperiencia(ExperienciaDTO expDto, Long user_id, Long exp_id);
}
