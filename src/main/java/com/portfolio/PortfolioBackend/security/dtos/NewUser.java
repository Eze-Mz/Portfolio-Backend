package com.portfolio.PortfolioBackend.security.dtos;

import java.util.HashSet;
import java.util.Set;

import jakarta.validation.constraints.NotBlank;

public class NewUser {

    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String nombre;
    private String puesto;
    private String img_hero;
    private String img_perfil;
    private String sobre_mi;
    private String link_1;
    private String link_2;
    private Set<String> roles = new HashSet<>();

    public NewUser() {
    }

    public NewUser(String email, String password, String nombre, String puesto, String img_hero, String img_perfil,
            String sobre_mi, String link_1, String link_2, Set<String> roles) {
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.puesto = puesto;
        this.img_hero = img_hero;
        this.img_perfil = img_perfil;
        this.sobre_mi = sobre_mi;
        this.link_1 = link_1;
        this.link_2 = link_2;
        this.roles = roles;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return this.puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
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

    public Set<String> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

}
