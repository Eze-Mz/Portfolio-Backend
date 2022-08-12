package com.portfolio.PortfolioBackend.security.entities;

import com.portfolio.PortfolioBackend.model.Educacion;
import com.portfolio.PortfolioBackend.model.Experiencia;
import com.portfolio.PortfolioBackend.model.Habilidad;
import com.portfolio.PortfolioBackend.model.Proyecto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    // todas las otras opciones que no sea nombrar como id a la propiedad me dieron
    // error
    // El guión bajo no se puede usar porque es lo que usa el querymethod para
    // separar
    private Long id;

    @NotNull
    private String nombre;

    @NotNull
    private String password;

    @NotNull
    @Column(unique = true)
    private String email;

    private String img_hero;
    private String img_perfil;
    private String puesto;
    @Column(length = 300)
    private String sobre_mi;
    private String link_1;
    private String link_2;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    // Esta tabla va a servir para identificar que role tiene cada usuario, y que
    // puedan tener más de uno
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Experiencia> listaExperiencia;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Educacion> listaEducacion;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Proyecto> listaProyecto;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Habilidad> listaHabilidad;

    public Usuario() {
    }

    public Usuario(Long id, String nombre, String password, String email, String img_hero, String img_perfil,
            String puesto, String sobre_mi, String link_1, String link_2, Set<Role> roles,
            List<Experiencia> listaExperiencia, List<Educacion> listaEducacion, List<Proyecto> listaProyecto,
            List<Habilidad> listaHabilidad) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.img_hero = img_hero;
        this.img_perfil = img_perfil;
        this.puesto = puesto;
        this.sobre_mi = sobre_mi;
        this.link_1 = link_1;
        this.link_2 = link_2;
        this.roles = roles;
        this.listaExperiencia = listaExperiencia;
        this.listaEducacion = listaEducacion;
        this.listaProyecto = listaProyecto;
        this.listaHabilidad = listaHabilidad;
    }

    public Usuario(String nombre, String password, String email, String img_hero, String img_perfil, String puesto,
            String sobre_mi, String link_1, String link_2) {
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.img_hero = img_hero;
        this.img_perfil = img_perfil;
        this.puesto = puesto;
        this.sobre_mi = sobre_mi;
        this.link_1 = link_1;
        this.link_2 = link_2;
    }

}
