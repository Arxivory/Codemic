package com.project.codemic.Codemic.controllers;

import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

public class AbstractController {
    
    public Map<String, String> getErrorResponse(BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return errors;
    }
}
