package com.demo;

import com.demo.controller.ShipwreckController;
import com.demo.model.Shipwreck;
import com.demo.repository.ShipwreckRepository;
import com.demo.service.ShipwreckService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ShipwreckControllerTest {
    @InjectMocks
    private ShipwreckController sc;

    @Autowired
    private ShipwreckRepository shipwreckRepository;

    @Mock
    private ShipwreckService shipwreckService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShipwreckGet() {
        Shipwreck sw = new Shipwreck();
        sw.setId(1l);
        when(shipwreckRepository.findById(1l)).thenReturn(sw);
        Shipwreck shipwreck = sc.get(1L);
        assertEquals(1L, shipwreck.getId().longValue());
    }
}
