-- insert Teachers
insert into teacher (teacher_id, teacher_name, teacher_email) values (1, 'John Reese', 'jreese@sma.org');
insert into teacher (teacher_id, teacher_name, teacher_email) values (2, 'Harold Wren', 'hwren@sma.org');
insert into teacher (teacher_id, teacher_name, teacher_email) values (3, 'Samantha Groves', 'sgroves@sma.org');
insert into teacher (teacher_id, teacher_name, teacher_email) values (4, 'Henry Mccord', 'hmccord@sma.org');
insert into teacher (teacher_id, teacher_name, teacher_email) values (5, 'Jim reeves', 'jreeves@sma.org');

-- INSERT classroom			
insert into classroom (classroom_id, classroom_name, classroom_email) values (1, 'Section III', 'sectioniii@school.org');
insert into classroom (classroom_id, classroom_name, classroom_email) values (2, 'Section IV', 'sectioniv@school.org');
insert into classroom (classroom_id, classroom_name, classroom_email) values (3, 'Section V', 'sectionv@school.org');
insert into classroom (classroom_id, classroom_name, classroom_email) values (4, 'Section VI', 'sectionvi@school.org');

-- INSERT Students			
insert into student(classroom_id,student_id, student_name, student_email) values (4,1, 'John Warton', 'warton@sma.org');
insert into student(classroom_id,student_id, student_name, student_email) values (4,2, 'Mike Lanister', 'lanister@sma.org');
insert into student(classroom_id,student_id, student_name, student_email) values (4,3, 'Steve Reeves', 'Reeves@sma.org');
insert into student(classroom_id,student_id, student_name, student_email) values (4,4, 'Ronald Connor', 'connor@sma.org');
insert into student(classroom_id,student_id, student_name, student_email) values (3,5, 'Jim Salvator', 'Sal@sma.org');
insert into student(classroom_id,student_id, student_name, student_email) values (3,6, 'Peter Henley', 'henley@sma.org');
insert into student(classroom_id,student_id, student_name, student_email) values (2,7, 'Richard Carson', 'carson@sma.org');
insert into student(classroom_id,student_id, student_name, student_email) values (2,8, 'Honor Miles', 'miles@sma.org');
insert into student(classroom_id,student_id, student_name, student_email) values (1,9, 'Tony Roggers', 'roggers@sma.org');


-- INSERT classroom_teacher_RELATION (Removed duplicates from video)
insert into classroom_teacher (teacher_id, classroom_id) values (1,1);
insert into classroom_teacher (teacher_id, classroom_id) values (1,2);
insert into classroom_teacher (teacher_id, classroom_id) values (1,3);
insert into classroom_teacher (teacher_id, classroom_id) values (2,1);
insert into classroom_teacher (teacher_id, classroom_id) values (2,2);
insert into classroom_teacher (teacher_id, classroom_id) values (3,1);
insert into classroom_teacher (teacher_id, classroom_id) values (3,3);
insert into classroom_teacher (teacher_id, classroom_id) values (3,3);
													