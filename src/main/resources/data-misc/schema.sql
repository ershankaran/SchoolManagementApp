CREATE SEQUENCE IF NOT EXISTS teacher_seq;

CREATE TABLE IF NOT EXISTS teacher (

teacher_id BIGINT NOT NULL DEFAULT nextval('teacher_seq') PRIMARY KEY,
teacher_email VARCHAR(100) NOT NULL,
teacher_name VARCHAR(100) NOT NULL

);

CREATE SEQUENCE IF NOT EXISTS classroom_seq;

CREATE TABLE IF NOT EXISTS classroom (

classroom_id BIGINT NOT NULL DEFAULT nextval('classroom_seq') PRIMARY KEY,
classroom_email VARCHAR(100) NOT NULL,
classroom_name VARCHAR(100) NOT NULL

);

CREATE SEQUENCE IF NOT EXISTS student_seq;

CREATE TABLE IF NOT EXISTS student (

student_id BIGINT NOT NULL DEFAULT nextval('student_seq') PRIMARY KEY,
student_email VARCHAR(100) NOT NULL,
student_name VARCHAR(100) NOT NULL,
classroom_id bigint,    
    CONSTRAINT student_classroom_id_fkey FOREIGN KEY (classroom_id)
        REFERENCES public.classroom (classroom_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION

);




CREATE TABLE IF NOT EXISTS classroom_teacher (

teacher_id BIGINT REFERENCES teacher, 
classroom_id BIGINT REFERENCES classroom

);