CREATE TABLE hibernate_sequence (next_val BIGINT);
CREATE TABLE user (id BIGINT NOT NULL,name VARCHAR(255),PRIMARY KEY (id));
INSERT INTO hibernate_sequence (next_val) VALUES (1);
