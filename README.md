### How to run ###
 * Open terminal
 * Change directory to the root 
 * mvn spring-boot:run

### Generating SQL tables ###

CREATE TABLE user (
	id SERIAL PRIMARY KEY,
    user_name TEXT,
	account_name TEXT
);

CREATE TABLE event (
	id SERIAL PRIMARY KEY,
    location TEXT,
    description TEXT,
    start_at DATETIME,
    completed boolean,
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES user (id)
);
