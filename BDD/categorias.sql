delete from category_course.

ALTER SEQUENCE category_course_id_seq RESTART WITH 1;

INSERT INTO Category_course (name_category) VALUES
('Programacion'),
('Matematicas'),
('Fisica'),
('Quimica'),
('Historia');

select * from Category_course