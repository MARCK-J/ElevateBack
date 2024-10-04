-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2024-09-14 14:39:33.148

-- tables
-- Table: Assessments
CREATE TABLE Assessments (
    assessments_id SERIAL PRIMARY KEY,
    title varchar(255)  NOT NULL,
    description text  NOT NULL,
    grade int  NOT NULL,
    due_date date  NOT NULL
);

-- Tabla Category_course con ID auto-generado
CREATE TABLE Category_course (
    id SERIAL PRIMARY KEY,
    name_category varchar(50) NOT NULL
);

-- Table: Courses
CREATE TABLE Courses (
    course_id SERIAL PRIMARY KEY,
    title varchar(255)  NOT NULL,
    image text  NOT NULL,
    description text  NOT NULL,
    abilities text NOT NULL,
    available boolean  NOT NULL,
    Teacher_user_id int  NOT NULL,
    Category_course_id int  NOT NULL
);

-- Table: Enrollments
CREATE TABLE Enrollments (
    enrollment_id SERIAL PRIMARY KEY,
    enrollment_date timestamp  NOT NULL,
    Student_user_id int  NOT NULL,
    Courses_course_id int  NOT NULL
);

-- Table: Lessons
CREATE TABLE Lessons (
    lessons_id SERIAL  NOT NULL,
    course_id int  NOT NULL,
    title varchar(50)  NOT NULL,
    description varchar(255)  NOT NULL,
    duration varchar(25)  NOT NULL,
    content text  NOT NULL,
    video text  NOT NULL,
    "order" int  NOT NULL,
    complete boolean  NOT NULL,
    CONSTRAINT Lessons_pk PRIMARY KEY (lessons_id)
);

-- Table: Messages
CREATE TABLE Messages (
    message_id SERIAL PRIMARY KEY,
    content text  NOT NULL,
    time timestamp  NOT NULL
);

-- Table: Results
CREATE TABLE Results (
    result_id SERIAL PRIMARY KEY,
    score int  NOT NULL,
    submission_date date  NOT NULL
);

-- Table: Student
CREATE TABLE Student (
    user_id SERIAL PRIMARY KEY,
    enrollment_date date  NOT NULL
);

-- Table: Teacher
CREATE TABLE Teacher (
    user_id SERIAL PRIMARY KEY,
    enrollment_date date  NOT NULL
);

-- Table: Users
CREATE TABLE Users (
    user_id SERIAL PRIMARY KEY,
    first_name varchar(50)  NOT NULL,
    last_name varchar(50)  NOT NULL,
    email varchar(100)  NOT NULL,
    username varchar(25)  NOT NULL,
    password varchar(100)  NOT NULL,
    role int  NOT NULL,
    verification boolean  NOT NULL,
    activation boolean NOT NULL,
    date_join date  NOT NULL
);

-- foreign keys
-- Reference: Courses_Category_course (table: Courses)
ALTER TABLE Courses ADD CONSTRAINT Courses_Category_course
    FOREIGN KEY (Category_course_id)
    REFERENCES Category_course (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Courses_Teacher (table: Courses)
ALTER TABLE Courses ADD CONSTRAINT Courses_Teacher
    FOREIGN KEY (Teacher_user_id)
    REFERENCES Teacher (user_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Enrollments_Courses (table: Enrollments)
ALTER TABLE Enrollments ADD CONSTRAINT Enrollments_Courses
    FOREIGN KEY (Courses_course_id)
    REFERENCES Courses (course_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Enrollments_Student (table: Enrollments)
ALTER TABLE Enrollments ADD CONSTRAINT Enrollments_Student
    FOREIGN KEY (Student_user_id)
    REFERENCES Student (user_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Lessons_Courses (table: Lessons)
ALTER TABLE Lessons ADD CONSTRAINT Lessons_Courses
    FOREIGN KEY (course_id)
    REFERENCES Courses (course_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Student_Users (table: Student)
ALTER TABLE Student ADD CONSTRAINT Student_Users
    FOREIGN KEY (user_id)
    REFERENCES Users (user_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Teacher_Users (table: Teacher)
ALTER TABLE Teacher ADD CONSTRAINT Teacher_Users
    FOREIGN KEY (user_id)
    REFERENCES Users (user_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

SELECT setval('users_user_id_seq', (SELECT MAX(user_id) FROM users));


