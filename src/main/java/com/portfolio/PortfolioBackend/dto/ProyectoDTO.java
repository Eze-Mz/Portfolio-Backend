package com.portfolio.PortfolioBackend.dto;

public class ProyectoDTO extends GenericDTO {
    private Long id_proyecto;
    private String nombre;
    private String tecnologias;
    private String img_proyecto;
    private String link_sitio;
    private String link_repo;
    private String descripcion;

    public ProyectoDTO() {
    }

    public Long getId_proyecto() {
        return this.id_proyecto;
    }

    public void setId_proyecto(Long id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTecnologias() {
        return this.tecnologias;
    }

    public void setTecnologias(String tecnologias) {
        this.tecnologias = tecnologias;
    }

    public String getImg_proyecto() {
        return this.img_proyecto;
    }

    public void setImg_proyecto(String img_proyecto) {
        this.img_proyecto = img_proyecto;
    }

    public String getLink_sitio() {
        return this.link_sitio;
    }

    public void setLink_sitio(String link_sitio) {
        this.link_sitio = link_sitio;
    }

    public String getLink_repo() {
        return this.link_repo;
    }

    public void setLink_repo(String link_repo) {
        this.link_repo = link_repo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
