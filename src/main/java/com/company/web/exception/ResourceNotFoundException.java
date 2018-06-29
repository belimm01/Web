package com.company.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//The APIs will throw a ResourceNotFoundException whenever a User/Account
//with a given id is not found in the database.

@ResponseStatus(value = HttpStatus.NOT_FOUND)
/**
 * Exception when the resource is not found.
 */
public class ResourceNotFoundException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private Object fieldValue;
/**
 * Exception when the resourceName or fieldName of fieldValue disagree with database.
 * @param resourceName 
 * @param fieldName Name of a field in  database.
 * @param fieldValue Value of searched field in database.
 */
    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
/**
 * Getter for resourceName.
 * @return got resourceName in form String.
 */
    public String getResourceName() {
        return resourceName;
    }
/**
 * Getter for fieldName.
 * @return got fieldName in form String.
 */
    public String getFieldName() {
        return fieldName;
    }
/**
 * Getter for fieldValue.
 * @return got fieldValue in form Object.
 */
    public Object getFieldValue() {
        return fieldValue;
    }
}