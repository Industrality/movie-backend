CREATE TABLE movie
(
    id          BIGSERIAL NOT NULL
        CONSTRAINT pk_movie PRIMARY KEY,
    title       VARCHAR,
    image_url   VARCHAR,
    description VARCHAR
)
