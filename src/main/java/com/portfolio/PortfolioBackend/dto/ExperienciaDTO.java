package com.portfolio.PortfolioBackend.dto;

public class ExperienciaDTO extends GenericDTO {
    private Long id_exp;
    private String tarea;
    private String empresa;
    private String img_empresa;
    private String tiempo;
    private String descripcion;

    public ExperienciaDTO() {
        super();
    }

    public Long getId_exp() {
        return id_exp;
    }

    public void setId_exp(Long id_exp) {
        this.id_exp = id_exp;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getImg_empresa() {
        return img_empresa;
    }

    public void setImg_empresa(String img_empresa) {
        this.img_empresa = img_empresa;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
