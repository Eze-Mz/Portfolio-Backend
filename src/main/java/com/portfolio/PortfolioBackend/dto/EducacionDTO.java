package com.portfolio.PortfolioBackend.dto;

public class EducacionDTO extends GenericDTO {
    private Long id_ed;
    private String titulo;
    private String institucion;
    private String img_inst;
    private String fechas;
    private String descripcion;

    public EducacionDTO() {
    }

    public Long getId_ed() {
        return id_ed;
    }

    public void setId_ed(Long id_ed) {
        this.id_ed = id_ed;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getImg_inst() {
        return img_inst;
    }

    public void setImg_inst(String img_inst) {
        this.img_inst = img_inst;
    }

    public String getFechas() {
        return fechas;
    }

    public void setFechas(String fechas) {
        this.fechas = fechas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EducacionDTO(Long id_ed, String titulo, String institucion, String img_inst, String fechas, String descripcion) {
        super();
        this.id_ed = id_ed;
        this.titulo = titulo;
        this.institucion = institucion;
        this.img_inst = img_inst;
        this.fechas = fechas;
        this.descripcion = descripcion;
    }
    
    
    
}
