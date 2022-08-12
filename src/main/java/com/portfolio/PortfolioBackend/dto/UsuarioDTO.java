package com.portfolio.PortfolioBackend.dto;

public class UsuarioDTO {
    private Long id;
    private String nombre;
    private String email;
    private String img_hero;
    private String img_perfil;
    private String puesto;
    private String sobre_mi;
    private String link_1;
    private String link_2;

    public UsuarioDTO(Long id, String nombre, String email, String img_hero, String img_perfil, String puesto,
            String sobre_mi, String link_1, String link_2) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.img_hero = img_hero;
        this.img_perfil = img_perfil;
        this.puesto = puesto;
        this.sobre_mi = sobre_mi;
        this.link_1 = link_1;
        this.link_2 = link_2;
    }

    public UsuarioDTO(String nombre, String email, String puesto) {
        this.nombre = nombre;
        this.email = email;
        this.puesto = puesto;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImg_hero() {
        return this.img_hero;
    }

    public void setImg_hero(String img_hero) {
        this.img_hero = img_hero;
    }

    public String getImg_perfil() {
        return this.img_perfil;
    }

    public void setImg_perfil(String img_perfil) {
        this.img_perfil = img_perfil;
    }

    public String getPuesto() {
        return this.puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getSobre_mi() {
        return this.sobre_mi;
    }

    public void setSobre_mi(String sobre_mi) {
        this.sobre_mi = sobre_mi;
    }

    public String getLink_1() {
        return this.link_1;
    }

    public void setLink_1(String link_1) {
        this.link_1 = link_1;
    }

    public String getLink_2() {
        return this.link_2;
    }

    public void setLink_2(String link_2) {
        this.link_2 = link_2;
    }

}
