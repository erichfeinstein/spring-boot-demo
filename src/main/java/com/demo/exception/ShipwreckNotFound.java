package com.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ShipwreckNotFound extends Exception {
    public ShipwreckNotFound() {
        super("Shipwreck Not Found!");
    }
}
