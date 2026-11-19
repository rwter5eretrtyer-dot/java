# КТ №2 — Веб-приложение на Spring MVC

Продолжение КТ №1: та же сервисная логика и хранилище в памяти. Добавлен контроллер REST API, отработка статусов HTTP, фильтрация и статистика.

```bash
mvn spring-boot:run
```

Запросы: `GET /tasks`, `GET /tasks/{id}`, `GET /tasks?status=NEW`, `GET /tasks?priority=HIGH`, `GET /tasks/stats`, `POST /tasks`, `PUT /tasks/{id}`, `PATCH /tasks/{id}/status`, `DELETE /tasks/{id}`.

```bash
curl -X POST http://localhost:8080/tasks -H 'Content-Type: application/json' -d '{"title":"Начать проект","priority":"HIGH"}'
curl http://localhost:8080/tasks
curl -X PATCH http://localhost:8080/tasks/1/status -H 'Content-Type: application/json' -d '{"status":"DONE"}'
```

В `controller/TaskController.java` нет бизнес-логики — она находится в `service/`.
