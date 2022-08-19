package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.EducacionDTO;
import java.util.List;

public interface IEducacionService {
    public EducacionDTO crearEducacion(EducacionDTO eduDto, Long user_id);

    public void borrarEducacion(Long id);

    public List<EducacionDTO> obtenerEducacionPorUsuarioEmail(String user_email);

    public EducacionDTO actualizarEducacion(EducacionDTO eduDto, Long user_id, Long id);
}
