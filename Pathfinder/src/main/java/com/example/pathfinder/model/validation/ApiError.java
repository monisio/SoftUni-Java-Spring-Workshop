package com.example.pathfinder.model.validation;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApiError {

    private final HttpStatus status;
    private List<String> fieldErrors =new ArrayList<>();

    public ApiError(HttpStatus status) {
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void addFieldError(String... error){
        this.fieldErrors.addAll(Arrays.asList(error));
    }

    public List<String> getFieldErrors() {
        return fieldErrors;
    }

    public ApiError setFieldErrors(List<String> fieldErrors) {
        this.fieldErrors = fieldErrors;
        return this;
    }
}
