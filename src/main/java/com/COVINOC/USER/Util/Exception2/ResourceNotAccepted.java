package com.COVINOC.USER.Util.Exception2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class ResourceNotAccepted extends Exception {

    public ResourceNotAccepted(String message){
        super(message);
    }
}
