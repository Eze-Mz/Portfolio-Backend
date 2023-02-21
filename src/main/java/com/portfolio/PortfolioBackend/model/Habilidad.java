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
public class Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_skill;

    private String habilidad;
    private Long porcentaje;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    Usuario usuario;

    public Habilidad() {
    }

    public Habilidad(Long id_skill, String habilidad, Long porcentaje) {
        this.id_skill = id_skill;
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
    }

}
