package com.portfolio.PortfolioBackend.security.services;

import com.portfolio.PortfolioBackend.dto.PortfolioDTO;
import com.portfolio.PortfolioBackend.exceptions.ResourceNotFoundException;
import com.portfolio.PortfolioBackend.security.entities.Usuario;
import com.portfolio.PortfolioBackend.security.repositories.UsuarioRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService implements IUsuarioService {

    @Autowired
    UsuarioRepository userRepo;

    @Override
    public Usuario crearUsuario(Usuario user) {
        Usuario newUser = userRepo.save(user);
        return newUser;
    }

    @Override
    public void borrarUsuario(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public Usuario buscarUsuario(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", id));
    }

    @Override
    public List<PortfolioDTO> buscarUsuarios() {
        List<Usuario> usuarios = userRepo.findAll();
        List<PortfolioDTO> portfoliosDTO = usuarios.stream().map(usuario -> {
            String url = "/portfolio/" + usuario.getEmail();
            PortfolioDTO portfolioDTO = new PortfolioDTO(usuario.getNombre(), usuario.getEmail(), usuario.getPuesto(),
                    url);
            return portfolioDTO;
        }).collect(Collectors.toList());
        return portfoliosDTO;
    }

    @Override
    public Optional<Usuario> getByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepo.existsByEmail(email);
    }

    @Override
    public boolean existsById(Long id) {
        return userRepo.existsById(id);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        userRepo.save(usuario);
    }

}
