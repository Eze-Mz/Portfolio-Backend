package com.portfolio.PortfolioBackend.dto;

public class HabilidadDTO extends GenericDTO {
    private Long id_skill;
    private String habilidad;
    private Long porcentaje;

    public HabilidadDTO(Long id_skill, String habilidad, Long porcentaje) {
        this.id_skill = id_skill;
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
    }

    public HabilidadDTO() {
    }

    public Long getId_skill() {
        return this.id_skill;
    }

    public void setId_skill(Long id_skill) {
        this.id_skill = id_skill;
    }

    public String getHabilidad() {
        return this.habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public Long getPorcentaje() {
        return this.porcentaje;
    }

    public void setPorcentaje(Long porcentaje) {
        this.porcentaje = porcentaje;
    }

}
