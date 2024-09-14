-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2024-09-14 14:39:33.148

-- tables
-- Table: Assessments
CREATE TABLE Assessments (
    assessments_id int  NOT NULL,
    title varchar(255)  NOT NULL,
    description text  NOT NULL,
    grade int  NOT NULL,
    due_date date  NOT NULL,
    CONSTRAINT Assessments_pk PRIMARY KEY (assessments_id)
);

-- Table: Category_course
CREATE TABLE Category_course (
    id int  NOT NULL,
    name_category varchar(50)  NOT NULL,
    CONSTRAINT Category_course_pk PRIMARY KEY (id)
);

-- Table: Courses
CREATE TABLE Courses (
    course_id int  NOT NULL,
    title varchar(255)  NOT NULL,
    description text  NOT NULL,
    available boolean  NOT NULL,
    Teacher_user_id int  NOT NULL,
    Category_course_id int  NOT NULL,
    CONSTRAINT Courses_pk PRIMARY KEY (course_id)
);

-- Table: Enrollments
CREATE TABLE Enrollments (
    enrollment_id int  NOT NULL,
    enrollment_date timestamp  NOT NULL,
    Student_user_id int  NOT NULL,
    Courses_course_id int  NOT NULL,
    CONSTRAINT Enrollments_pk PRIMARY KEY (enrollment_id)
);

-- Table: Lessons
CREATE TABLE Lessons (
    lessons_id int  NOT NULL,
    course_id int  NOT NULL,
    title varchar(255)  NOT NULL,
    content text  NOT NULL,
    archive xml  NOT NULL,
    video text  NOT NULL,
    "order" int  NOT NULL,
    complete boolean  NOT NULL,
    CONSTRAINT Lessons_pk PRIMARY KEY (lessons_id)
);

-- Table: Messages
CREATE TABLE Messages (
    message_id int  NOT NULL,
    content text  NOT NULL,
    time timestamp  NOT NULL,
    CONSTRAINT Messages_pk PRIMARY KEY (message_id)
);

-- Table: Results
CREATE TABLE Results (
    result_id int  NOT NULL,
    score int  NOT NULL,
    submission_date date  NOT NULL,
    CONSTRAINT Results_pk PRIMARY KEY (result_id)
);

-- Table: Student
CREATE TABLE Student (
    user_id int  NOT NULL,
    enrollment_date date  NOT NULL,
    CONSTRAINT Student_pk PRIMARY KEY (user_id)
);

-- Table: Teacher
CREATE TABLE Teacher (
    user_id int  NOT NULL,
    enrollment_date date  NOT NULL,
    CONSTRAINT Teacher_pk PRIMARY KEY (user_id)
);

-- Table: Users
CREATE TABLE Users (
    user_id int  NOT NULL,
    first_name varchar(50)  NOT NULL,
    last_name varchar(50)  NOT NULL,
    email varchar(100)  NOT NULL,
    password varchar(100)  NOT NULL,
    role int  NOT NULL,
    date_join date  NOT NULL,
    CONSTRAINT Users_pk PRIMARY KEY (user_id)
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

