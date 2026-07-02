package com.app.quantitymeasurement.repository;

import java.util.ArrayList;
import java.util.List;

import com.app.quantitymeasurement.entity.QuantityMeasurementEntity;

public class QuantityMeasurementCacheRepository
        implements IQuantityMeasurementRepository {

    private static QuantityMeasurementCacheRepository instance;

    private final List<QuantityMeasurementEntity> measurements;

    /**
     * Private constructor
     */
    private QuantityMeasurementCacheRepository() {

        measurements = new ArrayList<>();
    }

    /**
     * Singleton Instance
     */
    public static QuantityMeasurementCacheRepository getInstance() {

        if (instance == null) {

            instance = new QuantityMeasurementCacheRepository();
        }

        return instance;
    }

    /**
     * Save entity
     */
    @Override
    public void save(
            QuantityMeasurementEntity entity) {

        measurements.add(entity);
    }

    /**
     * Return all entities
     */
    @Override
    public List<QuantityMeasurementEntity> getAllMeasurements() {

        return new ArrayList<>(measurements);
    }

    /**
     * Returns latest operation
     */
    public QuantityMeasurementEntity getLatestMeasurement() {

        if (measurements.isEmpty()) {

            return null;
        }

        return measurements.get(
                measurements.size() - 1);
    }

    /**
     * Clear repository
     */
    public void clear() {

        measurements.clear();
    }

    /**
     * Repository size
     */
    public int size() {

        return measurements.size();
    }
    @Override
    public List<QuantityMeasurementEntity> getMeasurementsByOperation(
            String operation) {

        return new ArrayList<>();
    }

    @Override
    public List<QuantityMeasurementEntity> getMeasurementsByType(
            String measurementType) {

        return new ArrayList<>();
    }

    @Override
    public int getTotalCount() {

        return measurements.size();
    }

    @Override
    public void deleteAll() {

        measurements.clear();
    }

    @Override
    public String getPoolStatistics() {

        return "Cache Repository";
    }

    @Override
    public void releaseResources() {

        // No resources to release
    }
}