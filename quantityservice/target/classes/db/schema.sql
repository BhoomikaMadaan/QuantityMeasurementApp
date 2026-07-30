CREATE TABLE IF NOT EXISTS quantity_measurement_entity (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    this_value DOUBLE,
    this_unit VARCHAR(50),
    this_measurement_type VARCHAR(50),

    that_value DOUBLE,
    that_unit VARCHAR(50),
    that_measurement_type VARCHAR(50),

    operation VARCHAR(50),

    result_value DOUBLE,
    result_unit VARCHAR(50),
    result_measurement_type VARCHAR(50),

    result_string TEXT,

    is_error BOOLEAN,
    error_message TEXT,

    created_at TIMESTAMP,
    updated_at TIMESTAMP
);