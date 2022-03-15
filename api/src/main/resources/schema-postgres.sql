-- AUTHENTICATION
DROP TABLE IF EXISTS AUTHENTICATION CASCADE;
CREATE TABLE AUTHENTICATION (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY UNIQUE NOT NULL,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);
-- Phone
DROP TABLE IF EXISTS PHONE CASCADE;
CREATE TABLE PHONE(phoneNumber BIGINT NOT NULL PRIMARY KEY);
-- Province
DROP TABLE IF EXISTS PROVINCE CASCADE;
CREATE TABLE PROVINCE(
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY UNIQUE NOT NULL,
    PROVINCE VARCHAR(20) CHECK (
        PROVINCE IN(
            'AB',
            'BC',
            'MB',
            'NB',
            'NL',
            'NT',
            'NS',
            'NU',
            'ON',
            'PE',
            'QC',
            'SK',
            'YT'
        )
    )
);
-- Address
DROP TABLE IF EXISTS ADDRESS CASCADE;
CREATE TABLE ADDRESS(
    buildingNumber INTEGER NOT NULL CHECK(buildingNumber > 0),
    street VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    province BIGINT NOT NULL,
    postalCode VARCHAR(7) NOT NULL,
    PRIMARY KEY (
        buildingNumber,
        street,
        city,
        province,
        postalCode
    ),
    FOREIGN KEY (province) REFERENCES PROVINCE(id)
);
-- User
DROP TABLE IF EXISTS PROFILE CASCADE;
CREATE TABLE PROFILE(
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY UNIQUE NOT NULL,
    firstName VARCHAR(255) NOT NULL,
    middleName VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    DOB DATE NOT NULL
);
-- EMPLOYEE
DROP TABLE IF EXISTS EMPLOYEE CASCADE;
CREATE TABLE EMPLOYEE(
    role BIGINT NOT NULL,
    tyep BIGINT NOT NULL,
    salary BIGINT NOT NULL,
    SSN BIGINT NOT NULL PRIMARY KEY -- FOREIGN KEY(branchId) REFERENCES BRANCH(id),
    -- FOREIGN KEY(managerID) REFERENCES (id)
) INHERITS (PROFILE);
-- PROCEDURE
DROP TABLE IF EXISTS PROCEDURE CASCADE;
CREATE TABLE PROCEDURE (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY UNIQUE NOT NULL,
    appointment_id BIGINT NOT NULL,
    procedure_code BIGINT NOT NULL,
    invoice_id BIGINT NOT NULL,
    description VARCHAR(255),
    tooth CHAR,
    procedure_count INT CHECK(procedure_count >= 0)
);
-- -- TREATMENT
DROP TABLE IF EXISTS TREATMENT CASCADE;
CREATE TABLE TREATMENT (
    medication VARCHAR(255) PRIMARY KEY,
    procedure_id INT NOT NULL,
    teeth CHAR,
    --?
    symptoms VARCHAR(255),
    comments VARCHAR(255)
);
-- APPOINTMENT_TYPE
DROP TABLE IF EXISTS APPOINTMENT_TYPE CASCADE;
CREATE TABLE APPOINTMENT_TYPE (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY UNIQUE NOT NULL,
    type VARCHAR(255) UNIQUE NOT NULL
);
-- APPOINTMENT_STATUS
DROP TABLE IF EXISTS APPOINTMENT_STATUS CASCADE;
CREATE TABLE APPOINTMENT_STATUS (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY UNIQUE NOT NULL,
    status VARCHAR(255) UNIQUE NOT NULL
);
-- APPOINTMENT
DROP TABLE IF EXISTS APPOINTMENT CASCADE;
CREATE TABLE APPOINTMENT (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY UNIQUE NOT NULL,
    branch_id INT NOT NULL,
    employee_id INT NOT NULL,
    patient_id INT NOT NULL,
    start_time TIMESTAMP,
    end_time TIMESTAMP,
    type INT NOT NULL,
    status INT NOT NULL,
    room_number VARCHAR
);