package com.portfolio.PortfolioBackend.security.services;

import java.util.List;
import java.util.Optional;

import com.portfolio.PortfolioBackend.dto.PortfolioDTO;
import com.portfolio.PortfolioBackend.security.entities.Usuario;

public interface IUsuarioService {
    public Usuario crearUsuario(Usuario user);

    public void borrarUsuario(Long id);

    public Usuario buscarUsuario(Long id);

    public List<PortfolioDTO> buscarUsuarios();

    public Optional<Usuario> getByEmail(String email);

    public boolean existsByEmail(String email);

    public boolean existsById(Long id);

    public void actualizarUsuario(Usuario usuario);
}
