CREATE TABLE IF NOT EXISTS todo(
    id SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    category VARCHAR NOT NULL,
    complete BOOLEAN
);