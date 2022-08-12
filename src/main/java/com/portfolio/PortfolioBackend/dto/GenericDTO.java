package com.portfolio.PortfolioBackend.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "dataType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ExperienciaDTO.class, name = "experiences"),
        @JsonSubTypes.Type(value = EducacionDTO.class, name = "education"),
        @JsonSubTypes.Type(value = ProyectoDTO.class, name = "proyects"),
        @JsonSubTypes.Type(value = HabilidadDTO.class, name = "skills"),
})
public abstract class GenericDTO {

    public GenericDTO() {
    }

}
