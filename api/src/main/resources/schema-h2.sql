-- AUTHENTICATION
DROP TABLE IF EXISTS AUTHENTICATION;
CREATE TABLE AUTHENTICATION (
    id BIGINT NOT NULL IDENTITY PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);
-- PROCEDURE
DROP TABLE IF EXISTS PROCEDURE;
CREATE TABLE PROCEDURE (
    id BIGINT NOT NULL IDENTITY PRIMARY KEY,
    appointment_id BIGINT NOT NULL,
    procedure_code BIGINT NOT NULL,
    invoice_id BIGINT NOT NULL,
    description VARCHAR(255),
    tooth CHAR,
    procedure_count INT CHECK(procedure_count >= 0)
);
-- -- TREATMENT
DROP TABLE IF EXISTS TREATMENT;
CREATE TABLE TREATMENT (
    medication VARCHAR(255) PRIMARY KEY,
    procedure_id INT NOT NULL,
    teeth CHAR,
    --?
    symptoms VARCHAR(255),
    comments VARCHAR(255)
);
-- APPOINTMENT_TYPE
DROP TABLE IF EXISTS APPOINTMENT_TYPE;
CREATE TABLE APPOINTMENT_TYPE (
    id BIGINT NOT NULL IDENTITY PRIMARY KEY,
    type VARCHAR(255) UNIQUE NOT NULL
);
-- APPOINTMENT_STATUS
DROP TABLE IF EXISTS APPOINTMENT_STATUS;
CREATE TABLE APPOINTMENT_STATUS (
    id BIGINT NOT NULL IDENTITY PRIMARY KEY,
    status VARCHAR(255) UNIQUE NOT NULL
);
-- APPOINTMENT
DROP TABLE IF EXISTS APPOINTMENT;
CREATE TABLE APPOINTMENT (
    id BIGINT NOT NULL IDENTITY PRIMARY KEY,
    branch_id INT NOT NULL,
    employee_id INT NOT NULL,
    patient_id INT NOT NULL,
    start_time TIMESTAMP,
    end_time TIMESTAMP,
    type INT NOT NULL,
    status INT NOT NULL,
    room_number VARCHAR
);