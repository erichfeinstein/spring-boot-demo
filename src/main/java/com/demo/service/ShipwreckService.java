package com.demo.service;

import com.demo.exception.ShipwreckNotFound;
import com.demo.model.Shipwreck;
import com.demo.repository.ShipwreckRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Shipwreck findById(long id) {
        final Shipwreck foundShipwreck = shipwreckRepository.findById(id);
        return foundShipwreck;
    }

    public void deleteById(long id) {
        shipwreckRepository.deleteById(id);
    }
}

