package com.example.accessingdatajpa.repository;

import com.example.accessingdatajpa.model.Property;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The PropertyRepository interface provides CRUD operations for the Property
 * entity.
 * It extends the CrudRepository interface from Spring Data, allowing for
 * easy management of Property objects in the database.
 *
 * This repository interface allows for the following operations:
 * - Create new property records.
 * - Read existing property records.
 * - Update property records.
 * - Delete property records.
 *
 */
public interface PropertyRepository extends CrudRepository<Property, Long> {

    /**
     * Retrieves a list of properties that match the given address.
     *
     * @param address The address to search for.
     * @return A list of Property objects matching the specified address.
     */
    List<Property> findByAddress(String address);

    /**
     * Retrieves a property by its unique identifier.
     *
     * @param id The unique identifier of the property.
     * @return The Property object with the specified ID, or null if not found.
     */
    Property findById(long id);
}
