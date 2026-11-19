SELECT * FROM tasks ORDER BY id DESC;
SELECT * FROM tasks WHERE status = 'NEW';
SELECT * FROM tasks WHERE priority = 'HIGH';
SELECT status,COUNT(*) FROM tasks GROUP BY status;
SELECT t.id,t.title,u.email FROM tasks t LEFT JOIN course_users u ON t.owner_id=u.id;
SELECT t.title,g.name FROM task_tags l JOIN tasks t ON t.id=l.task_id JOIN tags g ON g.id=l.tag_id;
