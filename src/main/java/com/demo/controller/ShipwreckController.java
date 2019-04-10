package com.demo.controller;

import com.demo.model.Shipwreck;
import com.demo.model.ShipwreckResponse;
import com.demo.service.ShipwreckService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@Slf4j
public class ShipwreckController {

    @Autowired
    ShipwreckService shipwreckService;

    @RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
    public ResponseEntity list() {
        try {
            List<Shipwreck> allShips = shipwreckService.getAll();
//            return allShips;
            return marshallResponse(allShips, HttpStatus.OK);
        } catch (Exception e) {
            Logger logger = LoggerFactory.getLogger(ShipwreckController.class);
            logger.info("There was a problem");
            return null;
        }
    }

    @RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
    public Shipwreck create(@RequestBody Shipwreck shipwreck) {
        try {
            Shipwreck newShipwreck = shipwreckService.create(shipwreck);
            return newShipwreck;
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            shipwreckService.deleteById(id);
        }catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
    public Shipwreck get(@PathVariable Long id) {
        try {
            Shipwreck foundShipwreck = shipwreckService.findById(id);
            return foundShipwreck;
//            return marshallResponse(foundShipwreck, HttpStatus.OK);
        }
        catch (Exception e) {
            return null;
//            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
    public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck) {
        try {
            Shipwreck updatedShipwreck = shipwreckService.updateById(id, shipwreck);
            return updatedShipwreck;
//            return marshallResponse(updatedShipwreck, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return null;
//            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    private ResponseEntity<ShipwreckResponse> marshallResponse(Shipwreck shipwreck, HttpStatus httpStatus) {
        ShipwreckResponse shipwreckResponse = new ShipwreckResponse(shipwreck);
        return new ResponseEntity<>(shipwreckResponse, httpStatus);
    }
    private ResponseEntity<ShipwreckResponse> marshallResponse(List<Shipwreck> shipwreckList, HttpStatus httpStatus) {
        ShipwreckResponse shipwreckListResponse = new ShipwreckResponse(shipwreckList);
        return new ResponseEntity<>(shipwreckListResponse, httpStatus);
    }
}
