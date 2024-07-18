-- Job 데이터 삽입
INSERT INTO job (id, title, created_at, updated_at, created_by, updated_by) VALUES (1, 'Design', NOW(), NOW(), 1, 1);
INSERT INTO job (id, title, created_at, updated_at, created_by, updated_by) VALUES (2, 'Development', NOW(), NOW(), 1, 1);
INSERT INTO job (id, title, created_at, updated_at, created_by, updated_by) VALUES (3, 'Planning', NOW(), NOW(), 1, 1);
INSERT INTO job (id, title, created_at, updated_at, created_by, updated_by) VALUES (4, 'Video Editing', NOW(), NOW(), 1, 1);

-- JobRole 데이터 삽입
INSERT INTO role (id, title, job_id, created_at, updated_at, created_by, updated_by) VALUES (1, 'Frontend', 2, NOW(), NOW(), 1, 1);
INSERT INTO role (id, title, job_id, created_at, updated_at, created_by, updated_by) VALUES (2, 'Backend', 2, NOW(), NOW(), 1, 1);
INSERT INTO role (id, title, job_id, created_at, updated_at, created_by, updated_by) VALUES (3, 'App Development', 2, NOW(), NOW(), 1, 1);
INSERT INTO role (id, title, job_id, created_at, updated_at, created_by, updated_by) VALUES (4, 'UI/UX Design', 1, NOW(), NOW(), 1, 1);
INSERT INTO role (id, title, job_id, created_at, updated_at, created_by, updated_by) VALUES (5, 'Graphic Design', 1, NOW(), NOW(), 1, 1);
INSERT INTO role (id, title, job_id, created_at, updated_at, created_by, updated_by) VALUES (6, 'Project Management', 3, NOW(), NOW(), 1, 1);
INSERT INTO role (id, title, job_id, created_at, updated_at, created_by, updated_by) VALUES (7, 'Video Editing', 4, NOW(), NOW(), 1, 1);

-- Quiz 데이터 삽입
INSERT INTO interview_question (id, question, role_id, created_at, updated_at, created_by, updated_by) VALUES (1, 'Explain the difference between HTTP GET and POST methods.', 2, NOW(), NOW(), 1, 1);
INSERT INTO interview_question (id, question, role_id, created_at, updated_at, created_by, updated_by) VALUES (2, 'What is REST API?', 2, NOW(), NOW(), 1, 1);
INSERT INTO interview_question (id, question, role_id, created_at, updated_at, created_by, updated_by) VALUES (3, 'What is the use of CSS Flexbox?', 1, NOW(), NOW(), 1, 1);
INSERT INTO interview_question (id, question, role_id, created_at, updated_at, created_by, updated_by) VALUES (4, 'Explain the concept of Object-Oriented Programming.', 3, NOW(), NOW(), 1, 1);
INSERT INTO interview_question (id, question, role_id, created_at, updated_at, created_by, updated_by) VALUES (5, 'How do you handle errors in JavaScript?', 1, NOW(), NOW(), 1, 1);
INSERT INTO interview_question (id, question, role_id, created_at, updated_at, created_by, updated_by) VALUES (6, 'Describe the Model-View-Controller (MVC) architecture.', 2, NOW(), NOW(), 1, 1);
INSERT INTO interview_question (id, question, role_id, created_at, updated_at, created_by, updated_by) VALUES (7, 'What is the importance of user research in UI/UX design?', 4, NOW(), NOW(), 1, 1);
INSERT INTO interview_question (id, question, role_id, created_at, updated_at, created_by, updated_by) VALUES (8, 'How do you optimize video quality during editing?', 7, NOW(), NOW(), 1, 1);
INSERT INTO interview_question (id, question, role_id, created_at, updated_at, created_by, updated_by) VALUES (9, 'Explain the key principles of Agile project management.', 6, NOW(), NOW(), 1, 1);
INSERT INTO interview_question (id, question, role_id, created_at, updated_at, created_by, updated_by) VALUES (10, 'What is the role of a Product Owner in a Scrum team?', 6, NOW(), NOW(), 1, 1);
INSERT INTO interview_question (id, question, role_id, created_at, updated_at, created_by, updated_by) VALUES (11, 'Describe the process of stakeholder management.', 6, NOW(), NOW(), 1, 1);
