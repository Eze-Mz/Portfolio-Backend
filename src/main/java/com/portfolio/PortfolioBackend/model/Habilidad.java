package com.portfolio.PortfolioBackend.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
