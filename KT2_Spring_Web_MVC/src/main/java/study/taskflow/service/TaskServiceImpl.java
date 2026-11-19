package study.taskflow.service;

import study.taskflow.config.AppProperties;
import study.taskflow.model.*;
import study.taskflow.repository.TaskRepository;
import jakarta.annotation.*;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;
@Service
public class TaskServiceImpl implements TaskService {
 private final TaskRepository repository;private final AppProperties settings;private final ObjectProvider<TaskStatsService> snapshots;
 public TaskServiceImpl(TaskRepository repository,AppProperties settings,ObjectProvider<TaskStatsService> snapshots){
  this.repository=repository;this.settings=settings;this.snapshots=snapshots;}
 @PostConstruct public void start(){System.out.println("TaskService инициализирован");}
 @PreDestroy public void stop(){System.out.println("Завершение работы. Задач в хранилище: "+repository.findAll().size());}
 @Override public List<Task> all(String status,String priority){return repository.findAll().stream()
  .filter(t->status==null||t.getStatus()==Status.valueOf(status))
  .filter(t->priority==null||t.getPriority()==Priority.valueOf(priority)).toList();}
 @Override public Optional<Task> findById(Long id){return repository.findById(id);}
 @Override public Task create(Task task){
  if(task.getTitle()==null||task.getTitle().isBlank())throw new IllegalArgumentException("Название задачи не может быть пустым");
  if(repository.findAll().size()>=settings.getMaxTasks())throw new IllegalArgumentException("Превышен лимит: "+settings.getMaxTasks());
  if(task.getPriority()==null)task.setPriority(settings.getDefaultPriority());task.setStatus(Status.NEW);return repository.save(task);
 }
 @Override public Optional<Task> update(Long id,Task incoming){
  return repository.findById(id).map(task->{
   if(incoming.getTitle()==null||incoming.getTitle().isBlank())throw new IllegalArgumentException("Пустой title");
   task.setTitle(incoming.getTitle());task.setDescription(incoming.getDescription());
   task.setPriority(incoming.getPriority()==null?settings.getDefaultPriority():incoming.getPriority());return repository.save(task);
  });
 }
 @Override public Optional<Task> updateStatus(Long id,Status status){return repository.updateStatus(id,status);}
 @Override public void delete(Long id){repository.delete(id);}
 @Override public Map<String,Long> stats(){Map<String,Long> stats=new LinkedHashMap<>();
  for(Status s:Status.values())stats.put(s.name(),repository.findAll().stream().filter(t->t.getStatus()==s).count());return stats;}
 @Override public String statsSession(){return snapshots.getObject().getId();}
}
