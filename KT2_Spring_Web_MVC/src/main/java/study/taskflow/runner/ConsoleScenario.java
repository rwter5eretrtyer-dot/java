package study.taskflow.runner;

import study.taskflow.config.AppProperties;
import study.taskflow.model.*;
import study.taskflow.repository.TaskRepository;
import study.taskflow.service.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component @Profile("console")
public class ConsoleScenario implements CommandLineRunner {
 private final TaskService service;private final AppProperties config;private final ApplicationContext context;
 public ConsoleScenario(TaskService service,AppProperties config,ApplicationContext context){this.service=service;this.config=config;this.context=context;}
 @Override public void run(String... args){
  System.out.printf("Добро пожаловать в %s! Лимит: %s. Приоритет по умолчанию: %s%n",config.getName(),config.getMaxTasks(),config.getDefaultPriority());
  service.create(new Task("Навести порядок","",Priority.LOW));
  service.create(new Task("Повторить MVC","",Priority.MEDIUM));
  service.create(new Task("Подготовить пересдачу","",Priority.HIGH));
  service.all(null,null).forEach(t->System.out.printf("#%d %s %s %s%n",t.getId(),t.getTitle(),t.getPriority(),t.getStatus()));
  try{service.create(new Task(" ","",null));}catch(IllegalArgumentException e){System.out.println("Проверка: "+e.getMessage());}
  try{for(int i=0;i<config.getMaxTasks();i++)service.create(new Task("Дополнительная "+i,"",null));}catch(IllegalArgumentException e){System.out.println("Лимит: "+e.getMessage());}
  service.updateStatus(1L,Status.IN_PROGRESS);service.updateStatus(2L,Status.DONE);
  System.out.println("Готовые: "+service.all("DONE",null).size());System.out.println("С высоким приоритетом: "+service.all(null,"HIGH").size());
  System.out.println("UUID #1: "+service.statsSession());System.out.println("UUID #2: "+service.statsSession());
  System.out.println("Выбранный бин: "+context.getBean(TaskRepository.class).getClass().getSimpleName());
  String[] names=context.getBeanDefinitionNames();System.out.println("Всего бинов: "+names.length);
  Arrays.stream(names).filter(n->n.toLowerCase().contains("task")).sorted().forEach(n->System.out.println("Bean: "+n));
 }
}
