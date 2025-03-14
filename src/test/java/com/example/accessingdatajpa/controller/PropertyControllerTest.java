package com.example.accessingdatajpa.controller;

import com.example.accessingdatajpa.model.Property;
import com.example.accessingdatajpa.repository.PropertyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PropertyControllerTest {

    @InjectMocks
    private PropertyController propertyController;

    @Mock
    private PropertyRepository propertyRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateProperty() {
        Property property = new Property("123 Main St", 250000.0, 1500, "Nice property");
        when(propertyRepository.save(any(Property.class))).thenReturn(property);

        ResponseEntity<Property> response = propertyController.createProperty(property);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(property, response.getBody());
    }

    @Test
    public void testGetAllProperties() {
        Property property1 = new Property("123 Main St", 250000.0, 1500, "Nice property");
        Property property2 = new Property("456 Oak Ave", 300000.0, 2000, "Great location");
        when(propertyRepository.findAll()).thenReturn(Arrays.asList(property1, property2));

        List<Property> properties = propertyController.getAllProperties();

        assertEquals(2, properties.size());
    }







    @Test
    public void testDeleteProperty() {
        when(propertyRepository.existsById(1L)).thenReturn(true);
        ResponseEntity<Void> response = propertyController.deleteProperty(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(propertyRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testDeletePropertyNotFound() {
        when(propertyRepository.existsById(1L)).thenReturn(false);
        ResponseEntity<Void> response = propertyController.deleteProperty(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(propertyRepository, times(0)).deleteById(1L);
    }
}
