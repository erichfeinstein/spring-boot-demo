package com.demo.controller;

import com.demo.model.Shipwreck;
import com.demo.service.ShipwreckService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@Slf4j
public class ShipwreckController {

    @Autowired
    ShipwreckService shipwreckService;

    @RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
    public List<Shipwreck> list() {
        try {
            List<Shipwreck> allShips = shipwreckService.getAll();
            return allShips;
        } catch (Exception e) {
            Logger logger = LoggerFactory.getLogger(ShipwreckController.class);
            logger.info("There was a problem");
            return null;
        }
    }

    @RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
    public Shipwreck create(@RequestBody Shipwreck shipwreck) {
        Shipwreck newShipwreck = shipwreckService.create(shipwreck);
        return newShipwreck;
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        shipwreckService.deleteById(id);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
    public Shipwreck get(@PathVariable Long id) {
        Shipwreck foundShipwreck = shipwreckService.findById(id);
        return foundShipwreck;
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
    public  Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck) {
        return ShipwreckStub.update(id, shipwreck);
    }
}
