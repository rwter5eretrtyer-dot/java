package study.taskflow.model;

import jakarta.validation.constraints.NotBlank;
public class Task {
 private Long id;
 @NotBlank private String title;
 private String description;
 private Priority priority;
 private Status status=Status.NEW;
 public Task(){}
 public Task(String title,String description,Priority priority){this.title=title;this.description=description;this.priority=priority;}
 public Long getId(){return id;} public void setId(Long v){id=v;}
 public String getTitle(){return title;}public void setTitle(String v){title=v;}
 public String getDescription(){return description;}public void setDescription(String v){description=v;}
 public Priority getPriority(){return priority;}public void setPriority(Priority v){priority=v;}
 public Status getStatus(){return status;}public void setStatus(Status v){status=v;}
}
