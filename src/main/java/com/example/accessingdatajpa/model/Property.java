package com.example.accessingdatajpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * The Property class represents a real estate property.
 * This class is mapped to the 'properties' table in the database.
 * It provides the attributes and methods for managing property details.
 *
 * Annotations:
 * - @Entity: Indicates that this class is a JPA entity.
 */

@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address;
    private Double price;
    private int size;
    private String description;

    protected Property() {
    }

    public Property(String address, Double price, int size, String description) {
        this.address = address;
        this.price = price;
        this.size = size;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format(
                "Property[id=%d, address='%s', price='%s', size='%s', description='%s']",
                id, address, price, size, description);
    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public Double getPrice() {
        return price;
    }

    public int getSize() {
        return size;
    }

    public String getDescription() {
        return description;
    }

    public String setAddress(String address) {
        return this.address = address;
    }

    public Double setPrice(Double price) {
        return this.price = price;
    }

    public int setSize(int size) {
        return this.size = size;
    }

    public String setDescription(String description) {
        return this.description = description;
    }
}
