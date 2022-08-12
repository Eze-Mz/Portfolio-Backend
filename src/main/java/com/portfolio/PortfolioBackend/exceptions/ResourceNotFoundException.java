package com.portfolio.PortfolioBackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    
    private String resourceName;
    private String resourceField;
    private Long fieldValue;

    public ResourceNotFoundException(String resourceName, String resourceField, Long fieldValue) {
        super(String.format("%s No encontrado con : %s : '%s'", resourceName, resourceField, fieldValue));
        this.resourceName = resourceName;
        this.resourceField = resourceField;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceField() {
        return resourceField;
    }

    public void setResourceField(String resourceField) {
        this.resourceField = resourceField;
    }

    public Long getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(Long fieldValue) {
        this.fieldValue = fieldValue;
    }
            

}
