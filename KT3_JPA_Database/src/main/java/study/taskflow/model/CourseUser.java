package study.taskflow.model;

import jakarta.persistence.*;
@Entity @Table(name="course_users")
public class CourseUser {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)private Long id;
 @Column(nullable=false,unique=true)private String email;
 protected CourseUser(){}
 public CourseUser(String email){this.email=email;}
 public Long getId(){return id;}public String getEmail(){return email;}
}
