package com.portfolio.PortfolioBackend.service;

import java.util.List;

import com.portfolio.PortfolioBackend.dto.HabilidadDTO;

public interface IHabilidadService {
    public HabilidadDTO crearHabilidad(HabilidadDTO skillDto, Long user_id);

    public void borrarHabilidad(Long id);

    public List<HabilidadDTO> obtenerHabilidadPorUsuarioId(Long userId);

    public List<HabilidadDTO> obtenerHabilidadPorUsuarioEmail(String user_email);

    public HabilidadDTO actualizarHabilidad(HabilidadDTO skillDto, Long user_id, Long id);
}
