package study.taskflow.repository;

import study.taskflow.model.CourseUser;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CourseUserRepository extends JpaRepository<CourseUser,Long>{}
