package com.ecommerce.project.exception;

public class ResourceNotFoundException extends RuntimeException{
    String resourceName;
    String field;
    String fieldName;
    Long FieldId;

    public ResourceNotFoundException(){

    }

    public ResourceNotFoundException( String resourceName, String field,String fieldName) {
        super(String.format("%s not found with %s: %s", resourceName, field,fieldName));
        this.fieldName = fieldName;
        this.resourceName = resourceName;
        this.field = field;
    }

    public ResourceNotFoundException(String resourceName, String field,Long fieldId ) {
        super(String.format("%s not found with %s :%s", resourceName, field,fieldId));
        FieldId = fieldId;
        this.field = field;
        this.resourceName = resourceName;
    }
}
