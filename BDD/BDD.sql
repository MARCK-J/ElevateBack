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
    duration varchar(25)  NOT NULL,
    rating DECIMAL(2, 1) DEFAULT 0,
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
    Courses_course_id int  NOT NULL,
    Completed boolean  NOT NULL
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

-- Table: Quizzes (quizzes o evaluaciones)
CREATE TABLE Quizzes (
    quiz_id SERIAL PRIMARY KEY,
    title varchar(255) NOT NULL,
    description text NOT NULL,
    due_date date NOT NULL,
    lessons_id int NOT NULL,
    course_id int NOT NULL,
    CONSTRAINT Quizzes_Lessons_fk FOREIGN KEY (lessons_id)
        REFERENCES Lessons (lessons_id),
    CONSTRAINT Quizzes_Courses_fk FOREIGN KEY (course_id)
        REFERENCES Courses (course_id)
);

-- Table: Questions (preguntas del quiz)
CREATE TABLE Questions (
    question_id SERIAL PRIMARY KEY,
    quiz_id int NOT NULL,
    content text NOT NULL,
    question_type varchar(50) NOT NULL, -- tipo de pregunta (e.g. multiple choice, true/false)
    CONSTRAINT Questions_Quizzes_fk FOREIGN KEY (quiz_id)
        REFERENCES Quizzes (quiz_id)
);

-- Table: Options (opciones de preguntas, si es multiple choice)
CREATE TABLE Options (
    option_id SERIAL PRIMARY KEY,
    question_id int NOT NULL,
    content text NOT NULL,
    is_correct boolean NOT NULL, -- si es la respuesta correcta o no
    CONSTRAINT Options_Questions_fk FOREIGN KEY (question_id)
        REFERENCES Questions (question_id)
);
-- Table: Results (resultados de quizzes)
CREATE TABLE Results (
    result_id SERIAL PRIMARY KEY,
    score int NOT NULL,
    submission_date date NOT NULL,
    quiz_id int NOT NULL,
    Student_user_id int NOT NULL,
    CONSTRAINT Results_Quizzes_fk FOREIGN KEY (quiz_id)
        REFERENCES Quizzes (quiz_id),
    CONSTRAINT Results_Student_fk FOREIGN KEY (Student_user_id)
        REFERENCES Student (user_id)
);

-- Table: Certification
CREATE TABLE Certification (
    certification_id SERIAL PRIMARY KEY,
    student_user_id INT NOT NULL,
    course_id INT NOT NULL,
    issue_date TIMESTAMP NOT NULL,
    CONSTRAINT Certification_Student_fk FOREIGN KEY (student_user_id)
        REFERENCES Student (user_id),
    CONSTRAINT Certification_Courses_fk FOREIGN KEY (course_id)
        REFERENCES Courses (course_id)
);

-- Table: favorites
CREATE TABLE favorites (
    favorite_id SERIAL PRIMARY KEY,
    student_user_id BIGINT NOT NULL,
    course_id BIGINT NOT NULL,
    FOREIGN KEY (student_user_id) REFERENCES student(user_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
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
