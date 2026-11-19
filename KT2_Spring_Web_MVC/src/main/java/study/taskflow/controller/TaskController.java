package study.taskflow.controller;

import study.taskflow.model.*;
import study.taskflow.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController @RequestMapping("/tasks")
public class TaskController {
 private final TaskService service;
 public TaskController(TaskService service){this.service=service;}
 @GetMapping public List<Task> all(@RequestParam(required=false)String status,@RequestParam(required=false)String priority){return service.all(status,priority);}
 @GetMapping("/stats") public Map<String,Long> stats(){return service.stats();}
 @GetMapping("/{id}") public ResponseEntity<Task> get(@PathVariable Long id){return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());}
 @PostMapping public ResponseEntity<Task> create(@Valid @RequestBody Task task){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(task));}
 @PutMapping("/{id}") public ResponseEntity<Task> update(@PathVariable Long id,@Valid @RequestBody Task task){
  return service.update(id,task).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
 }
 @PatchMapping("/{id}/status") public ResponseEntity<Task> status(@PathVariable Long id,@RequestBody Map<String,String> body){
  return service.updateStatus(id,Status.valueOf(body.getOrDefault("status",""))).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
 }
 @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){service.delete(id);return ResponseEntity.noContent().build();}
}
