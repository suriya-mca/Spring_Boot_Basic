CREATE TABLE dummy_table (
    id BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    unique (name)
);