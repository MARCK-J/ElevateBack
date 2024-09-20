INSERT INTO Users (first_name, last_name, email, password, role, Verification, date_join) VALUES
('Juan', 'Pérez', 'juan.perez@example.com', 'hashedpassword1', 2, FALSE, '2024-09-20'),
('Ana', 'Gómez', 'ana.gomez@example.com', 'hashedpassword2', 2, FALSE, '2024-09-20'),
('Carlos', 'López', 'carlos.lopez@example.com', 'hashedpassword3', 2, FALSE, '2024-09-20'),
('María', 'Ramírez', 'maria.ramirez@example.com', 'hashedpassword4', 2, FALSE, '2024-09-20'),
('Jorge', 'Fernández', 'jorge.fernandez@example.com', 'hashedpassword5', 2, FALSE, '2024-09-20'),
('Lucía', 'Martínez', 'lucia.martinez@example.com', 'hashedpassword6', 2, FALSE, '2024-09-20');

INSERT INTO Teacher (user_id, enrollment_date) VALUES
(1, '2024-09-20'),
(2, '2024-09-20'),
(3, '2024-09-20'),
(4, '2024-09-20'),
(5, '2024-09-20'),
(6, '2024-09-20');

INSERT INTO Category_course (name_category) VALUES
('Programacion'),
('Matematicas'),
('Fisica'),
('Quimica'),
('Historia');

-- Para la categoría Programacion (Category_course_id = 1)
INSERT INTO Courses (title, description, available, Teacher_user_id, Category_course_id) VALUES
('Curso JavaScript', 'De cero a experto', TRUE, 1, 1),
('Features', '14 Ejemplos', TRUE, 2, 1),
('Pricing', '5 Ejemplos', TRUE, 3, 1);

-- Para la categoría Matematicas (Category_course_id = 2)
INSERT INTO Courses (title, description, available, Teacher_user_id, Category_course_id) VALUES
('Navbars', '4 Ejemplos', TRUE, 4, 2),
('Nav Tabs', '2 Nav Tabs', TRUE, 5, 2),
('Pagination', '5 Ejemplos', TRUE, 6, 2);

-- Para la categoría Fisica (Category_course_id = 3)
INSERT INTO Courses (title, description, available, Teacher_user_id, Category_course_id) VALUES
('Newsletters', '6 Ejemplos', TRUE, 1, 3),
('Contact Sections', '8 Ejemplos', TRUE, 2, 3),
('Forms', '3 Ejemplos', TRUE, 3, 3);

-- Para la categoría Quimica (Category_course_id = 4)
INSERT INTO Courses (title, description, available, Teacher_user_id, Category_course_id) VALUES
('Alerts', '4 Ejemplos', TRUE, 4, 4),
('Notifications', '3 Ejemplos', TRUE, 5, 4),
('Tooltips & Popovers', '2 Ejemplos', TRUE, 6, 4);

-- Para la categoría Historia (Category_course_id = 5)
INSERT INTO Courses (title, description, available, Teacher_user_id, Category_course_id) VALUES
('Buttons', '6 Ejemplos', TRUE, 1, 5),
('Avatars', '2 Ejemplos', TRUE, 2, 5),
('Dropdowns', '2 Ejemplos', TRUE, 3, 5);