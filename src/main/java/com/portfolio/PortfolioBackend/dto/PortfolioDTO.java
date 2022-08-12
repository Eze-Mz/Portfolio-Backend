package com.portfolio.PortfolioBackend.dto;

public class PortfolioDTO {
    private String nombre;
    private String email;
    private String puesto;
    private String link;

    public PortfolioDTO() {
    }

    public PortfolioDTO(String nombre, String email, String puesto, String link) {
        this.nombre = nombre;
        this.email = email;
        this.puesto = puesto;
        this.link = link;
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

    public String getPuesto() {
        return this.puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
