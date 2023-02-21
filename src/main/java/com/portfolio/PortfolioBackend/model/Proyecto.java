package com.portfolio.PortfolioBackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import com.portfolio.PortfolioBackend.security.entities.Usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_proyecto;
    private String nombre;
    private String tecnologias;
    private String img_proyecto;
    private String link_sitio;
    private String link_repo;
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    Usuario usuario;

    public Proyecto() {
    }

    public Proyecto(Long id_proyecto, String nombre, String tecnologias, String img_proyecto, String link_sitio,
            String link_repo, String descripcion, Usuario usuario) {
        this.id_proyecto = id_proyecto;
        this.nombre = nombre;
        this.tecnologias = tecnologias;
        this.img_proyecto = img_proyecto;
        this.link_sitio = link_sitio;
        this.link_repo = link_repo;
        this.descripcion = descripcion;
        this.usuario = usuario;
    }

}
