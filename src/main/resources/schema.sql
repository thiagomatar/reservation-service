DROP TABLE IF EXISTS reservation;

CREATE TABLE reservation(
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    description VARCHAR(200) NOT NULL,
    reservation_date DATE NOT NULL,
    price DOUBLE NOT NULL,
    status VARCHAR(50) NOT NULL
);