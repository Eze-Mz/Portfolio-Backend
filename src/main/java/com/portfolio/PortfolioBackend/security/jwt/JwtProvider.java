package com.portfolio.PortfolioBackend.security.jwt;

import com.portfolio.PortfolioBackend.security.entities.MainUser;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {
    // Logger para mostrar los errores
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    // clave para verificar el token
    private String secret2 = System.getProperties().getProperty("jwt.secret");
    @Value("${jwt.secret}")
    private String secret;

    // tiempo base de expiración
    @Value("${jwt.expiration}")
    private int expiration;

    // función que crea el token
    public String generateToken(Authentication auth) {
        logger.info(secret2);
        MainUser mainUser = (MainUser) auth.getPrincipal();
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

        Long id = mainUser.getId();
        String email = mainUser.getEmail();
        Math.toIntExact(id);

        List<String> roles = mainUser.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return Jwts.builder().setSubject(mainUser.getEmail())
                .claim("userId", id)
                .claim("userEmail", email)
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .signWith(key)
                .compact();
    }

    // función que permita obtener el nombre de usuario desde el token
    public String getNombreUsuarioFromToken(String token) {
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
    }

    // función que permita validar el token
    public boolean validateToken(String token) {
        try {
            SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("token mal formado");
        } catch (UnsupportedJwtException e) {
            logger.error("token no soportado");
        } catch (ExpiredJwtException e) {
            logger.error("token expirado");
        } catch (IllegalArgumentException e) {
            logger.error("token vacío");
        } catch (SignatureException e) {
            logger.error("error en la firma");
        }
        return false;
    }

}
