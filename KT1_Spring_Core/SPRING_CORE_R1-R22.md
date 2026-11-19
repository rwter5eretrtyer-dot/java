# Проверка требований R1–R22

- R1–R3: `service/TaskServiceImpl`, `repository/*` (`@Component`), `config/AppConfig` (`@Bean`).
- R4–R6: `InMemoryTaskRepository`, `PriorityTaskRepository`, `@Primary`, `@Qualifier`.
- R7–R9: `@PostConstruct`, `@PreDestroy` в сервисе, `@PostConstruct` у `AppProperties`.
- R10–R12: профили dev/prod, сортировка в `PriorityTaskRepository`.
- R13–R15: `TaskStatsService` со scope prototype, `ObjectProvider`, два UUID.
- R16–R19: application.yml, AppProperties, лимит и приоритет по умолчанию.
- R20–R22: ApplicationContext, getBean, список бинов в `ConsoleScenario`.

В проекте профиль `dev` содержит оба репозитория, чтобы показать смысл `@Primary` и `@Qualifier`. В `prod` остаётся только приоритетный репозиторий.
