package study.taskflow.repository;

import study.taskflow.model.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
@Component @Primary @Profile("dev")
public class InMemoryTaskRepository implements TaskRepository {
 private final Map<Long,Task> data=new LinkedHashMap<>();
 private final AtomicLong nextId=new AtomicLong(0);
 @Override public synchronized List<Task> findAll(){return new ArrayList<>(data.values());}
 @Override public synchronized Optional<Task> findById(Long id){return Optional.ofNullable(data.get(id));}
 @Override public synchronized Task save(Task task){if(task.getId()==null)task.setId(nextId.incrementAndGet());data.put(task.getId(),task);return task;}
 @Override public synchronized void delete(Long id){data.remove(id);}
 @Override public synchronized Optional<Task> updateStatus(Long id,Status s){Task t=data.get(id);if(t!=null)t.setStatus(s);return Optional.ofNullable(t);}
}
