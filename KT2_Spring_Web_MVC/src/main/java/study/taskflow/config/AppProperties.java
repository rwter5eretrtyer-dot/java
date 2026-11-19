package study.taskflow.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import study.taskflow.model.Priority;
@Component
public class AppProperties {
 @Value("${app.name}") private String name;
 @Value("${app.max-tasks}") private int maxTasks;
 @Value("${app.default-priority}") private Priority defaultPriority;
 @PostConstruct public void ready(){System.out.println("Настройки: "+name+", максимум "+maxTasks+", приоритет "+defaultPriority);}
 public String getName(){return name;}public int getMaxTasks(){return maxTasks;}public Priority getDefaultPriority(){return defaultPriority;}
}
