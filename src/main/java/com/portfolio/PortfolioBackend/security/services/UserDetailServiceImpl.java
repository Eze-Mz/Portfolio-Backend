package com.portfolio.PortfolioBackend.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.portfolio.PortfolioBackend.security.entities.MainUser;
import com.portfolio.PortfolioBackend.security.entities.Usuario;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String emailUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.getByEmail(emailUsuario).get();
        return MainUser.build(usuario);
    }

}
