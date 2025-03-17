package com.github.pdroux.fantastic_palm_trees.dao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidDataSet extends RuntimeException {
    public InvalidDataSet(String message) {
        super(message);
    }
}
