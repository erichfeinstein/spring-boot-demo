package com.demo.model;

import lombok.Data;

@Data
public class ResponseStatus {
    public static final String SUCCESS_MESSAGE = "Success";
    private  boolean successfulInd;
    private int statusCode;
    private String statusMessage;
}
