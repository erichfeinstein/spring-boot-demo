package com.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidShipwreck extends Exception{
    public InvalidShipwreck(String message) {
        super(message);
    }
}
