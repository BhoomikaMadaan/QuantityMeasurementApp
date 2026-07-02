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

    /**
     * Returns all measurements for a given operation.
     */
    List<QuantityMeasurementEntity> getMeasurementsByOperation(
            String operation);

    /**
     * Returns all measurements for a given measurement type.
     */
    List<QuantityMeasurementEntity> getMeasurementsByType(
            String measurementType);

    /**
     * Returns total number of stored measurements.
     */
    int getTotalCount();

    /**
     * Deletes all stored measurements.
     */
    void deleteAll();

    /**
     * Returns connection pool statistics.
     */
    String getPoolStatistics();

    /**
     * Releases repository resources.
     */
    void releaseResources();
}