CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START 1;

CREATE TABLE IF NOT EXISTS movie (
	id BIGSERIAL NOT NULL,
    title VARCHAR(100) NOT NULL,
    description TEXT NULL,
    rating FLOAT DEFAULT 0.0,
    image VARCHAR(255),
    created_at timestamp NULL,
    updated_at timestamp NULL,
    CONSTRAINT movie_pk PRIMARY KEY (id)
);

