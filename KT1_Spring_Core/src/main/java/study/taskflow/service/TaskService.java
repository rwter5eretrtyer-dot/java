package study.taskflow.service;

import study.taskflow.model.*;
import java.util.*;
public interface TaskService {
 List<Task> all(String status,String priority);
 Optional<Task> findById(Long id);
 Task create(Task task);
 Optional<Task> update(Long id,Task task);
 Optional<Task> updateStatus(Long id,Status status);
 void delete(Long id);
 Map<String,Long> stats();String statsSession();
}
