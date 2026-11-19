package study.taskflow.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.*;
@Entity @Table(name="tasks")
public class Task {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)private Long id;
 @NotBlank @Column(nullable=false)private String title;
 @Column(length=4000)private String description;
 @Enumerated(EnumType.STRING)private Priority priority=Priority.MEDIUM;
 @Enumerated(EnumType.STRING)private Status status=Status.NEW;
 @Column(name="created_at")private LocalDateTime createdAt=LocalDateTime.now();
 @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="owner_id") @JsonIgnore private CourseUser owner;
 @ManyToMany @JoinTable(name="task_tags",joinColumns=@JoinColumn(name="task_id"),inverseJoinColumns=@JoinColumn(name="tag_id"))
 @JsonIgnore private Set<Tag> tags=new HashSet<>();
 public Task(){}
 public Task(String title,String description,Priority priority){this.title=title;this.description=description;this.priority=priority;}
 public Long getId(){return id;}public void setId(Long v){id=v;}
 public String getTitle(){return title;}public void setTitle(String v){title=v;}
 public String getDescription(){return description;}public void setDescription(String v){description=v;}
 public Priority getPriority(){return priority;}public void setPriority(Priority v){priority=v;}
 public Status getStatus(){return status;}public void setStatus(Status v){status=v;}
 public LocalDateTime getCreatedAt(){return createdAt;}
 public CourseUser getOwner(){return owner;}public void setOwner(CourseUser v){owner=v;}
 public Set<Tag> getTags(){return tags;}
}
