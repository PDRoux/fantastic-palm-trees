package com.github.pdroux.fantastic_palm_trees.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DataSetNotFoundException extends RuntimeException {
    public DataSetNotFoundException(String message) {
        super(message);
    }
}
