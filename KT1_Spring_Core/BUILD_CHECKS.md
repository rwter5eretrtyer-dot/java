# Проверка проекта

Требования: JDK 21 и Maven 3.9+.

```bash
java -version
mvn -version
mvn -U clean test
mvn clean package
```

Если Интернет недоступен, сначала обеспечьте доступ к Maven Central для загрузки зависимостей.

```bash
mvn spring-boot:run
```

Для итогового Task Atlas при необходимости дополнительно проверьте:

```bash
docker compose up --build
```
