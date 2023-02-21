package com.portfolio.PortfolioBackend.model;

import com.portfolio.PortfolioBackend.security.entities.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_ed;
    private String titulo;
    private String institucion;
    private String img_inst;
    private String fechas;
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    Usuario usuario;

    public Educacion() {
    }

    public Educacion(Long id_ed, String titulo, String institucion, String img_inst, String fechas, String descripcion,
            Usuario usuario) {
        this.id_ed = id_ed;
        this.titulo = titulo;
        this.institucion = institucion;
        this.img_inst = img_inst;
        this.fechas = fechas;
        this.descripcion = descripcion;
        this.usuario = usuario;
    }
}
