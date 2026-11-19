package study.taskflow.controller;

import study.taskflow.repository.TaskRepository;
import study.taskflow.model.Task;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/queries")
public class AdvancedQueryController {
 private final TaskRepository repo;
 public AdvancedQueryController(TaskRepository repo){this.repo=repo;}
 @GetMapping("/search") public List<Task> search(@RequestParam String keyword){return repo.searchByKeyword(keyword);}
 @GetMapping("/paged") public Page<Task> paged(@RequestParam(defaultValue="0")int page,
  @RequestParam(defaultValue="10")int size,@RequestParam(defaultValue="id")String sort){
  if(!java.util.Set.of("id","title","priority","status","createdAt").contains(sort))sort="id";
  return repo.findAll(PageRequest.of(Math.max(page,0),Math.min(Math.max(size,1),100),Sort.by(sort)));
 }
}
