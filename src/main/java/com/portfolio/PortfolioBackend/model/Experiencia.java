package com.portfolio.PortfolioBackend.model;

import com.portfolio.PortfolioBackend.security.entities.Usuario;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_exp;
    private String tarea;
    private String empresa;
    private String img_empresa;
    private String tiempo;
    private String descripcion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    Usuario usuario;
    
    public Experiencia() {
    }

    public Experiencia(Long id_exp, String tarea, String empresa, String img_empresa, String tiempo, String descripcion, Usuario usuario) {
        this.id_exp = id_exp;
        this.tarea = tarea;
        this.empresa = empresa;
        this.img_empresa = img_empresa;
        this.tiempo = tiempo;
        this.descripcion = descripcion;
        this.usuario = usuario;
    }

 


    
    
}
