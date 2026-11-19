package study.taskflow.config;

import study.taskflow.repository.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import java.time.Clock;
@Configuration public class AppConfig {
 @Bean public Clock taskClock(){return Clock.systemDefaultZone();}
 @Bean public String priorityRepositoryInfo(@Qualifier("priorityTaskRepository") TaskRepository repository){
  System.out.println("@Qualifier явный выбор: "+repository.getClass().getSimpleName());return repository.getClass().getSimpleName();
 }
}
