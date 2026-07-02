package com.app.quantitymeasurement.repository;

import com.app.quantitymeasurement.entity.QuantityMeasurementEntity;
import com.app.quantitymeasurement.exception.DatabaseException;
import com.app.quantitymeasurement.util.ConnectionPool;

import java.sql.*;
import java.util.*;
import java.util.logging.Logger;

public class QuantityMeasurementDatabaseRepository
        implements IQuantityMeasurementRepository {

    private static final Logger logger =
            Logger.getLogger(
                    QuantityMeasurementDatabaseRepository.class.getName());

    private static QuantityMeasurementDatabaseRepository instance;
    private static final String INSERT_QUERY =
            "INSERT INTO quantity_measurement_entity " +
            "(this_value, this_unit, this_measurement_type, " +
            "that_value, that_unit, that_measurement_type, " +
            "operation, result_value, result_unit, " +
            "result_measurement_type, result_string, is_error, error_message, " +
            "created_at, updated_at) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW())";

    private static final String SELECT_ALL_QUERY =
            "SELECT * FROM quantity_measurement_entity ORDER BY created_at DESC";

    private static final String SELECT_BY_OPERATION =
            "SELECT * FROM quantity_measurement_entity WHERE operation = ? ORDER BY created_at DESC";

    private static final String SELECT_BY_MEASUREMENT_TYPE =
            "SELECT * FROM quantity_measurement_entity WHERE this_measurement_type = ? ORDER BY created_at DESC";

    private static final String DELETE_ALL_QUERY =
            "DELETE FROM quantity_measurement_entity";

    private static final String COUNT_QUERY =
            "SELECT COUNT(*) FROM quantity_measurement_entity";

    private ConnectionPool connectionPool;
    
    private QuantityMeasurementDatabaseRepository() {

        connectionPool = ConnectionPool.getInstance();

        initializeDatabase();
    }

    public static synchronized QuantityMeasurementDatabaseRepository getInstance() {

        if (instance == null) {

            instance = new QuantityMeasurementDatabaseRepository();
        }

        return instance;
    }
    
    private void initializeDatabase() {

        String createTableQuery =
                "CREATE TABLE IF NOT EXISTS quantity_measurement_entity (" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                "this_value DOUBLE," +
                "this_unit VARCHAR(50)," +
                "this_measurement_type VARCHAR(50)," +
                "that_value DOUBLE," +
                "that_unit VARCHAR(50)," +
                "that_measurement_type VARCHAR(50)," +
                "operation VARCHAR(50)," +
                "result_value DOUBLE," +
                "result_unit VARCHAR(50)," +
                "result_measurement_type VARCHAR(50)," +
                "result_string CLOB," +
                "is_error BOOLEAN," +
                "error_message CLOB," +
                "created_at TIMESTAMP," +
                "updated_at TIMESTAMP" +
                ")";

        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement()) {

            statement.execute(createTableQuery);

        } catch (SQLException e) {

            throw new DatabaseException(
                    "Failed to initialize database",
                    e);
        }
    }
    
    @Override
    public void save(
            QuantityMeasurementEntity entity) {

        try (Connection connection =
                     connectionPool.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(
                             INSERT_QUERY)) {

            statement.setDouble(
                    1,
                    entity.getThisValue());

            statement.setString(
                    2,
                    entity.getThisUnit());

            statement.setString(
                    3,
                    entity.getThisMeasurementType());

            statement.setDouble(
                    4,
                    entity.getThatValue());

            statement.setString(
                    5,
                    entity.getThatUnit());

            statement.setString(
                    6,
                    entity.getThatMeasurementType());

            statement.setString(
                    7,
                    entity.getOperation());

            statement.setDouble(
                    8,
                    entity.getResultValue());

            statement.setString(
                    9,
                    entity.getResultUnit());

            statement.setString(
                    10,
                    entity.getResultMeasurementType());

            statement.setString(
                    11,
                    entity.getResultString());

            statement.setBoolean(
                    12,
                    entity.isError());

            statement.setString(
                    13,
                    entity.getErrorMessage());

            statement.executeUpdate();

            logger.info("Measurement saved successfully.");

        } catch (SQLException e) {

            throw new DatabaseException(
                    "Failed to save measurement.",
                    e);
        }
    }
    @Override
    public List<QuantityMeasurementEntity> getAllMeasurements() {

        List<QuantityMeasurementEntity> measurements =
                new ArrayList<>();

        try (Connection connection =
                     connectionPool.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(
                             SELECT_ALL_QUERY);
             ResultSet rs =
                     statement.executeQuery()) {

            while (rs.next()) {

                measurements.add(
                        mapResultSetToEntity(rs));
            }

            return measurements;

        } catch (SQLException e) {

            throw new DatabaseException(
                    "Failed to retrieve measurements.",
                    e);
        }
    }
    
    @Override
    public List<QuantityMeasurementEntity> getMeasurementsByOperation(
            String operation) {

        List<QuantityMeasurementEntity> measurements =
                new ArrayList<>();

        try (Connection connection =
                     connectionPool.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(
                             SELECT_BY_OPERATION)) {

            statement.setString(1, operation);

            try (ResultSet rs = statement.executeQuery()) {

                while (rs.next()) {

                    measurements.add(
                            mapResultSetToEntity(rs));
                }
            }

            return measurements;

        } catch (SQLException e) {

            throw new DatabaseException(
                    "Failed to retrieve measurements by operation.",
                    e);
        }
    }
    
    @Override
    public List<QuantityMeasurementEntity> getMeasurementsByType(
            String measurementType) {

        List<QuantityMeasurementEntity> measurements =
                new ArrayList<>();

        try (Connection connection =
                     connectionPool.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(
                             SELECT_BY_MEASUREMENT_TYPE)) {

            statement.setString(1, measurementType);

            try (ResultSet rs = statement.executeQuery()) {

                while (rs.next()) {

                    measurements.add(
                            mapResultSetToEntity(rs));
                }
            }

            return measurements;

        } catch (SQLException e) {

            throw new DatabaseException(
                    "Failed to retrieve measurements by type.",
                    e);
        }
    }
    
    @Override
    public int getTotalCount() {

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(COUNT_QUERY);
             ResultSet rs = statement.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1);
            }

            return 0;

        } catch (SQLException e) {

            throw new DatabaseException(
                    "Failed to count measurements.",
                    e);
        }
    }
    
    @Override
    public void deleteAll() {

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(DELETE_ALL_QUERY)) {

            statement.executeUpdate();

        } catch (SQLException e) {

            throw new DatabaseException(
                    "Failed to delete measurements.",
                    e);
        }
    }
    
    @Override
    public String getPoolStatistics() {

        return "Connection Pool Active";
    }
    
    @Override
    public void releaseResources() {

        connectionPool.shutdown();
    }
    
    private QuantityMeasurementEntity mapResultSetToEntity(
            ResultSet rs) throws SQLException {

        QuantityMeasurementEntity entity =
                new QuantityMeasurementEntity();

        entity.thisValue =
                rs.getDouble("this_value");
        entity.thisUnit =
                rs.getString("this_unit");
        entity.thisMeasurementType =
                rs.getString("this_measurement_type");

        entity.otherValue =
                rs.getDouble("that_value");
        entity.otherUnit =
                rs.getString("that_unit");
        entity.otherMeasurementType =
                rs.getString("that_measurement_type");

        entity.operation =
                rs.getString("operation");

        entity.resultValue =
                rs.getDouble("result_value");
        entity.resultUnit =
                rs.getString("result_unit");
        entity.resultMeasurementType =
                rs.getString("result_measurement_type");

        entity.result =
                rs.getString("result_string");

        entity.isError =
                rs.getBoolean("is_error");

        entity.errorMessage =
                rs.getString("error_message");

        return entity;
    }
}