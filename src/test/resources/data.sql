-- INSERT Students			
insert into student ( student_id, student_name, student_email) values(nextval('student_seq'), 'John Warton', 'warton@sma.org');
insert into student ( student_id, student_name, student_email) values(nextval('student_seq'), 'Mike Lanister', 'lanister@sma.org');
insert into student ( student_id, student_name, student_email) values(nextval('student_seq'), 'Steve Reeves', 'Reeves@sma.org');
insert into student ( student_id, student_name, student_email) values(nextval('student_seq'), 'Ronald Connor', 'connor@sma.org');
insert into student ( student_id, student_name, student_email) values(nextval('student_seq'), 'Jim Salvator', 'Sal@sma.org');
insert into student ( student_id, student_name, student_email) values(nextval('student_seq'), 'Peter Henley', 'henley@sma.org');
insert into student ( student_id, student_name, student_email) values(nextval('student_seq'), 'Richard Carson', 'carson@sma.org');
insert into student ( student_id, student_name, student_email) values(nextval('student_seq'), 'Honor Miles', 'miles@sma.org');
insert into student ( student_id, student_name, student_email) values(nextval('student_seq'), 'Tony Roggers', 'roggers@sma.org');

insert into teacher ( teacher_id, teacher_name, teacher_email) values(nextval('teacher_seq'), 'John Reese', 'jreese@sma.org');
insert into teacher ( teacher_id, teacher_name, teacher_email) values(nextval('teacher_seq'),'Harold Wren', 'hwren@sma.org');
insert into teacher ( teacher_id, teacher_name, teacher_email) values(nextval('teacher_seq'), 'Samantha Groves', 'sgroves@sma.org');
insert into teacher ( teacher_id, teacher_name, teacher_email) values(nextval('teacher_seq'), 'Henry Mccord', 'hmccord@sma.org');
insert into teacher ( teacher_id, teacher_name, teacher_email) values(nextval('teacher_seq'),'Jim reeves', 'jreeves@sma.org');

-- INSERT classroom			
insert into classroom (classroom_id, classroom_name, classroom_email) values(nextval('classroom_seq'), 'Section III', 'sectioniii@school.org');
insert into classroom (classroom_id, classroom_name, classroom_email) values(nextval('classroom_seq'), 'Section IV', 'sectioniv@school.org');
insert into classroom (classroom_id, classroom_name, classroom_email) values(nextval('classroom_seq'), 'Section V', 'sectionv@school.org');
insert into classroom (classroom_id, classroom_name, classroom_email) values(nextval('classroom_seq'), 'Section VI', 'sectionvi@school.org');

-- INSERT classroom_teacher_RELATION (Removed duplicates from video)
insert into classroom_teacher (teacher_id, classroom_id) (select e.teacher_id, p.classroom_id from teacher e, classroom p where e.teacher_name like '%Reese' AND p.classroom_name = 'Section VI');
insert into classroom_teacher (teacher_id, classroom_id) (select e.teacher_id, p.classroom_id from teacher e, classroom p where e.teacher_name like '%Reese' AND p.classroom_name = 'Section V');
insert into classroom_teacher (teacher_id, classroom_id) (select e.teacher_id, p.classroom_id from teacher e, classroom p where e.teacher_name like '%Reese' AND p.classroom_name = 'Section IV');
insert into classroom_teacher (teacher_id, classroom_id) (select e.teacher_id, p.classroom_id from teacher e, classroom p where e.teacher_name like '%Wren' AND p.classroom_name = 'Section VI');
insert into classroom_teacher (teacher_id, classroom_id) (select e.teacher_id, p.classroom_id from teacher e, classroom p where e.teacher_name like '%Reese' AND p.classroom_name = 'Section V');
insert into classroom_teacher (teacher_id, classroom_id) (select e.teacher_id, p.classroom_id from teacher e, classroom p where e.teacher_name like '%Reese' AND p.classroom_name = 'Section III');
insert into classroom_teacher (teacher_id, classroom_id) (select e.teacher_id, p.classroom_id from teacher e, classroom p where e.teacher_name like '%Groves' AND p.classroom_name = 'Section IV');
insert into classroom_teacher (teacher_id, classroom_id) (select e.teacher_id, p.classroom_id from teacher e, classroom p where e.teacher_name like '%Groves' AND p.classroom_name = 'Section III');
													