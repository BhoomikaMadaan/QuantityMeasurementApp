package com.app.quantitymeasurement.repository;

import java.util.List;

import com.app.quantitymeasurement.entity.QuantityMeasurementEntity;

public interface IQuantityMeasurementRepository {

    /**
     * Save an entity into repository.
     */
    void save(QuantityMeasurementEntity entity);

    /**
     * Returns all stored entities.
     */
    List<QuantityMeasurementEntity> getAllMeasurements();
}