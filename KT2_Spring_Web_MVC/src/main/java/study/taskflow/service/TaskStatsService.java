package study.taskflow.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.UUID;
@Component @Scope("prototype")
public class TaskStatsService {
 private final String id=UUID.randomUUID().toString();
 public String getId(){return id;}
}
