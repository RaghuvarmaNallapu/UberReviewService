CREATE TABLE IF NOT EXISTS Booking(
      id BIGINT AUTO_INCREMENT NOT NULL,
      created_at datetime NOT NULL,
      updated_at datetime NOT NULL,
      bookingstatus ENUM('ASSIGNING_DRIVER','CAB_ARRIVED','CANCELLED','COMPLETED','IN_RIDE','SCHEDULED') NULL,
      end_date datetime NULL,
      start_date datetime NULL,
      total_distance BIGINT NULL,
      driver_id      BIGINT NULL,
      passenger_id   BIGINT NULL,
      CONSTRAINT pk_booking PRIMARY(id)
);


CREATE TABLE IF NOT EXISTS booking_review(
       id BIGINT AUTO_INCREMENT NOT NULL,
       created_at datetime NOT NULL,
       updated_at datetime NOT NULL,
       content VARCHAR(255) NOT NULL,
       rating DOUBLE NULL,
       CONSTRAINT pk_booking_review PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS driver(
        id BIGINT AUTO_INCREMENT NOT NULL,
        created_at datetime NOT NULL,
        updated_at datetime NOT NULL,
        license_number VARCHAR(255),
        name  VARCHAR(255),
        phone_number  VARCHAR(255),
        CONSTRAINT pk_driver PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS passenger(
       id BIGINT AUTO_INCREMENT NOT NULL,
       created_at datetime NOT NULL,
       updated_at datetime NOT NULL,
       name  VARCHAR(255),
);


CREATE TABLE passenger_review
(
    id                       BIGINT       NOT NULL,
    passenger_review_content VARCHAR(255) NOT NULL,
    passenger_rating         VARCHAR(255) NOT NULL,
    CONSTRAINT pk_passengerreview PRIMARY KEY (id)
);

ALTER TABLE driver
    ADD CONSTRAINT uc_driver_license_number UNIQUE (license_number);


ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_DRIVER FOREIGN KEY (driver_id) REFERENCES driver (id);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_PASSENGER FOREIGN KEY (passenger_id) REFERENCES passenger (id);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_REVIEW FOREIGN KEY (review_id) REFERENCES booking_review (id);

ALTER TABLE passenger_review
    ADD CONSTRAINT FK_PASSENGERREVIEW_ON_ID FOREIGN KEY (id) REFERENCES booking_review (id);