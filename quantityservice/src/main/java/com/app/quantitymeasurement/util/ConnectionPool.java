package com.app.quantitymeasurement.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionPool {

    private static ConnectionPool instance;

    private final HikariDataSource dataSource;

    private ConnectionPool() {

        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(
                ApplicationConfig.getProperty("db.url"));
        config.setUsername(
                ApplicationConfig.getProperty("db.username"));
        config.setPassword(
                ApplicationConfig.getProperty("db.password"));
        config.setDriverClassName(
                ApplicationConfig.getProperty("db.driver"));

        config.setMaximumPoolSize(Integer.parseInt(
                ApplicationConfig.getProperty(
                        "db.hikari.maximum-pool-size")));

        config.setMinimumIdle(Integer.parseInt(
                ApplicationConfig.getProperty(
                        "db.hikari.minimum-idle")));

        config.setConnectionTimeout(Long.parseLong(
                ApplicationConfig.getProperty(
                        "db.hikari.connection-timeout")));

        config.setIdleTimeout(Long.parseLong(
                ApplicationConfig.getProperty(
                        "db.hikari.idle-timeout")));

        config.setMaxLifetime(Long.parseLong(
                ApplicationConfig.getProperty(
                        "db.hikari.max-lifetime")));

        config.setPoolName(
                ApplicationConfig.getProperty(
                        "db.hikari.pool-name"));

        config.setConnectionTestQuery(
                ApplicationConfig.getProperty(
                        "db.hikari.connection-test-query"));

        dataSource = new HikariDataSource(config);
    }

    public static synchronized ConnectionPool getInstance() {

        if (instance == null) {
            instance = new ConnectionPool();
        }

        return instance;
    }

    public Connection getConnection() throws SQLException {

        return dataSource.getConnection();
    }

    public void shutdown() {

        if (dataSource != null) {
            dataSource.close();
        }
    }
}