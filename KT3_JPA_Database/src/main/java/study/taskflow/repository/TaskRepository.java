package study.taskflow.repository;

import study.taskflow.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.Param;
import java.util.*;
public interface TaskRepository extends JpaRepository<Task,Long> {
 List<Task> findByStatus(Status status);
 List<Task> findByPriority(Priority priority);
 List<Task> findByStatusAndPriority(Status status,Priority priority);
 List<Task> findByTitleContainingIgnoreCase(String keyword);
 long countByStatus(Status status);
 @Query("select t.status, count(t) from Task t group by t.status") List<Object[]> groupedStats();
 @Query("select t from Task t where lower(t.title) like lower(concat('%',:word,'%')) or lower(t.description) like lower(concat('%',:word,'%'))")
 List<Task> searchByKeyword(@Param("word")String word);
}
