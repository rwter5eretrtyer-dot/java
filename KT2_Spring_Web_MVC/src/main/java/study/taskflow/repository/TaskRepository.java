package study.taskflow.repository;

import study.taskflow.model.*;
import java.util.*;
public interface TaskRepository {
 List<Task> findAll();Optional<Task> findById(Long id);Task save(Task task);void delete(Long id);
 Optional<Task> updateStatus(Long id,Status status);
}
