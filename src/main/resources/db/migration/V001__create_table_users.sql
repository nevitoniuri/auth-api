CREATE TABLE users
(
    id         BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    "role"     VARCHAR(20) NOT NULL,
    email      VARCHAR(255) NOT NULL UNIQUE,
    "password" VARCHAR(255) NOT NULL
);