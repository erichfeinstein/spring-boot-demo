package com.demo.service;

import com.demo.exception.ShipwreckNotFound;
import com.demo.model.Shipwreck;
import com.demo.model.ShipwreckResponse;
import com.demo.repository.ShipwreckRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipwreckService {
    @Autowired
    private ShipwreckRepository shipwreckRepository;

    public List<Shipwreck> getAll() throws Exception {
        List shipwrecks = shipwreckRepository.findAll();
        return shipwrecks;
    }

    public Shipwreck create(Shipwreck shipwreck) {
        final Shipwreck createdShipwreck = shipwreckRepository.saveAndFlush(shipwreck);
        return createdShipwreck;
    }

    public Shipwreck findById(long id) throws ShipwreckNotFound {
        final Shipwreck foundShipwreck = shipwreckRepository.findById(id);
        if (foundShipwreck == null) throw new ShipwreckNotFound();
        return foundShipwreck;
    }

    public Shipwreck updateById(long id, Shipwreck shipwreck) throws ShipwreckNotFound {
        final Shipwreck shipwreckToUpdate = shipwreckRepository.findById(id);
        if (shipwreckToUpdate == null) throw new ShipwreckNotFound();
        BeanUtils.copyProperties(shipwreck, shipwreckToUpdate);
        Shipwreck updatedShipwreck = shipwreckRepository.saveAndFlush(shipwreck);
        return updatedShipwreck;
    }

    public void deleteById(long id) {
        shipwreckRepository.deleteById(id);
    }
}

