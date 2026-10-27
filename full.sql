BEGIN;

DROP TABLE IF EXISTS marks CASCADE;
CREATE TABLE marks (id bigserial PRIMARY KEY, mark int);
INSERT INTO marks (mark) VALUES
('1'),('2'),('3'),('4'),('5');

DROP TABLE IF EXISTS students CASCADE;
CREATE TABLE students (id bigserial PRIMARY KEY, name VARCHAR(255), mark int);
INSERT INTO students (name, mark) VALUES
('Alexander', 10);
COMMIT;

