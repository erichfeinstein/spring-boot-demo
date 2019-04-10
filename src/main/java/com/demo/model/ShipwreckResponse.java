package com.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShipwreckResponse {
    private ResponseStatus resStatus;
    private Shipwreck shipwreck;
    private List<Shipwreck> shipwreckList;

    public ShipwreckResponse(Shipwreck shipwreck) {
        this.shipwreck = shipwreck;
        this.resStatus = new ResponseStatus();
    }

    public ShipwreckResponse(List shipwreckList) {
        this.shipwreckList = shipwreckList;
        this.resStatus = new ResponseStatus();
    }
}
