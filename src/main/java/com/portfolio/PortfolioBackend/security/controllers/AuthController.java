package com.portfolio.PortfolioBackend.security.controllers;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.PortfolioBackend.security.dtos.JwtDto;
import com.portfolio.PortfolioBackend.security.dtos.LoginUser;
import com.portfolio.PortfolioBackend.security.dtos.NewUser;
import com.portfolio.PortfolioBackend.security.entities.Role;
import com.portfolio.PortfolioBackend.security.entities.Usuario;
import com.portfolio.PortfolioBackend.security.enums.RoleList;
import com.portfolio.PortfolioBackend.security.jwt.JwtProvider;
import com.portfolio.PortfolioBackend.security.services.RoleService;
import com.portfolio.PortfolioBackend.security.services.UsuarioService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    private final static Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    AuthenticationManagerBuilder authenticationManagerBuilder;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RoleService roleService;
    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<Object>("Revise sus credenciales", HttpStatus.BAD_REQUEST);
        }
        try {
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    loginUser.getEmail(), loginUser.getPassword());
            Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generateToken(authentication);
            JwtDto jwtDto = new JwtDto(jwt);
            return new ResponseEntity<>(jwtDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>("Revise sus credenciales", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@Valid @RequestBody NewUser newUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<Object>("Revise los campos e intente nuevamente", HttpStatus.BAD_REQUEST);
        }
        if (usuarioService.existsByEmail(newUser.getEmail())) {
            return new ResponseEntity<>("ese email ya existe", HttpStatus.BAD_REQUEST);
        }
        Usuario usuario = new Usuario(newUser.getNombre(), passwordEncoder.encode(newUser.getPassword()),
                newUser.getEmail(), newUser.getImg_hero(), newUser.getImg_perfil(), newUser.getPuesto(),
                newUser.getSobre_mi(), newUser.getLink_1(), newUser.getLink_2());
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getByRoleName(RoleList.ROLE_USER).get());
        usuario.setRoles(roles);
        return new ResponseEntity<>(usuarioService.crearUsuario(usuario), HttpStatus.CREATED);
    }
}
