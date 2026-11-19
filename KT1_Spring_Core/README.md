# КТ №1 — Основы Spring (TaskFlow Core)

Java 21, Spring Boot 3.3.5. Только консоль, без HTTP и базы данных.

```bash
mvn spring-boot:run
```

`ConsoleScenario` демонстрирует восемь шагов задания: конфигурацию, три задачи, ошибки, статусы, два prototype UUID, ApplicationContext, сортировку по профилю, @PreDestroy.

Для переключения на профиль `prod` в `application.yml` установите `active: prod,console`, затем запустите снова. В `dev` оба репозитория существуют, но `@Primary` выбирает in-memory; `@Qualifier` в AppConfig показывает второй репозиторий. В `prod` активен сортирующий репозиторий.

Файл `SPRING_CORE_R1-R22.md` — список требований и расположение кода. Все зависимости внедряются через конструктор.
