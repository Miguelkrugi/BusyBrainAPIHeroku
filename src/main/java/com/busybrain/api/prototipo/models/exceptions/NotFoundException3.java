package com.busybrain.api.prototipo.models.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException3 extends RuntimeException{
    
    private static final long serialVersionUID=5405519104069955535L;

    public NotFoundException3(String id, String elemType, String idName){

       super(elemType + "with " + idName + "" + id + "not found");

    }
    
}