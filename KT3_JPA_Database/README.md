# КТ №3 — База данных Spring MVC

Самостоятельная JPA-версия веб-приложения из КТ №2. `TaskController.java` сохранён без изменений, но хранилище заменено на `JpaRepository` с H2 на диске. Spring Data JPA создаёт таблицы при первом запуске (`ddl-auto: update`); SQL-скрипт для проверяющего приложен отдельно.

```bash
mvn spring-boot:run
```

**Открыть** `http://localhost:8080/h2-console`, URL `jdbc:h2:file:./data/taskflow`, user `sa`, password пустой.

**Обязательные артефакты:** `database/schema.sql`, `database/sample_queries.sql`, `database/ER_diagram.png`.

**Поиск и пагинация:** `/queries/search?keyword=...`, `/queries/paged?page=0&size=3&sort=id`.

API КТ №2 сохранён: `GET/POST/PUT/PATCH/DELETE /tasks`, фильтры статуса и приоритета, статистика `/tasks/stats`.

Для SQLite/PostgreSQL SQL отличается: приведённый скрипт предназначен для H2, которой пользуется эта учебная версия.
