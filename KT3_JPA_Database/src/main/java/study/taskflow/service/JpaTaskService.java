package study.taskflow.service;

import study.taskflow.model.*;
import study.taskflow.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
@Service @Transactional
public class JpaTaskService implements TaskService {
 private final TaskRepository repository;
 public JpaTaskService(TaskRepository repository){this.repository=repository;}
 @Override @Transactional(readOnly=true)public List<Task> all(String status,String priority){
  if(status!=null&&priority!=null)return repository.findByStatusAndPriority(Status.valueOf(status),Priority.valueOf(priority));
  if(status!=null)return repository.findByStatus(Status.valueOf(status));
  if(priority!=null)return repository.findByPriority(Priority.valueOf(priority));
  return repository.findAll();
 }
 @Override @Transactional(readOnly=true)public Optional<Task> findById(Long id){return repository.findById(id);}
 @Override public Task create(Task task){
  if(task.getTitle()==null||task.getTitle().isBlank())throw new IllegalArgumentException("Название обязательно");
  task.setId(null);task.setStatus(Status.NEW);if(task.getPriority()==null)task.setPriority(Priority.MEDIUM);
  return repository.save(task);
 }
 @Override public Optional<Task> update(Long id,Task incoming){return repository.findById(id).map(t->{
  if(incoming.getTitle()==null||incoming.getTitle().isBlank())throw new IllegalArgumentException("Название обязательно");
  t.setTitle(incoming.getTitle());t.setDescription(incoming.getDescription());
  t.setPriority(incoming.getPriority()==null?Priority.MEDIUM:incoming.getPriority());return repository.save(t);
 });}
 @Override public Optional<Task> updateStatus(Long id,Status status){return repository.findById(id).map(t->{t.setStatus(status);return repository.save(t);});}
 @Override public void delete(Long id){repository.deleteById(id);}
 @Override @Transactional(readOnly=true)public Map<String,Long> stats(){Map<String,Long> map=new LinkedHashMap<>();
  for(Status status:Status.values())map.put(status.name(),repository.countByStatus(status));return map;
 }
 @Override public String statsSession(){return UUID.randomUUID().toString();}
}
