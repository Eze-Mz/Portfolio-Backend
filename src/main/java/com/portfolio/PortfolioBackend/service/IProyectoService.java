package com.portfolio.PortfolioBackend.service;

import java.util.List;

import com.portfolio.PortfolioBackend.dto.ProyectoDTO;

public interface IProyectoService {
    public ProyectoDTO crearProyecto(ProyectoDTO proyectoDTO, Long user_id);

    public void borrarProyecto(Long id);

    public List<ProyectoDTO> obtenerProyectoPorUsuarioEmail(String user_email);

    public ProyectoDTO actualizarProyecto(ProyectoDTO proyectoDTO, Long user_id, Long id);
}
